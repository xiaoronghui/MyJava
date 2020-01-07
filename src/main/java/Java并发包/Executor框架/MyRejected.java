package Java并发包.Executor框架;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

//我的拒绝策略
public class MyRejected implements RejectedExecutionHandler {

	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
			System.out.println("当前被拒绝的任务是:" + r.toString() + ",正在向用户回复网络正忙的信息!");
	}
	
	
}
