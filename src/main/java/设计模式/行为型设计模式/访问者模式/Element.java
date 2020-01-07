package 设计模式.行为型设计模式.访问者模式;

public interface Element {
	
	void accept(Visitor visitor);
	
}
