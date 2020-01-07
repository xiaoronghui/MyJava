package 设计模式.行为型设计模式.状态模式;

//生病状态
public class CommonState implements State {

	@Override
	public void say(Person person) {
		person.setBalance(100);
		System.out.println(person.getName() + "眉飞色舞说 :我的账户余额变成了"+person.getBalance()+"元");
	}

}
