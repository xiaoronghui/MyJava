package 设计模式.行为型设计模式.状态模式;

//生病状态
public class SickState implements State {

	@Override
	public void say(Person person) {
		person.setBalance(50);
		System.out.println(person.getName() + "有气无力的说 : 我的账户余额变成了"+person.getBalance()+"元");
	}

}
