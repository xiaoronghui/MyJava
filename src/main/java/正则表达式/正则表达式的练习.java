package 正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 正则表达式的练习 {

	public static void main(String[] args) {
		
		/**
		 * \b的用法
		 * 
		 * 先匹配到abc,如果找到了则看看a的前面,c的后面是否是(字母、数字、汉字、下划线),如果不是,则认为abc是个独立的单词,然后捕获.
		 * 从而\b是单词边界.  只要不是(字母、数字、汉字、下划线),那么就是单词边界.(作为单词边界的通常有 空格,-,~.. )
		 */
//		find("\\babc\\b", "iwant ~abc you");
		
		/**
		 * \B的用法
		 * 
		 * 先匹配到abc,如果找到了则看看a的前面,c的后面是否是(字母、数字、汉字、下划线),如果是,则捕获.
		 * 从而\B是非单词边界.  只要是(字母、数字、汉字、下划线),abc就不是一个独立的单词
		 */
//		find("\\Babc\\B", "iwantabcyou");
		
		/*
		 *  "."和"\\."的区别 :     "."表示匹配除\n外的任意字符 ,  "\\."表示匹配字符"."
		 * */
//		match(".*", "afsafd");
//		match("\\.*", "0...");
		
		/**
		 * ^和$的理解:
		 * 
		 *   ^表示匹配紧接在后面的那个子表达式开头
		 *   
		 *   $表示匹配紧接在前面的那个子表达式结尾
		 */
//		match("^\\d+\\w*\\s*$","2234sd ");   //这个表示必须以数字开头,空格结尾
//		match("^(\\d+\\w+)\\s*$","2234sd "); //这个表示必须以数字+字母开头,空格结尾
		
//		match("(布尔型|关系运算|数值区间|时间区间)","布尔型"); 
//		match("(<|<=|>|>=|=|≠)","≠"); 
//		match("([a-zA-Z]+)","a234");
		find("(?i)(http://)([^/]+)", "hTTp://blog.csdn.net/libo2006/article/details/1542326");
	}
	
	//通用测试
	public static void match(String patternStr , String str){
	 	 Matcher m = Pattern.compile(patternStr).matcher(str);
		 System.out.println("matches : "  + (m.matches() ? true + " group : " + m.group() :  false));
	}
	
	//find通用测试
	public static void find(String patternStr , String str){
	 	 Matcher m = Pattern.compile(patternStr).matcher(str);
	 	 while(m.find()){
	 		System.out.println(m.group()); 
	 	 }
	}
	
	/**
	 * 检测userAgment是否为移动端
	 */
	public  boolean checkMobilSystem(String userAgent){
		
		 String phoneReg = "\\b(ip(hone|od)|android|opera m(ob|in)i"
				 							+"|windows (phone|ce)|blackberry"
				 							+"|s(ymbian|eries60|amsung)|p(laybook|alm|rofile/midp"
				 							+"|laystation portable)|nokia|fennec|htc[-_]"
				 							+"|mobile|up.browser|[1-4][0-9]{2}x[1-4][0-9]{2})\\b";
		 
	     String tableReg = "\\b(ipad|tablet|(Nexus 7)|up.browser"
	    		 					    +"|[1-4][0-9]{2}x[1-4][0-9]{2})\\b";
	     
	   //移动设备正则匹配：手机端、平板
	     Pattern phonePat = Pattern.compile(phoneReg, Pattern.CASE_INSENSITIVE);
	     Pattern tablePat = Pattern.compile(tableReg, Pattern.CASE_INSENSITIVE);
	     
	     if( userAgent == null) userAgent = "";
	        
	     // 匹配
        Matcher matcherPhone = phonePat.matcher(userAgent);
        Matcher matcherTable = tablePat.matcher(userAgent);
        
        return matcherPhone.find() || matcherTable.find();
		
	}
	
	
	 /**
     * 验证文本是否是合法的邮箱格式
     * create by ronghui.xiao @2016-04-22
     */
    public static boolean isEmail(String text){
        return text != null && Pattern.compile("^([a-zA-Z0-9]+[_|\\_|\\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\\_|\\.]?)*[a-zA-Z0-9]+\\.[a-zA-Z]{2,3}$*").matcher(text).matches();
    };


    /**
     *  验证文本是否是合法的手机号
     * create by ronghui.xiao @2016-04-22
     */
    public static boolean isMobileNumber(String text){
        return text != null && Pattern.compile("^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\\d{8})$").matcher(text).matches();
    };


    /**
     * 验证文本是否是合法的固定电话
     * create by ronghui.xiao @2016-04-22
     */
    public static boolean isTelephoneNumber(String text){
        return text != null && Pattern.compile("^((0\\d{2,3})-)(\\d{7,8})(-(\\d{3,}))?$").matcher(text).matches();
    };
}
