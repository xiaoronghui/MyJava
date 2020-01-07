package Java基础.关键字;

public class static关键字 {
	String name;
	public static String sex="undefined";
	public static void sayName(){
		/*
		 * 静态方法从属于类,无法读取非静态的属性,从而这里报错
		 * 方法区存有类的代码信息,static变量,类中字面常量;
		 * 当我们从方法区调用类的静态方法的时候,类中找不到name属性,从而会报错;代码信息只是模板信息,无法使用;
		 * 然而可以在方法区中找到该类的static属性,从而在静态方法中可以使用static变量,而不能使用非static变量;
		 */
		//name="张飞"; 
		sex="男";
	}
	public void hello(){
		/*
		 * hello方法只能被实例对象调用,从而在该实例上可以找到name属性; 
		 * static sex属性在实例对象中找不到,然后就去方法区中找,从而静态属性sex可以被使用;
		 */
		name="张飞";
		sex="男";
		System.out.println("hello,gril!");
	}
	public static void main(String[] args) {
		//静态属性可以通过类名调用
		System.out.println(static关键字.sex);
	}
}
