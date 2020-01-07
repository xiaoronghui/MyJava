package Java并发包.生产者消费者模式;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
/**
 * 队列上限为10个,3个生产者线程不断的往里面加数据,
 * 
 * 如果到了界限,就等待两秒再加. 
 * 
 * 3个消费者线程不断的从头部取出数据,然后消费. 3秒后线程停止.
 * 
 * 设计方式:
 * 
 *    1.数据缓冲区必须是线程安全的
 *    
 *    2.生产者和消费者需要持有缓冲区的引用
 * 
 */
public class Main {
	
	public static void main(String[] args) throws Exception{
		
		//数据缓冲区必须是线程安全的
		BlockingQueue<Data> queue = new LinkedBlockingQueue<Data>(10);
		
		//让生产和消费者持有缓冲区引用
		Provider p1 = new Provider(queue);
		Provider p2 = new Provider(queue);
		Provider p3 = new Provider(queue);
		
		Consumer c1 = new Consumer(queue);
		Consumer c2 = new Consumer(queue);
		Consumer c3 = new Consumer(queue);
		
		//线程池适合于并发运行若干个运行时间不长且互不干扰的函数
		ExecutorService cachePool = Executors.newCachedThreadPool();
		cachePool.execute(p1);
		cachePool.execute(p2);
		cachePool.execute(p3);
		cachePool.execute(c1);
		cachePool.execute(c2);
		cachePool.execute(c3);
		
		Thread.sleep(3000);
		
		p1.stop();
		p2.stop();
		p3.stop();
		
	}
}
