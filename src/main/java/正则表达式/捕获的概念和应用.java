package 正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 *    参考: http://www.cnblogs.com/yakun/p/3795589.html
 *    
 *    捕获 :

			要明白捕获，得先从分组开始。重复单字符我们可以使用限定符，如果重复字符串，用什么呢？ 对！用小括号，
			
			小括号里包裹指定子表达式，这就是分组。之后就可以限定这个子表达式的重复次数了。

			那么，什么是捕获呢？使用小括号指定一个子表达式后，匹配这个子表达式的文本（即匹配的内容）可以在表达式或者其他过程中接着用，
			
			怎么用呢？至少应该有个指针啥的引用它吧？ 对！默认情况下，每个分组（小括号）会自动

			拥有一个组号,从左到右，以分组的左括号为标志，第一个出现的分组组号为1，后续递增。如果出现嵌套，也是从左到右从外到里.
 *   
 *    例如: 正则表达式(a(b))(c)调用matches匹配字符串abc
 *            
 *                   分组                          捕获
 *                   
 *             分组0(abc)                      abc     //group(0)和group()获取捕获的内容
 *                   
 *             分组1(ab) :                      ab       //使用group(1)获取捕获的内容,
 *             
 *             分组2(b) :                        b
 *             
 *             分组3(c) :                        d
 *     
 *     注: 
 *     
 *           从源码可以得知,当捕获到字符串的时候,会把当前字符串的索引给记下来,使用group(int)来获取哪个分组捕获的字符串,
 *          
 *           获取的捕获内容的时候,根据分组找到索引,然后根据索引从原字符串把字符截取下来.
 *      
 *    非捕获是什么意思呢?
 *    
 *          通常正则限定符执行之后会把匹配到的字符串捕获下来(就是记下索引).但是有写限定符是可以进行匹配,但是不进行捕获.
 *          
 *          这些限定符的格式为:  
    		
    		  (?:)  , (?=) ,  (?<=)  , (?!) , 	(?<!)    //案例参考main方法.后面4个符号只适用于find方法
    		
    由下面一个例子引发对非捕获组的学习:
			
			有两个金额：6000￥ 和 1000$。	需求是得到金额和货币种类。
		    正则表达式：　(\d+)+([$￥])　
			
			匹配组结果为：
			
				OK,满足了要求。这里的正则分成了两个组，一个是(d+)，一个是(￥$)，前一个组($1)匹配金额，后一个组($2)匹配货币种类。
			
				现在，需求变了!! 我需要这个正则同时可以匹配浮点数小数点前面的整数。如10010.86￥，提炼出 10010 和 ￥。
			
			那么正则如下：
			
				(\d+)(\.?)(\d)([$￥]) 
			
			这里用括号分了四组，所以要输出金额的整数部分和种类，要分别输了$1,$4了。如果输出部分和正则是分开的，我希望只修改正则而不去修改输出部分的代码，也就是还是用$1，$2作为输出。由此可以引出非捕获组(?:)。
			
			把前面的正则修改为：
			
			(\d+)(?:\.?)(?:\d+)([￥$])$ 
			
			这样，还是用$1,$2做为输出，同样输出了 10010 和 ￥
			
			这个正则的中间两个组用到的就是非捕获组（?:），它可以理解为只分组而不捕获。	
       		
       		注:在括号里面的才能被捕获
 *        
 */
public class 捕获的概念和应用 {
	
	
	public static void main(String[] args) {
//			
//		String str = "<script>location.href=alert(1);</script>";
//		
//	    System.out.println(str.replaceAll("<script>","").replaceAll("</script>", ""));
//		String reg = "(<script>)\\.*(</script>)";
//		Matcher m = Pattern.compile(reg).matcher(str);
//		System.out.println(m.matches());
		
		/*验证是否是数字*/
//		String reg = "(((\\d+)(\\.?)(\\d+))|(\\d+))";
//		String a = "3.366";
//		Matcher m = Pattern.compile(reg).matcher(a);
		
//		match("((a(b))(c))", "abc");
		
		/*我们只想得到102.62￥整数和符号,所以我们只需要捕获整数部分和符号就行了*/
//		match("(\\d+)(?:\\.?)(?:\\d+)([$￥])", "102.62￥");
		
		/*捕获access_token的综合应用*/
//		String str = "{\"access_token\":\"I7vvONuThA6aL2Kl053QuJYAoySiHVUUHCoUaQeK3_1u39-1Va4_Y7krwmoeRKLGw6M5Z_0FQYm9l4ZOvBWASzMKZoCbVbggAW2gVqpXA78ptT00r8_Q11j7DiBhgdwLOFOdAJAXOX\",\"expires_in\":7200}";
//		String patternStr = "(?:.?access_token\":\")([^\"]+).*";
//	 	Matcher m = Pattern.compile(patternStr).matcher(str);
//	 	if(m.find() && m.groupCount() >= 1){
//	 		System.out.println(m.group(1));
//	 	}
		
//		getFindString2Arr();
		/**
		 * 如果后面是aa,则捕获aa前面的子表达式所匹配的字符串
		 */
//		find("[0-9a-z]{2}(?=aa)", "12332aa438aaff");  
		
		/**
		 *  如果前面是aa,则捕获aa后面的子表达式所匹配的字符串  
		 */
//		find("(?<=aa)[0-9a-z]{3}", "12332aa438aa5");   
		
		/**
		 * 如果前面是aa,则捕获aa和aa后面的子表达式所匹配的字符串  
		 */
//		find("(?=aa)[0-9a-z]{3}", "12332aa438aa5");

		/**
		 * 如果两个字符后面不是aa,则捕获这两个字符.
		 */
//		find("[0-9a-z]{2}(?!aa)", "12332aa438aa5");   
		
		/**
		 * 如果两个字符前面不是aa,则捕获这两个字符
		 * 下面两个是等价的
		 */
//		find("(?<!aa)[0-9a-z]{2}", "12332aa438aa5");   
//		find("(?!aa)[0-9a-z]{2}", "12332aa438aa5");   
		
	}
	
	
	//查询自己所需要的字符串实战应用
	public static void getFindString2Arr(){
		String abc = "<td class=\"nums\">                        <i class='pk-no3' data-no=\"3\"></i>                                        <i class='pk-no6' data-no=\"6\"></i>                                        <i class='pk-no1' data-no=\"1\"></i>                                        <i class='pk-no7' data-no=\"7\"></i>                                        <i class='pk-no10' data-no=\"10\"></i>                                        <i class='pk-no4' data-no=\"4\"></i>                                        <i class='pk-no9' data-no=\"9\"></i>                                        <i class='pk-no8' data-no=\"8\"></i>                                        <i class='pk-no5' data-no=\"5\"></i>                                        <i class='pk-no2' data-no=\"2\"></i>                                </td>";
		String reg = "(?:pk-no)([0-9]+)";
		Matcher m = Pattern.compile(reg).matcher(abc);
		StringBuilder sb = new StringBuilder();
		while(m.find() && m.groupCount() >= 1){
			sb.append("-").append(m.group(1));
		}
		System.out.println(sb.substring(1));
	}
	
	//find通用测试
	public static void find(String patternStr , String str){
	 	 Matcher m = Pattern.compile(patternStr).matcher(str);
	 	 while(m.find()){
	 		 for(int i = 0 ; i <= m.groupCount()  ; i ++){
	 			 System.out.println("-------------"+i+"------------------");
	 			 System.out.println(m.group(i));
	 		 }
	 	 }
	}
	
	//通用测试
	public static void match(String patternStr , String str){
		Matcher m = Pattern.compile(patternStr).matcher(str);
		System.out.println("matches : "  + m.matches());
		if(m.matches() ){
			for(int i = 1;  i <= m.groupCount() ; i ++){
				System.out.println(m.group(i));
			}
		}
	}
	
}
