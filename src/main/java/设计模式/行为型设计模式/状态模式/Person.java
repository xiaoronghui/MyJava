package 设计模式.行为型设计模式.状态模式;

public class Person {
	
	//名字
	private String name;
	
	//当前状态
	private State currentState;
	
	//账户余额
	private int balance;
	
	public Person(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public State getCurrentState() {
		return currentState;
	}
	
	//当设置不同状态的时候,Person会做出不同的行为
	public void setCurrentState(State currentState) {
		this.currentState = currentState;
		currentState.say(this);
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
}
