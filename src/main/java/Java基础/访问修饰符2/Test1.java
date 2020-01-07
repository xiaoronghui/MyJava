package Java基础.访问修饰符2;
import Java基础.访问修饰符1.Bear;

//Test1继承Bear类
public class Test1 extends Bear {
	public void happy(){
		//访问使用protected修饰的内部类
		Bear_animal bear_animal=new Bear_animal();
	}
}
