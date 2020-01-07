package Java进阶.注解;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;

@AnnotationHasProperty("草泥马")  //当注解上只有一个属性的时候,默认是value属性,不用写属性名
public class 拥有属性的注解类 {
	public static void main(String[] args) throws Exception{
		Class clazz=拥有属性的注解类.class;
		//获取类上面的注解
		AnnotationHasProperty ant=(AnnotationHasProperty) clazz.getAnnotation(AnnotationHasProperty.class);
		System.out.println(ant.value());
		System.out.println(ant.color());  //默认值
		System.out.println(Arrays.toString(ant.arrayAttr())); //默认值
		
		//获取方法上面的注解
		AnnotationHasProperty methodAnt=clazz.getMethod("test1").getAnnotation(AnnotationHasProperty.class);
		System.out.println(methodAnt.value());
		System.out.println(methodAnt.color());  //默认值
		System.out.println(Arrays.toString(methodAnt.arrayAttr())); //默认值
		
		//获取方法上面的注解
		AnnotationHasProperty methodAnt1=clazz.getMethod("test3").getAnnotation(AnnotationHasProperty.class);
		System.out.println(methodAnt1.value());
		System.out.println(methodAnt1.color());  //默认值
		System.out.println(Arrays.toString(methodAnt1.arrayAttr())); //默认值
		System.out.println(methodAnt1.enumColor().name()); //注解的枚举属性
		System.out.println(methodAnt1.antm().value()); //注解的注解属性
		
		
	}
	
	@AnnotationHasProperty(color="red",value="你麻痹",arrayAttr={3,4,5})
	public static void test1(){
		
	}
	
	//当数组属性只有一个值的时候,可以直接写成arrayAttr=1
	@AnnotationHasProperty(color="red",value="你麻痹",arrayAttr=1) //
	public static void test2(){
		
	}
	@AnnotationHasProperty(value="最后一个测试",enumColor=ColorEnum.RED,antm=@AnnotationMeta("要睡觉了")	) //
	public static void test3(){
		
	}
}

/*
 * 拥有属性的注解类
 * 
 * 
 * 
 * */
@Retention(RetentionPolicy.RUNTIME) //运行时有效
@Target({ElementType.TYPE,ElementType.METHOD})  //TYPE类型上可以使用,方法上可以使用
@interface AnnotationHasProperty{
	//String 类型的属性,属性名为color
	String color() default "blue";  //默认为蓝色,若是不填默认值,则该属性必填
	//可以作为默认值的属性
	String value();
	//数组属性
	int[] arrayAttr() default {1,2,3};
	//枚举类型 属性
	ColorEnum enumColor()  default ColorEnum.RED;
	//注解类型属性
	AnnotationMeta antm() default @AnnotationMeta("哈哈"); //默认值是注解的一个实例
	
}

@Retention(RetentionPolicy.RUNTIME) //运行时有效
@Target({ElementType.TYPE,ElementType.METHOD})  //TYPE类型上可以使用,方法上可以使用
@interface AnnotationMeta{
	String value();
}

enum ColorEnum{
	RED("红色"),BLUE("蓝色"),YELLOW("黄色");
	private String name;
	private ColorEnum(String name){
		this.name=name;
	}
	public String getName(){
		return this.name;
	}
}


