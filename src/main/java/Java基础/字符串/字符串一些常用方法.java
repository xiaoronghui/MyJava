package Java基础.字符串;

public class 字符串一些常用方法 {
	public static void main(String[] args) {
		String str="  aa bb  ";
		System.out.println(str.trim()); //trim去除字符串首尾空格
		System.out.println("ABcd".equalsIgnoreCase("abcd")); //equalsIgnoreCase忽略大小写比较值是否相等
		System.out.println("abcd".indexOf("b"));  //字符"b"第一次出现的位置
		System.out.println("abcbd".lastIndexOf("b")); //字符b最后一次出现的位置
		System.out.println("abcd".startsWith("ab")); //字符串是否以"ab"起头
		System.out.println("abcd".endsWith("cd")); //字符串是否以"cd"结尾
		/*
		 	打开String的源码,我们可以看到private final char value[];属性,这个value属性是私有的且被final修饰,
		 	也就是value只能被赋值一次,以后再也无法被修改.
		 	从而我们得知,字符串是不可变的字符序列,当操作调用字符串函数返回一个新字符串的时候,这个新字符串
		 	就是一个新的对象.
		 	当我们使用"+"号做字符串拼接的时候就会产生新的字符串
		 	比如: "a"+"b"="ab"  -->"ab"是一个新的字符串对象
		 	结论:
		 	    1)　如果字符串拼接的数量很多的话,是很浪费内存的行为.
		 	    2)　字符串的字符串操作的方法，如果返回一个新字符串，那么就是一个新的字符串对象．
		 */
		String str1="a";
		for(int i=0;i<10;i++){
			str1+=i;
			System.out.println(str1.hashCode());
		}
		System.out.println(str1);
	}
}
