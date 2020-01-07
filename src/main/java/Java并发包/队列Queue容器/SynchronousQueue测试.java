package Java并发包.队列Queue容器;

import java.util.concurrent.SynchronousQueue;

public class SynchronousQueue测试 {
	
	/**
	 * 必须要有别的线程先在那里take,后面才可以add,
	 * 当有人调用add加元素,就直接把该元素扔给take的那个线程.
	 * 如果没有线程take,则会报错.
	 */
	public static void main(String[] args) throws Exception {
		
		
		final SynchronousQueue<String> q = new SynchronousQueue<String>();
			
        
			Thread t1 = new Thread(new Runnable() {
				public void run() {
					   try {
						System.out.println( q.take());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			t1.start();
			
			Thread t2 = new Thread(new Runnable() {
				public void run() {
					try {
						q.add("张飞");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			t2.start();
			
	
	}
}
