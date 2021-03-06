package Java基础.数据类型;

public class 整型 {
	public static void main(String[] args) {
		
		//---------------------整型-------------------------------------
		int a=10; //10进制赋值
		int b=0010; //二进制进制赋值
		int c=0xf; //十六进制赋值
		System.out.println("a="+a+" b="+b);
		
		//---------------------整型转二进制,十六进制,8进制的表示-----------------
		System.out.println("二进制:"+Integer.toBinaryString(a));
		System.out.println("十六进制:"+Integer.toHexString(a));
		System.out.println("八进制:"+Integer.toOctalString(a));
		
		//整型二进制最大值和最小值
		System.out.println("二进制最大值:" + Integer.toBinaryString(Integer.MAX_VALUE));
		System.out.println("二进制最小值:" + Integer.toBinaryString(Integer.MIN_VALUE));
		
		//-----------------------整型的表示范围-----------------------------------
		 /*  
		   --整型:
		         类型      占用存储空间 	范围
		         byte      1个字节            -128-127
		         short     2个字节            -32768-31757
		         int         4个字节            约21亿  //我们也可以用二进制,8进制,16进制来给int赋值,比如0xf -->15 
		         long      8个字节            -2^65-2^65-1
		         如果你觉得long类型还不够用,java里面有个叫BigDecimal的类
		 */
		//------------------------整型常量----------------------------------
		//比如 int d=20; d是变量,20就是整型常量,可以这么说-->整型数据默认的类型就是int类型
		/*
			100是整型,那为什么可以赋值给byte类型的a1? 
			  若数据表述的大小没有超过byte/short/char的表述范围,则自动转型
		*/
		byte a1=100;  
		
	/*	
	  	为什么123234235345345赋值给长整型a2会报错?
	  	  123234235345345默认是整型,但是超过了整型的表示范围,从而报错.
	  	  若果想给长整型赋值,则需这样 a2=123234235345345L;加上一个L,这样就表示先把123234235345345转化
	  	  为长整型,然后赋值给a2,这样级不会报错.L也可以小写,但是不建议这么做;
	 */
		//long a2=123234235345345; //报错 
		long a2=123234235345345L; //正确的写法
		long a3=123234235345345l; //L不建议用小写,容易和1混淆
		
		//----------------------------------------------------------
		//----------------------------------------------------------
	}
}
