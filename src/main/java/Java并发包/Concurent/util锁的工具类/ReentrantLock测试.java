package Java并发包.Concurent.util锁的工具类;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock测试 {
	
	public static class Task{
		
		ReentrantLock lock = new  	ReentrantLock();
		
		public void fun1(){
			try {
				lock.lock();
				System.out.println("正在执行fun1....");
				Thread.sleep(5000);
				System.out.println("执行fun1-->ok");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally{
				lock.unlock();
			}

		}
		
		public void fun2(){
			try {
				lock.lock();
				System.out.println("正在执行fun2....");
				Thread.sleep(5000);
				System.out.println("执行fun2-->ok");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally{
				lock.unlock();
			}
		}
		
	}
    
	/**
	 * 1.这个案例中Reentrant等价于synchronized
	 * 
	 * 注意：　必须使用finally来释放锁,万一发生异常,而没有释放锁可能造成严重后果.
	 * 
	 */
	public static void main(String[] args) {
		
	    final Task task = new Task();
		
		new Thread(new Runnable() {
			public void run() {
				System.out.println("t1正在执行...");
				task.fun1();
			}
		}).start();
		
		new Thread(new Runnable() {
			public void run() {
				System.out.println("t2正在执行...");
				task.fun2();
			}
				
		}).start();
	}
}
