package Java基础.字符串;

public class 字符串内存分析 {
	static String abc="sss";
	public static void main(String[] args) {
		/*
		 	1) 当执行的时候首先会加载"字符串内存分析"类和该类中的字面常量(类里所有地方的字面常量都加载),字符常量"abcd","def"都被加载进了方法区中
		 	2) String str=new String("abcd");的时候,在堆中创建一个字符串对象,先从方法区中寻找"abcd"是否存在,存在则赋值
		 	   给该字符串对象的value属性,然后把该字符串对象的首地址赋值给栈中的str变量;
		 	3) String str2=new String("abcd");的时候,又在堆中创建一个字符串对象,先从方法区中寻找"abcd"是否存在,存在则赋值
		 	    给该字符串对象的value属性,然后把该字符串对象的首地址赋值给栈中的str变量;
		 	4) String重写了equals方法,只比较值是否相等,所以str.equals(str2)返回true
		 	5) str和str2指向的是不同的地址,而"=="号即比较地址又比较值,从而str==str2返回fasle;
		 	6) String str3="def";的时候,在方法区中找到了"def",然后把def的地址赋值给str3
		 	7) String str4="def";的时候,在方法区中找到了"def",然后把def的地址赋值给str4
		 	8) 因为str3和str4指向的是同一个地址,且值相等,从而str3==str4返回true;
		 */
		String str=new String("abcd");
		String str2=new String("abcd");
		System.out.println(str.equals(str2)); //equal之比较值是否相等
		System.out.println(str==str2); //"=="号即比较值是否相等,又比较地址是否相等
		String str3="def";
		String str4="def";
		System.out.println(str3==str4);
		String str5="sss";
		System.out.println(str5== 字符串内存分析.abc); //由此证明了类里所有地方的字面常量都加载
	}
}
