package Java并发包.Executor框架;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest1 {
	
	/**
	 * 
	 * 在使用有界队列时,若有新的任务需要执行,如果线程池实际线程数小于corePoolSize,则优先创建线程,
	 * 
	 * 则大于corePoolSize,则会将任务加入队列.若队列已满,则在总线程数不大于maximumPoolSize的前提
	 * 
	 * 下,创建新的线程,若线程数大于maximumPoolSize,则执行拒绝策略.或其他自定义方式.
	 * 
	 */
	public static void main(String[] args) {
		
		ArrayBlockingQueue queue = 	new ArrayBlockingQueue<Runnable>(3)  ;
		
		ThreadPoolExecutor pool  = new ThreadPoolExecutor(
				1,      //coresize
				2,     //maxSize
				60,
				TimeUnit.SECONDS,
				queue  //指定一种队列
				//,new ThreadPoolExecutor.CallerRunsPolicy()  //这个策略重试添加当前的任务，他会自动重复调用 execute() 方法，直到成功
//				,new ThreadPoolExecutor.DiscardOldestPolicy() //丢弃队列里面最老的那一个任务,比如下面的任务2
//				,new ThreadPoolExecutor.DiscardPolicy()  //对拒绝任务直接无声抛弃，没有异常信息。
				,new MyRejected()  //自定义处理拒绝策略
		);
		
		MyTask mt1 = new MyTask(1,"任务1");
		MyTask mt2 = new MyTask(2,"任务2");    //大于corePoolSize,放入队列
		MyTask mt3 = new MyTask(3,"任务3");    //大于corePoolSize,放入队列
		MyTask mt4 = new MyTask(4,"任务4");    //大于corePoolSize,放入队列 ,队列满了
		MyTask mt5 = new MyTask(5,"任务5");    //总线程数依然为1个,创建新的线程
		MyTask mt6 = new MyTask(6,"任务6");   //队列满了,线程数大于或等于maximumPoolSize,执行拒绝策略.报RejectedExecutionException异常
		
		pool.execute(mt1);
		System.out.println(queue);
		pool.execute(mt2);
		System.out.println(queue);
		pool.execute(mt3);
		System.out.println(queue);
		pool.execute(mt4);
		System.out.println(queue);
		pool.execute(mt5);
		pool.execute(mt6);
		
		//-------------------------------
		
	}
	
	
}
