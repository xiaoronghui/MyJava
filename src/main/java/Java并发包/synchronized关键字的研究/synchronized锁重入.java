package Java并发包.synchronized关键字的研究;

public class synchronized锁重入 {
	
	public synchronized void A(){
		System.out.println("这是A方法");
		this.B();
	}
	
	public synchronized void B(){
		System.out.println("这是B方法");
	}
	
	/*	当一个类中,A,B方法都加了synchronized, 在执行A方法的方法体中我们依然可以调用B方法.
	   
	    为什么呢? 

	     同一个实例中,执行A方法的时候,线程获取了对象锁,别的线程想要调用其他synchronized的方法时不允许的,
	  
	     所以在A方法中依然可以调用其它被synchronized修饰的方法.

	   为什么叫锁重入呢?

	     在A方法执行的时候调用B方法,调用B方法又得申请对象锁,其实该线程已近拥有对象锁了,然后又重新申请一次,所以称之为锁重入.*/
	public static void main(String[] args) {
		synchronized锁重入 instance = new synchronized锁重入();
		instance.A();
	}
}
