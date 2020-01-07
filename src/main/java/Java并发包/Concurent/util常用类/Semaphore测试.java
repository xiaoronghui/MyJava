package Java并发包.Concurent.util常用类;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/*
 Semaphore（信号量）是用来控制同时访问特定资源的线程数量，它通过协调各个线程，以保证合理的使用公共资源。

比如XX马路要限制流量，只允许同时有一百辆车在这条路上行使，其他的都必须在路口等待，所以前一百辆车会看到绿灯，可以开进这条马路，

后面的车会看到红灯，不能驶入XX马路，但是如果前一百辆中有五辆车已经离开了XX马路，那么后面就允许有5辆车驶入马路，这个例子里说的车就是线程，

驶入马路就表示线程在执行，离开马路就表示线程执行完成，看见红灯就表示线程被阻塞，不能执行。

场景: 

  Semaphore可以用于做流量控制，特别公用资源有限的应用场景，比如数据库连接。假如有一个需求，要读取几万个文件的数据，因为都是IO密集型任务，

  我们可以启动几十个线程并发的读取，但是如果读到内存后，还需要存储到数据库中，而数据库的连接数只有10个，这时我们必须控制只有十个线程同时获取数据库连接保存数据，

  否则会报错无法获取数据库连接。这个时候，我们就可以使用Semaphore来做流控，代码如下：
  
  */
public class Semaphore测试 {
	
	public static void main(String[] args) {
		
		int threadCount  = 30;
		
		ExecutorService threadPool = Executors.newFixedThreadPool(threadCount);
					            
		final Semaphore semaphore = new Semaphore(5);
		
		for(int i = 0 ; i< threadCount ; i ++){
			
			final int k = i;
			
			Thread t = new Thread(new Runnable() {
				public void run() {
					
					try {
						semaphore.acquire();
						System.out.println("t" + k +"正在执行任务...");
						Thread.sleep(5000);
						semaphore.release();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			
			threadPool.execute(t);
			
		}
		
		  threadPool.shutdown();
		
	}

}
