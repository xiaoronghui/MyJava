package 设计模式.行为型设计模式.访问者模式;

public class VisitorA implements Visitor{

	@Override
	public void viewElementA(ElementA elementA) {
		System.out.println("VisitorA只查看elementA的年龄 : " + elementA.getAge());
	}

	@Override
	public void viewElementB(ElementB elementB) {
		System.out.println("VisitorA只查看elementB的名字 : " + elementB.getName());
	}
	
	
}
