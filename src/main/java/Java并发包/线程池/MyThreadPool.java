package Java并发包.线程池;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyThreadPool {
	
	//创建一个固定大小的线程池
    ExecutorService pool = Executors.newFixedThreadPool(2); 
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		MyThreadPool m = new MyThreadPool();
		
		for(int i = 0 ; i < 10 ; i ++){
			System.out.println("========");
			m.fuck();
			System.out.println("+++++++++");
		}
		
	}
	
	public void test1(){
		System.out.println("====");
	}
	
	public void fuck() throws InterruptedException, ExecutionException{
        
       Future<?> f1 = pool.submit(new  MyTestThread());
       Future<?> f2 = pool.submit(new  MyTestThread());
		
        //使用get方法会阻塞,必须等待两个任务都执行完成
        f1.get();
        f2.get();
		
	}
	
	 static class MyTestThread implements Runnable{
		
		public void run() {
			try {
				Thread.sleep(5000);
				System.out.println(Thread.currentThread().getName() + "睡醒了");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
