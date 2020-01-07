package Java基础.访问修饰符2;
import Java基础.访问修饰符1.Sheep;

public class Test {
	public static void main(String[] args) {
		//访问修饰符1包中Horse被default修饰,只能在本类和本包中被访问,从而这里不能访问;
	    // Horse horse=new Horse(); 
		//访问修饰符1包中Sheep被public修饰,能被所有的地方使用
		Sheep sheep=new Sheep();
		//
	}
}
