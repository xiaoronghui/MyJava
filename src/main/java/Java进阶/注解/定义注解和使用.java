package Java进阶.注解;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@MyAnnotation
public class 定义注解和使用 {
	public static void main(String[] args) {
		
		
		
		//是否包含注解MyAnnotation
		if(定义注解和使用.class.isAnnotationPresent(MyAnnotation.class)){
			//获取这个注解
			MyAnnotation annotation=定义注解和使用.class.getAnnotation(MyAnnotation.class);
			System.out.println(annotation);
		}
	}
}

//定义一个注解
/*
 * @Retention 元注解(注解类的注解称之为元注解) 
 * 用来表示这个注解类的在哪些个阶段有效
 * RetentionPolicy是个枚举
 * RetentionPolicy.RUNTIME 注解一直保留到运行期间,也就是一直保留到二进制码中
 * RetentionPolicy.SOURCE   注解只保留在原文件中
 * RetentionPolicy.CLASS     注解一直保留到class字节码文件中
 * @Target 表示在哪些地方可以使用
 * ElementType是个枚举
 * ElementType.METHOD表示在方法上面可以使用
 * ElementType.TYPE表示在类型上面可以使用(接口,类,注解,枚举都实现了Type接口,从而用TYPE表示在接口,类,注解,枚举都可以使用该注解) 
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})  //由提示得知参数是一个数组
@interface MyAnnotation{
	
}