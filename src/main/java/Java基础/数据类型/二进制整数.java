package Java基础.数据类型;

public class 二进制整数 {
	public static void main(String[] args) {
		//如果现在是JDK1.7,我用的是JDK1.6从而下面会报错
		//int a=0b00000000000000000000000000000011; //直接给整型a赋值二进制
		//int a=0b0000_0000_0000_0000_0000_0000_0000_0011; 还可以用下划线隔开
		//int a=1_234_1234; //十进制也可以用下滑线隔开
		
		//用二进制给整型赋值,具体是怎么把二进制转成整型的我也不知道
		int a=0101;
		System.out.println(a);
		System.out.println(Integer.toBinaryString(65));
	}
}
