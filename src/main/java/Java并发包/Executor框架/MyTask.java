package Java并发包.Executor框架;

public class MyTask implements Runnable{
	private int id;
	private String name;
	
    public MyTask(int id , String name){
    	this.id = id;
    	this.name = name;
    }
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println("run taskId = " + this.id);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String toString() {
		return this.id + "";
	}
	
	
}
