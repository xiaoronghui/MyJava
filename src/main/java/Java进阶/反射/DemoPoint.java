package Java进阶.反射;

public class DemoPoint {
	private int x; //私有的x
	public int y;  //公有的y
	public String str1;
	public String str2;
	
	public DemoPoint() {
	}
	public DemoPoint(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	//这个类中的main方法
	public static void main(String[] args) {
		System.out.println("我是DemoPoint类中的main方法,you success!");
	}
}	
