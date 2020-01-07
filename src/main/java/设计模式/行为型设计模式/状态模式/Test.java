package 设计模式.行为型设计模式.状态模式;

public class Test {

	public static void main(String[] args) {
		
		//根据状态做出不同行为的人
		Person person = new Person("小明");
		
		//当设置不同状态的时候,Person会做出不同的行为
		person.setCurrentState(new SickState());
		person.setCurrentState(new CommonState());
		
	}
}
