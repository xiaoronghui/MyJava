package Java基础.内部类;
import Java基础.内部类.Face.Nose;

public class Test {
	public static void main(String[] args) {
		// Nose nose=new Nose();	 //非静态内部类无法直接访问
		Face f=new Face();
		f.type="外部类";
		Nose nose=f.new Nose(); //非静态内部类只能这么访问
	    nose.type="内部类";
	    nose.breath();
	    //静态内部类
	    Face.Mouth mouth=new Face.Mouth();
	}
}

class Face{
	String type;
	String cry="哇哇哇";
	static String hobbyFood="饭";
	//Nose内部类相当于Face类的一个属性,只有Face的实例才能创建Nose的实例
	class Nose{
		//static abc; //内部类不能定义static属性和方法,否则报错
		String type;
		void breath(){
			//Face.this.type表示找到Face类的当前对象,再找到type属性
			System.out.println("呼吸.."+this.type+"--->"+Face.this.type);
		}
	}
	static class Mouth{
		String type;
		void eat(){
			//System.out.println(cry);静态内部类不能访问非静态的属性
			System.out.println("吃东西.."+hobbyFood);//可以访问静态的属性
		}
	}
	public static void fuck(){
		//既然内部类是外部类的一个属性,从而静态方法不能访问非静态属性
		//Nose nose=new Nose();
		//静态方法可以访问静态内部类
		Mouth mouth=new Mouth();
		System.out.println("尼玛,真烦:");
	}
	public void hello(){
		//普通方法可以访问
		Nose nose=new Nose(); 

	}
}
