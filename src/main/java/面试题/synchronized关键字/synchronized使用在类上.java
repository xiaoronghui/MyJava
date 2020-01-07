package 面试题.synchronized关键字;

import org.junit.Test;

/**
 * 获取类锁(monitor)测试
 */
public class synchronized使用在类上 {
	
	/**
	 * 验证 : synchronized(类A.class) 标记的方法表示任何一个线程执行该临界区的时候需要获取该类的类锁(monitor)才能执行
	 */
	@Test
	public void test1() throws InterruptedException{
		
		final TestUtils instance = new TestUtils();
		final long startTime = System.currentTimeMillis();
		final long occupyTime = 2000; //占据时间
		
		//当一个线程持有类锁的时候,其它线程处于等待状态
		new Thread(new Runnable() {
			public void run() {
				synchronized(TestUtils.class){
					try {
						System.out.println("线程" + Thread.currentThread().getName() + "持有TestUtils.class类锁"+occupyTime+"毫秒");
						Thread.sleep(occupyTime);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		
		//当一个线程持有类锁的时候,其它线程处于等待状态
		new Thread(new Runnable() {
			public void run() {
				instance.f7();
				System.out.println("线程获取锁的时间是否正常 : " + TestUtils.checkTime(startTime, occupyTime));
			}
		}).start();
		
		Thread.sleep(4000);
		
	}
	
}
