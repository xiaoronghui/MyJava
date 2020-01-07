package Java基础.关键字;

public class this关键字 {
	String name;
	int age;
	
	//构造方法中可以通过this可以区分两个name
	public this关键字(String name,int age){
		this(name);//通过this调用其他的构造方法,必须位于构造方法的第一句;
		this.age=age;
	}
	public this关键字(String name){
		this.name=name;
	}
	
	/*
	 * 普通方法中,都隐式的传递了this和super(父类)两个对象,为什么呢? 
	 *   实例对象中的方法总是指向方法区中的方法,在调用执行方法的过程中,可能会使用到对象的属性.然而,
	 * 方法区中的方法如何知道你使用的属性是哪个对象的呢?原因就是隐身的传入了当前对象;父类也被隐式的
	 * 传入了;
	 */
	public void say(String word){
		System.out.println(name+"说:"+word);
	}
	
	public static void sayHello(){
		//static方法不会隐式的传入this对象,所以无法使用this;static针对的是所有对象,不允许针对某个对象;
		//this.name; 
		System.out.println("hello,world!");
	}
}
