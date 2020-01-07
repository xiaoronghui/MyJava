package Java基础.访问修饰符1;

public class Panda {
	String name="张飞";
	private String sex="男";
	protected int  age=12;
	public String hobby="足球";
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
	
	public void sayName(String name){
		System.out.println("我是:"+name);
	}
	public static void main(String[] args) {
		Panda panda=new Panda();
		//sex被private修饰,只能被类中的实例使用
		System.out.println(panda.sex); 
		BigPanda bigPanda=new BigPanda();
		//子孙实例是无法访问private修饰的变量
		//System.out.println(bigPanda.sex);
	}
}
