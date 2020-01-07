package Java进阶.类加载器;

import java.util.Date;

public class 测试自定义类加载器 {
	public static void main(String[] args) throws Exception {
		//利用自己定义的类加载器去加载指定目录下的类
		MyClassLoader m=new MyClassLoader("F:/workSpace/Java300/testClass");
		Class clazz=m.loadClass("MyDate");
		Date date=(Date) clazz.newInstance();
		System.out.println(date);
	}
}
