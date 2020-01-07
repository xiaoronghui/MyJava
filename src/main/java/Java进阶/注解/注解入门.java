package Java进阶.注解;

import java.util.HashMap;
import java.util.Map;

public class 注解入门 {
	public static void main(String[] args) {
		/*
		 * 1.注解相当于一种标记,在程序中加了注解就等于为程序打上了某种标记,没加,则等于没有某种标记,
		 * 以后,javac编译器,开发工具和其他程序可以用反射来了解你的类及各种元素上有无何种标记,就去
		 * 干相应的事.标记可以加在包,类,字段,方法的参数以及局部变量上
		 * 2.注解就相当于一个你的源程序中要调用的一个类,要在源程序中引用某个注解,得先准备这个注解类.就像你要调用
		 * 某个类,得先开发好这个类
		 * 
		 *
		 *
		 **/
	}
	
	@Deprecated
	public void sayName(String Name){
		System.out.println("这是一个过时的方法,使用注解@Deprecated表示");
	}
	
	@Override
	public  boolean equals(Object obj){
		System.out.println("使用@Override来注解这个方法是重写的,若是不符合重写规则,则会编译报错");
		return true;
	}

	@SuppressWarnings("all")
	public void test1(){
		Map map=new HashMap(); //参数化泛型警告
		System.out.println("使用@SuppressWarnings('all')去除所有的警告!");
	}

	
	
	
	
}
