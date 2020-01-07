package Java并发包.线程基础;

public class MyThread extends Thread{
	
	private int count = 5;

	public synchronized void run() {
		count --;
		System.out.println(this.currentThread().getName() + " count=" + count);
	}
	
	/**
	 * 分析: 
	 * 
	 *    当多个线程访问myThread的run方法时,以排队的方式进行处理(按照cpu分配的先后顺序)
	 *   
	 *    一个线程想要执行synchronized修饰的方法里的代码:
	 *    
	 *     1.尝试获得锁
	 *     
	 *     2.如果拿到锁,执行synchronized代码体内容.拿不到锁,这个线程就会不断的尝试获得这把锁,直到拿到为止,
	 *     
	 *        而且是多个线程同时去竞争这把锁.
	 *        
	 *     比喻: 加了synchronized的run方法就相当于火车上的厕所,一个人正在使用的时候会把门反锁,如果他使用完,其他人就会
	 *     去抢这个厕所,自己进去之后就反锁.   
	 *     
	 *     问题 : 
	 *       
	 *         当线程相当多的时候,加锁的方法被人占用,其它的线程就要等,因为线程实在太多,排到后面的都不知道要等到何年马月,而且会越积越多,
	 *         但线程资源是有限的,这样就会造成电脑死机.所以我们应该避免锁竞争的问题.
	 *     
	 */
	public static void main(String[] args) {
//			MyThread myThread = new MyThread();
//			//创建一个新的线程,引用myThread,线程启动后会执行run方法,如果传入引用,就是执行引用的run方法.
//			Thread t1 = new Thread(myThread, "t1");  
//			Thread t2 = new Thread(myThread, "t2");
//			Thread t3 = new Thread(myThread, "t3");
//			Thread t4 = new Thread(myThread, "t4");
//			Thread t5 = new Thread(myThread, "t5");
//			t1.start();
//			t2.start();
//			t3.start();
//			t4.start();
//			t5.start();
			
			
			new Thread(new Runnable() {
				public void run() {
					test();
				}
			}).start();
	}
	
	public static void test(){
		System.out.println("--");
	}
	
}
