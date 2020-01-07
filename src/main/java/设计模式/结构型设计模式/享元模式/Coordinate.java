package 设计模式.结构型设计模式.享元模式;

//坐标
public class Coordinate {
	
	public Coordinate(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	private int x;
	
	private int y;

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
	
}
