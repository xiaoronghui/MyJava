package 面试题.synchronized关键字;

import org.junit.Test;

/**
 * 获取类锁(monitor)测试
 */
public class synchronized使用在静态方法上 {
	
	/**
	 * 验证 : synchronized static 标记的方法表示任何一个线程执行该方法的时候需要获取类锁才能执行
	 */
	@Test
	public void test1() throws InterruptedException{
		
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
				TestUtils.f1();
				System.out.println("线程获取锁的时间是否正常 : " + TestUtils.checkTime(startTime, occupyTime));
			}
		}).start();
		
		Thread.sleep(4000);
		
	}
	
	/**
	 * 验证 : synchronized static 标记的变量表示任何一个线程执行该方法的时候需要获取类锁才能执行
	 *        
	 *           单并不影响实例对象锁
	 */
	@Test
	public void test2() throws InterruptedException{
		
		final long startTime = System.currentTimeMillis();
		final long occupyTime = 2000; //占据时间
		
		//当一个线程持有类锁的时候,其它线程处于等待状态
		new Thread(new Runnable() {
			public void run() {
				synchronized(TestUtils.class){
					try {
						System.out.println("线程" + Thread.currentThread().getName() + "持有TestUtils.class类锁2秒钟");
						Thread.sleep(occupyTime);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		
		//当一个线程持有类锁的时候,并不影响对象锁
		new Thread(new Runnable() {
			public void run() {
				TestUtils.f4();
				TestUtils.printCheckTimeRst(startTime, occupyTime);
			}
		}).start();
		
		Thread.sleep(4000);
				
	}
}
