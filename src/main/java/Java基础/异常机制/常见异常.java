package Java基础.异常机制;

public class 常见异常 {
	public static void main(String[] args) {
		//算术异常 ArithmeticException
		try {int i=3/0;} catch (Exception e) {e.printStackTrace();}
		//空指针异常 NullPointerException
		try {String a=null; a.trim();} catch (Exception e) {e.printStackTrace();}
		//数组下标越界异常 ArrayIndexOutOfBoundsException
		try {int[] arr=new int[2]; arr[5]=5;} catch (Exception e) {e.printStackTrace();}
		//转化为数字异常 NumberFormatException
		try {Integer.parseInt("abc");} catch (Exception e) {e.printStackTrace();}
		//类型转化异常 ClassCastException -->java.lang.Object cannot be cast to java.lang.Integer
		try {Integer n=(Integer)new Object();} catch (Exception e) {e.printStackTrace();}
		
			
		
	}
}
