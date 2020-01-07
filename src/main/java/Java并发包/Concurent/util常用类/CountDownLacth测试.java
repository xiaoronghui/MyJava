package Java并发包.Concurent.util常用类;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch类是一个同步计数器,构造时传入int参数,该参数就是计数器的初始值，每调用一次countDown()方法，
 *  计数器减1,计数器大于0 时，await()方法会阻塞程序继续执行
     利用这种特性，可以让主线程等待子线程的结束再继续执行
 *
 */
public class CountDownLacth测试 {
	
	public static void main(String[] args)  {
		
		//表示至少需要2个线程调用countDown方法才能唤醒调用了await的线程
		final CountDownLatch countDownLatch = new CountDownLatch(2);
		
		new  Thread(new Runnable() {
			public void run() {
				System.out.println("t1正在执行..");
				System.out.println("t1调用了await方法....等待至少等待2个其它的线程执行countDown才能被唤醒..");
				try {
					countDownLatch.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("t1继续执行..");
			}
		},"t1").start();
		
		new  Thread(new Runnable() {
			public void run() {
				System.out.println("t2正在执行...");
				System.out.println("t2调用了countDown..");
				countDownLatch.countDown();  
			}
		},"t2").start();
		
		new  Thread(new Runnable() {
			public void run() {
				System.out.println("t3正在执行...");
				System.out.println("t3调用了countDown..");
				countDownLatch.countDown();
			}
		},"t3").start();
		
		new  Thread(new Runnable() {
			public void run() {
				System.out.println("t4正在执行...");
				System.out.println("t4调用了countDown..");
				countDownLatch.countDown();
			}
		},"t4").start();
		
	}
}
