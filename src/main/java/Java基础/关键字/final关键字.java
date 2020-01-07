package Java基础.关键字;

import java.util.HashMap;

public class final关键字 {
	public static void main(String[] args) {
		
		//修饰变量则表示该变量是个常量,约定使用大写字母和下划线来定义常量
		final int MAX_SPEED=300; 
		
		final HashMap map = new HashMap();
		
		/**
		 * 当一个局部内部类访问类的局部变量时，那么这个变量就要声明为final类型，否则不能通过编译。
		 *  原因 : 
		 *    1.首先内部类会编译成一个独立的class文件
		 *    2.局部变量会作为内部类的构造参数传入,且会作为一个私有属性.根据类的封装性,我们无法再外部去修改一个类的私有属性,
		 *       如果外部依然可以改变它,则违反了封装性的规则.为了遵循封装性的规则,我们需把外部的局部变量定义为final;
		 */
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				map.put("张飞", "123");  //new Runnable()是实例化局部匿名的内部类,使用外部的变量必须是final类型
			}
		},"t1");
		
	}
}

class Animal1{
	String eyes;
	public void run(){
		System.out.println("我会跑哦..");
	}
	//eat方法被final关键字修饰
	public final void eat(){
		System.out.println("我会吃...");
	}
}
//被final修饰的类无法被继承
final class  taijian{
	
}

class Cat1 extends Animal1{
	//被final修饰的方法无法被重写
	/*public  void eat(){
		System.out.println("我会吃...");
	}*/
	
	//但是可以被重载
	public final void eat(String name){
		System.out.println("我会吃...");
	}
}
