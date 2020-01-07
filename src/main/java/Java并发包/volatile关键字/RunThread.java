package Java并发包.volatile关键字;

public class RunThread extends Thread{
	
	private /*volatile*/  boolean isRunning = true;
	
	private void setRunning(boolean isRunning){
		this.isRunning = isRunning;
	}
	
	public void run(){
		System.out.println("进入run方法..");
		while(isRunning){
			
		}
		System.out.println("线程停止");
	}
	
	/**
	 * 分析: 
	 * 
	 *     我们预想的结果就是在3秒后我们设置为false,应该打印出线程停止出来,但是我们发现并没有打印出来,
	 *     证明线程依然在运行.我们把isRunning设置为false,没有起到作用,这是为什么呢?
	 *     
	 *     原因：每个线程在使用变量的时候,会把变量拷贝一个副本专门给这个线程使用, 线程在运行的过程中
	 *                   只读取这个副本.外部的那个变量改变了,线程并不知道.
	 *                   
	 *    如何解决上述问题呢?               
	 *       
	 *       在访问修饰符后面加上volatile关键字,作用是当变量发生改变的时候,会使其它线程的副本失效,强制其它线程会从主存中读取变量,
	 *       然后在拷贝到一份使用.
	 *        
	 */
	public static void main(String[] args)  throws Exception{
		RunThread rt = new RunThread();
		rt.start();
		Thread.sleep(3000);
		rt.setRunning(false);
		System.out.println("isRunning的值已经被设置了..");
		Thread.sleep(1000);
		System.out.println(rt.isRunning);
	}
	
}
