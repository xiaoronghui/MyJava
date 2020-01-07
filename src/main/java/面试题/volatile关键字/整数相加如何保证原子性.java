package 面试题.volatile关键字;

import java.util.concurrent.atomic.AtomicInteger;

public class 整数相加如何保证原子性 {

	public AtomicInteger a = new AtomicInteger(0);
	
	public static void main(String[] args) throws InterruptedException {
		
		final 整数相加如何保证原子性 test = new 整数相加如何保证原子性();
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				for(int i = 0 ; i < 100000; i ++){
					test.a.incrementAndGet();
				}
			}
		});
		
		t1.start();
		
		Thread t2 = new Thread(new Runnable() {
								public void run() {
									for(int i = 0 ; i < 100000; i ++){
										test.a.incrementAndGet();
									}
								}
							});
		
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("a的预期值是200000 , 最终值为 :" +test.a.get() );
	}
	
}
