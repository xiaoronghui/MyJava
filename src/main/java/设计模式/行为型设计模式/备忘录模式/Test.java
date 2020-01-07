package 设计模式.行为型设计模式.备忘录模式;

public class Test {
	
	
	public static void main(String[] args) {
		
		//发起者(需要记录备忘录的对象)
		Originator originator = new Originator();
		
		//保管员
		Caretaker caretaker = new Caretaker();
		
		//设置状态
		originator.setState("state 01");
		originator.setState("state 02");
		
		//快照当前备忘录,保存到交给保管员保存起来 ==> 第1个存档点
		caretaker.addMemento(originator.snapshot());
		
		originator.setState("state 03");
		
		//快照当前备忘录,保存到交给保管员保存起来 ==> 第2个存档点
		caretaker.addMemento(originator.snapshot());
				
		originator.setState("state 04");
		
		//快照当前备忘录,保存到交给保管员保存起来 ==> 第3个存档点
		caretaker.addMemento(originator.snapshot());
		
		//恢复到第一个存档点
		originator.restoreMemento(caretaker.getMemento(0));
		
		//当前存档个数
		System.out.println("当前存档个数 : " + caretaker.careSize());
		
		//应该为state 02
		System.out.println("恢复到第一个存档点的状态为 : " + originator.getState());
		
	}
	
}
