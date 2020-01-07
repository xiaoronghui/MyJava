package Java并发包.Executor框架;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest2 {
	
	
	/**
	 * 在使用无界队列时,当有新任务来,系统的线程数小于corePoolSize时,
	 * 则新建线程执行任务.当达到corePoolSize后,就不会继续增加.若后续仍有新
	 * 的任务加入,而没有空闲的线程资源,则任务直接进入队列等待.若任务创建和处理
	 * 的速度差异很大,无界队列会保持快速增长,知道内存耗尽为止.
	 */
	public static void main(String[] args) {
		
		BlockingQueue queue = new LinkedBlockingQueue();
		
		ThreadPoolExecutor pool  = new ThreadPoolExecutor(
				2,      //coresize
				4,     //maxSize
				60,
				TimeUnit.SECONDS,
				queue   //指定一种队列
		);
		
		MyTask mt1 = new MyTask(1,"任务1");  
		MyTask mt2 = new MyTask(2,"任务2");   
		MyTask mt3 = new MyTask(3,"任务3");    
		MyTask mt4 = new MyTask(4,"任务4");    
		MyTask mt5 = new MyTask(5,"任务5");    
		MyTask mt6 = new MyTask(6,"任务6");
		
		pool.execute(mt1);  //未达到coresize,创建线程
		System.out.println(queue);
		pool.execute(mt2);;  //创建coresize,线程
		System.out.println(queue); 
		pool.execute(mt3);//大于coresize,进入对列
		System.out.println(queue);
		pool.execute(mt4);//大于coresize,进入对列
		System.out.println(queue);
		pool.execute(mt5);//大于coresize,进入对列
		
	}
	
	
}
