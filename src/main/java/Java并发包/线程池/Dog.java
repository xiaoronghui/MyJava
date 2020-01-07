package Java并发包.线程池;

public class Dog {
	public void cry(){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("汪汪汪汪!!!");
	}
	
	public void fuck(){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("dog-fuck!!!");
	}
}
