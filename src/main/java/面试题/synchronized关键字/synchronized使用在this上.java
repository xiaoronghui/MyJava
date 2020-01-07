package 面试题.synchronized关键字;

import org.junit.Test;

/**
* 用在this上,其实就是获取当前实例的对象锁
*/
public class synchronized使用在this上 {
	
	/**
	 * 验证 : synchronized(this)  表示任何一个线程执行到这的时候需要获取当前实例对象的锁(monitor),其它线程想获取该锁的,
	 * 被占用的情况下会被阻塞.
	 */
	@Test
	public void test1() throws InterruptedException{
		
		final TestUtils instance = new TestUtils();
		final long startTime = System.currentTimeMillis();
		final long occupyTime = 2000; //占据时间
		
		//当一个线程持有类锁的时候,其它线程处于等待状态
		new Thread(new Runnable() {
			public void run() {
				synchronized(instance){
					try {
						System.out.println("线程" + Thread.currentThread().getName() + "持有TestUtils的instance对象锁"+occupyTime+"毫秒");
						Thread.sleep(occupyTime);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		
		//当一个线程持有instance时候,进入synchronized(this)临界区的线程将被阻塞
		new Thread(new Runnable() {
			public void run() {
				instance.f6();
				TestUtils.printCheckTimeRst(startTime, occupyTime);
			}
		}).start();
		
		Thread.sleep(4000);
		
	}
}
