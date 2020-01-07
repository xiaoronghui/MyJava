package 设计模式.行为型设计模式.命令模式;

public class Test {
	
	public static void main(String[] args) {
		
		//程序员小组
		Programmer[] programmers = {new Programmer("张飞") , new Programmer("关羽")};
		
		//产品经理
		ProductManager productManager = new ProductManager(programmers);
		
		//业务员
		Salesman salesman = new Salesman("刘备", productManager);
		
		salesman.putNewDemand();
		salesman.putBug();
		salesman.putProblem();
		salesman.putNewDemand();
		salesman.putNewDemand();
		salesman.putBug();
		salesman.putBug();
		salesman.putBug();
		salesman.putProblem();
		
		System.out.println("======业务员向产品经理提交请求完毕,共提交了"+productManager.getCommands().size()+"个请求===");
		
		//产品经理
		System.out.println("======产品经理跟业务员沟通过后,决定撤销几个请求=====");
		productManager.cancelCommand(2);
		productManager.cancelCommand(5);
		
		//产品经理分派任务
		System.out.println("==========程序员按照提出请求的顺序命令==============");
		productManager.assignCommand();
		
		
	}

}
