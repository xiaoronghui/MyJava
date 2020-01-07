package 设计模式.行为型设计模式.命令模式;

//程序员
public class Programmer {
	
	//程序员名字
	private String name;

	public Programmer(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	
	//处理新需求
	public void handleNewDemand(){
		System.out.println("程序员"+name+"正在处理新需求" );
	}
	
	//处理bug
	public void handleBug(){
		System.out.println("程序员"+name+"正在处理Bug" );
	}
	
	//处理问题
	public void handleProblem(){
		System.out.println("程序员"+name+"正在处理线上问题" );
	}
	
	
	
}
