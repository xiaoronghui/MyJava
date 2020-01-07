package Java基础.异常机制;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;


public class 重写的时候抛出异常的原则 {

}
class A{
	public void method() throws IOException{}
} 
class B extends A{
	public void method() throws FileNotFoundException{}
}
class C extends A{
	/*
		子类重写的方法抛出的异常范围不能比父类方法抛出的大
		Exception是所有异常类的父类,范围比父类方法抛出的大,从而会编译异常
	 */
	//public void method() throws Exception{}
}
class D extends A{
	//重写的方法可以不抛出异常
	public void method(){}
}
class E extends A{
	/*
	 	重写的方法可以抛出多个异常,但是范围必须必父类的笑
	 	IOException是一种异常
	 	FileNotFoundException 继承了IOException异常,从而范围没有超出
	 */
	public void method() throws IOException,FileNotFoundException{}
}
class F extends A{
	//子类重写的方法可以同时再抛出几个运行时的异常
	public void method() throws IOException,ArithmeticException{}
}
class G extends A{
	/*
	 	异常分为运行时异常和非运行时异常,如果父类抛出一个非运行时异常,
	 	而子类抛出了2个非运行时异常,且异常的类类型不同,那么就会编译报错
	 */
	//public void method() throws IOException,ParseException{}
}


