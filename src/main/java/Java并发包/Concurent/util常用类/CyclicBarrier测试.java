package Java并发包.Concurent.util常用类;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrier测试 {
	
	public static class Task extends Thread{

		public void run() {
			System.out.println("总算轮到我执行了....");
		}
	}
	
	
	public static void main(String[] args) {
		
		//每3个线程调用await方法,这3个线程才能继续往下执行.
//		final CyclicBarrier barrier = new CyclicBarrier(3);
		
		/**
		 * 
		 * 每3个线程调用await方法,Task 会被执行一次,这3个线程才能继续往下执行
		 * 
		 * 注: 若还有第4个线程调用了await,得再补足两个线程调用await才能继续往下执行,而且Task会被再执行一次
		 *       原因是每凑足3个之后,barrier会重置一次.
		 */
		final CyclicBarrier barrier = new CyclicBarrier(3,new Task());
		
		new  Thread(new Runnable() {
			public void run() {
				System.out.println("t1正在执行..");
					try {
						Thread.sleep(1000);
						barrier.await();  //通知barrier已经完成
					}catch (Exception e) {
						e.printStackTrace();
					}
				System.out.println("t1继续执行..");
			}
		},"t1").start();
		
		new  Thread(new Runnable() {
			public void run() {
				System.out.println("t2正在执行...");
				try {
					Thread.sleep(1000);
					barrier.await();  //通知barrier已经完成
				}catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("t2继续执行..");
			}
		},"t2").start();
		
		new  Thread(new Runnable() {
			public void run() {
				System.out.println("t3正在执行...");
				try {
					Thread.sleep(1000);
					barrier.await();  //通知barrier已经完成
				}catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("t3继续执行..");
			}
		},"t3").start();
		
		new  Thread(new Runnable() {
			public void run() {
				System.out.println("t4正在执行...");
				try {
					Thread.sleep(1000);
					barrier.await();  //通知barrier已经完成
				}catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("t4继续执行..");
			}
		},"t4").start();
		
		new  Thread(new Runnable() {
			public void run() {
				System.out.println("t5正在执行...");
				try {
					Thread.sleep(1000);
					barrier.await();  //通知barrier已经完成
				}catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("t5继续执行..");
			}
		},"t5").start();
		
		new  Thread(new Runnable() {
			public void run() {
				System.out.println("t6正在执行...");
				try {
					Thread.sleep(1000);
					barrier.await();  //通知barrier已经完成
				}catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("t6继续执行..");
			}
		},"t6").start();
		
		
	}
	
	
}
