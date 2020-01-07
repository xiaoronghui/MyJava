package Java并发包.Concurent.util常用类;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;


/**
 * FutureTask类

    建线程的2种方式，一种是直接继承Thread，另外一种就是实现Runnable接口。

　　这2种方式都有一个缺陷就是：在执行完任务之后无法获取执行结果。

　　如果需要获取执行结果，就必须通过共享变量或者使用线程通信的方式来达到效果，这样使用起来就比较麻烦。

　　而自从Java 1.5开始，就提供了Callable和Future，通过它们可以在任务执行完毕之后得到任务执行结果。

　　今天我们就来讨论一下Callable、Future和FutureTask三个类的使用方法。

    Runnable : 

      在它里面只声明了一个run()方法：由于run()方法返回值为void类型，所以在执行完任务之后无法返回任何结果。

    Callable :

       在它里面也只声明了一个方法，只不过这个方法叫做call()：call()函数返回的类型就是传递进来的V类型
       
       那么怎么使用Callable呢？一般情况下是配合ExecutorService来使用的，在ExecutorService接口中声明了若干个submit方法的重载版本：

    Future :

         Future 就是对于具体的Runnable或者Callable任务的执行结果进行取消、查询是否完成、获取结果。

         必要时可以通过get方法获取执行结果，该方法会阻塞直到任务返回结果

    FutureTask:
    
         而FutureTask实现了RunnableFuture接口。所以它既可以作为Runnable被线程执行，又可以作为Future得到Callable的返回值。
 * 
 *
 */
public class FutureTask测试 {
	
	public static class Task implements Callable<String> {
		
		private String para ;
		
		public Task(String para){
			this.para = para;
		}

		public String call() throws Exception {
			Thread.sleep(3000);
			return this.para + "处理完成!";
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		
		String queryStr = "query";
		
		FutureTask<String> futureTask = new FutureTask<String>(new Task(queryStr));
		
		ExecutorService pool = Executors.newFixedThreadPool(1);
		
		Future f = pool.submit(futureTask);
		
		Thread.sleep(1000);
		
		System.out.println("是否已经完成" + 	futureTask.isDone());
		System.out.println("返回数据:" + futureTask.get());
		System.out.println("是否已经完成" + 	futureTask.isDone());
	
		
	}
	
}
