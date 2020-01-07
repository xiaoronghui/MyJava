package 设计模式.行为型设计模式.访问者模式;

public class VisitorB implements Visitor{

	@Override
	public void viewElementA(ElementA elementA) {
		System.out.println("VisitorB只查看elementA的名字 : " + elementA.getName());
	}

	@Override
	public void viewElementB(ElementB elementB) {
		System.out.println("VisitorB只查看elementB的颜色 : " + elementB.getColor());
	}
	
	
}
