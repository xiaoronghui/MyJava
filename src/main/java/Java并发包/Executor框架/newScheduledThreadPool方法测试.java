package Java并发包.Executor框架;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class newScheduledThreadPool方法测试 {
	
	static class  Temp extends Thread{
		public void run(){
			System.out.println("run");
		}
	}
	
	public static void main(String[] args) {
		Temp temp = new Temp();
		ScheduledExecutorService scheduledExecutorService =	Executors.newScheduledThreadPool(1);
		
		//这里表示延迟1秒执行temp任务,然后每3秒执行一次temp
		scheduledExecutorService.scheduleWithFixedDelay(temp, 1, 3, TimeUnit.SECONDS);
		
	}
	
}
