package 设计模式.行为型设计模式.访问者模式;

public class ElementB implements Element{
	
	private String name;
	private String color;
	
	
	public ElementB(String name, String color) {
		super();
		this.name = name;
		this.color = color;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.viewElementB(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
