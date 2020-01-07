package 设计模式.行为型设计模式.访问者模式;

public interface Visitor {
	
	//访问元素A
	void viewElementA(ElementA elementA);
	
	//访问元素B
	void viewElementB(ElementB elementB);
	
}
