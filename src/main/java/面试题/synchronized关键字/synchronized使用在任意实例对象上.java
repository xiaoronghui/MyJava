package 面试题.synchronized关键字;

import org.junit.Test;

/**
* 对象实例锁测试
*/
public class synchronized使用在任意实例对象上 {
	
	/**
	 * 验证 : synchronized(实例对象) 表示任何一个线程执行到这的时候需要获取该实例对象的锁(monitor),其它线程想获取该锁的,
	 * 被占用的情况下会被阻塞.
	 */
	@Test
	public void test1() throws InterruptedException{
		
		final long startTime = System.currentTimeMillis();
		final long occupyTime = 2000; //占据时间
		
		//当一个线程持有类锁的时候,其它线程处于等待状态
		new Thread(new Runnable() {
			public void run() {
				synchronized(TestUtils.lock){
					try {
						System.out.println("线程" + Thread.currentThread().getName() + "持有TestUtils.lock对象锁"+occupyTime+"毫秒");
						Thread.sleep(occupyTime);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		
		//当一个线程TestUtils.lock时候,其它线程处于等待状态
		new Thread(new Runnable() {
			public void run() {
				TestUtils.f4();
				TestUtils.printCheckTimeRst(startTime, occupyTime);
			}
		}).start();
		
		Thread.sleep(4000);
		
	}
}
