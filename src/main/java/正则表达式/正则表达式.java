package 正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 正则表达式 {
	
	public static void main(String[] args) {
		
		/*测试正则符号^的用法*/
		//test1();
		
		/*测试以正则表达式分割字符串的方法*/
		//testSpilt();
		
		/*测试匹配a标签*/
		//matchATag();
		
		//如果要匹配不包含的字符,必须用[^字符]这种格式,因为只有这种格式,不符合规则的"^"符号的用法是没用的.
//		match("((A)(B(C)))","ABC");  //((A)(B(C)))等价于"ABC",首先必须匹配括号里面的东西,然后有必须匹配小括号里面的东西,从而等价于ABC
		
		/*测试lookingAt方法*/
//		testLookintAt("1223asdf");
//		testLookintAt("as1223df");
//		testLookintAt("asdf");
		
		/*测试find方法*/
//		testFind("3234asdf");
//		testFind("as3234df");
//		testFind("asd");
		
		/*运用find方法,找到隐藏在其中的手机号*/
//		useFind("186sdfsd5713fdsgdfgdf4fdgdfg7sdfd58");  
		
		/*测试start,end,group方法*/
//		testStartEndGroup("234fuck234");   
		
		/**
		 * 贪婪模式和非贪婪模式
		 */
//		testGreedyModel("\\d+","213");  //返回213
//		testGreedyModel("\\d+?","213");  //返回2
//		testGreedyModel("\\d*?","123");  //返回空字符串
		
		String reg = "^(\\(*\\d+(.\\d+)*\\)*(\\+|-|/|\\*))+\\d+(.\\d+)*\\)*$";
		String str = "(8.33+6-9)*(9+7)";
		
		Matcher m1 = Pattern.compile("\\(").matcher(str);
		Matcher m2 = Pattern.compile("\\)").matcher(str);
		
		boolean flag = true;
		
		while((m1.find() && (flag = m2.find()))){
		}
		
		flag = flag  && m2.find() ? false : flag; 
		
		System.out.println(flag);
	}
	
	//通用测试
	public static void match(String patternStr , String str){
	 	 Matcher m = Pattern.compile(patternStr).matcher(str);
		 System.out.println("matches : "  + (m.matches() ? true + "group : " + m.group() :  false));
	}
	
	/**
	 * 贪婪模式:
	 * 
	 *   当我们直接使用*, +, ?, {n}, {n,}, {n,m}这些符号时,匹配模式称之为贪婪模式,当我们使用find的时候会尽可能多的找到符合
	 *   表达式的字符串.然后返回.  
	 *  
	 *  非贪婪模式: 
	 *   
	 *    当我们在*, +, ?, {n}, {n,}, {n,m}这些符号的后面加上?号时,匹配模式称之为非贪婪模式.当我们使用find的时候尽可能少的找到
	 *    符合表达式的字符串,立马返回.
	 *    
	 *   案例:
	 *     比如"\\d+"使用find方法匹配"213",按照尽可能多的找到符合表达式的字符串,从而返回结果213.
	 *     而表达式"\\d+?"使用find方法匹配213的,按照尽可能少的找到符合表达式的字符串,从而返回结果2.
	 */
	public static void testGreedyModel (String patternStr ,  String str){
		Matcher m = Pattern.compile(patternStr).matcher(str);
		if(m.find()){
			System.out.println(true);
			System.out.println(m.group());
		}else{
			System.out.println(false);
		}
		
	}
	
	/**
	 * 测试 start end group方法
	 */
	public static void testStartEndGroup(String str){
		
		/*无参*/
		Matcher matcher= Pattern.compile("\\w+(fuck)\\d*").matcher(str);
		if(matcher.matches()){
			System.out.println("start:" + matcher.start() );  //返回匹配到的子字符串在字符串中的索引位置. 
			System.out.println("end:" + matcher.end() );   //返回匹配到的子字符串的最后一个字符在字符串中的索引位置. 
			System.out.println("group:" + matcher.group() ); //返回匹配到的子字符串 
		}
		
		/*有参,参数是捕获组的编号*/
		System.out.println("==================");
		Pattern p=Pattern.compile("([a-z]+)(\\d+)");  //匹配1个以上a-z任意一个字符,接着匹配1个以上的数字
		Matcher m=p.matcher("aaa2223bb"); 
		m.find();   //匹配aaa2223 
		System.out.println("group:" + m.group() + " groupCount: " + m.groupCount());  //groupCount返回2,因为有2组 
		System.out.println("start(1):" + m.start(1));   //返回0  返回第一组表达式([a-z]+)匹配到的字符串在字符串中的索引号 
		System.out.println("start(2):" + m.start(2));   //返回3 返回第二组表达式(\\d+)匹配到的字符串在字符串中的索引号 
		System.out.println("end(1):" + m.end(1));   //返回3 返回第一组表达式([a-z]+)匹配到的字符串的最后一个字符在字符串中的索引位置. 
		System.out.println("end(2):" + m.end(2));   //返回第二组表达式(\\d+)匹配到的字符串的最后一个字符在字符串中的索引位置. 
		System.out.println("group(1):" + m.group(1));   //返回第一组表达式([a-z]+)匹配到的字符串,返回aaa
		System.out.println("group(2):" + m.group(2));   //返回第一组表达式(\\d+)匹配到的字符串返回2223
		
	}
	
	/**
	 * 利用find找出字符串中的所有数字
	 */
	public static void useFind(String str){
		Matcher m  = Pattern.compile("\\d+").matcher(str);
		String rst = "";
		while(m.find()){
			rst +=m.group();
		}
		System.out.println(rst);
	}
	
	/**
	 * 
	 *	find()对字符串进行匹配,匹配到的字符串可以在任何位置.用来查找字符串是否出现了某个字符,比indexOf更强大
	 */
	public static void testFind(String str){
		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(str);
		System.out.println(matcher.find());
	}
	
	/**
	 * 
	 *	lookingAt()对前面的字符串进行匹配,只有匹配到的字符串在最前面才返回true 
	 */
	public static void testLookintAt(String str){
		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(str);
		System.out.println(matcher.lookingAt());
	}
	
	/*匹配超链接,　(pattern)表达式的使用*/
	public static void matchATag(){
		  //匹配<a或<A靠头,后面接1个以上的空格, 然后匹配href=的格式,后面必须不是>号1个或n个的字符,空格0个或者n个
		//> 中间任意字符0次或者一次,然后以</a>或</A>结尾
		  String urlPattern = "<[aA]\\s+(?:href=[^>]+\\s*)>.*?</[aA]>";
	      Pattern pattern = Pattern.compile(urlPattern);
	      
	      Matcher matcher = pattern.matcher("<a href='abc'>33131</a>");
	      System.out.println(matcher.matches());  
	      System.out.println(matcher.group());  //注:要先调用matches才能使用group
	      System.out.println(pattern.pattern());  //pattern方法返回正则表达式的字符串形式
	}
	
	
	//以空格和逗号分割字符串
	 public static void testSpilt() {
	        Pattern pattern = Pattern.compile("[, ]+");
	        String[] strs = pattern.split("hello world,enen yesyes,, okok");
	        for(String str : strs)
	            System.out.println(str);
	  }

	private static void test() {
		
		//表示匹配以Java开头,任意字符结尾的字符串
		Pattern pattern = Pattern.compile("^Java.*");  //.表示任何字符
        Matcher matcher = pattern.matcher("Java is good");
        
        //结果打印：true
        System.out.println(matcher.matches());
        
        
	}
	
	
}
