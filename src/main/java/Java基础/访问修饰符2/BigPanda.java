package Java基础.访问修饰符2;

import Java基础.访问修饰符1.Panda;

public class BigPanda extends Panda{
	
	public static void main(String[] args) {
		/*
		    父类Panda的4个属性
			String name;
			private String sex;
			protected int  age;
			public String hobby
		*/;
		BigPanda bigPanda=new BigPanda();
		//name被default修饰,只能在同一包的子孙实例访问
		//System.out.println(bigPanda.name);
		//sex被private修饰,只能在本类的内部使用
		//System.out.println(bigPanda.sex);
		//age被protected修饰,能被同一包的子孙实例访问且能被子孙访问;
		System.out.println(bigPanda.age);
		//hobby被public修饰,所有子孙实例都能访问hobby属性
	    System.out.println(bigPanda.hobby);
	    /*
	        父类Panda的四个方法,被四种修饰符修饰
		    void fun1(){
				System.out.println("我是fun1");
			}
			private void fun2(){
				System.out.println("我是fun2");
			}
			protected void fun3(){
				System.out.println("我是fun3");
			}
			public void fun4(){
				System.out.println("我是fun4");
			}
	     */;
	     //fun1被default修饰,只能在同一包的子孙实例访问
	     //bigPanda.fun1();
	     //fun2被private修饰,只能在本类的内部使用
	     //bigPanda.fun2();
	     //fun3被protected修饰,能被同一包的子孙实例访问且能被子孙访问;
	     bigPanda.fun3();
	     //fun4被public修饰,所有子孙实例都能访问fun4
	     bigPanda.fun4();
	}
}
