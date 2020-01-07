package Java并发包.生产者消费者模式;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	
	private BlockingQueue<Data> queue;
	
	private static Random r = new Random();
	
	public Consumer(BlockingQueue queue){
		this.queue = queue;
	}
	
	public void run() {
		while(true){
			try{
				Data data = this.queue.take();
				//处理数据
				Thread.sleep(r.nextInt(1000));
				System.out.println("当前消费线程: " + Thread.currentThread().getName() + ",消费成功,消费数据id为:" + data.getId());
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
