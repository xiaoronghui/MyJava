package Java基础.抽象类;

public abstract class Animal {
	String name;
	public abstract void run();  //抽象方法的意义:将方法的设计和实现分离
	public void eat(){
		System.out.println("吃吃吃..");
	}
}

class Cat extends Animal{

	public void run() {
		System.out.println("走着猫步..");
	}
	
}