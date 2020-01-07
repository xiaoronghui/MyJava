package 设计模式.行为型设计模式.访问者模式;

public class ElementA implements Element{
	
	private String name;
	private int age;
	
	public ElementA(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.viewElementA(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
