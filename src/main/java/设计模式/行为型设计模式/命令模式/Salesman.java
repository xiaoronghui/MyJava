package 设计模式.行为型设计模式.命令模式;

//业务员
public class Salesman {
	
	private String name;
	
	//产品经理
	private ProductManager productManager;

	public Salesman(String name , ProductManager productManager) {
		super();
		this.name = name;
		this.productManager = productManager;
	}
	
	//业务员提出新需求
	public void putNewDemand(){
		System.out.println("业务员"+name+"提出新需求");
		productManager.addCommand(new NewDemandCommand(productManager.randomProgrammer()));
	}
	
	//业务员提出bug
	public void putBug(){
		System.out.println("业务员"+name+"提出bug");
		productManager.addCommand(new BugCommand(productManager.randomProgrammer()));
	}
	
	//业务员提出线上问题
	public void putProblem(){
		System.out.println("业务员"+name+"提出线上问题");
		productManager.addCommand(new ProblemCommand(productManager.randomProgrammer()));
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProductManager getProductManager() {
		return productManager;
	}

	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}
	
	
	
	
	
}
