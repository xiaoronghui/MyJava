package Java并发包.MasterWorker模式模拟;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Worker implements Runnable {
	
	private ConcurrentLinkedQueue<Task> workQueue ;
	
	private ConcurrentHashMap<String, Object> resultMap;

	public void run() {
		while(true){
			Task input = this.workQueue.poll(); //取出一个并删除
			if(input == null) break;
			
			//处理业务
			Object output = handle(input);
			
			//业务结果放到resultMap中
			this.resultMap.put(input.getId() + "", output);
			
		}
	}
	
	//处理一个任务
	private Object handle(Task input){
		
		Object output = null;
		
		try{
			//这个任务要耗时500毫秒,可能是数据库操作
			Thread.sleep(500);
			output = input.getPrice();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return output;
	}
	

	public ConcurrentLinkedQueue<Task> getWorkQueue() {
		return workQueue;
	}

	public void setWorkQueue(ConcurrentLinkedQueue<Task> workQueue) {
		this.workQueue = workQueue;
	}

	public ConcurrentHashMap<String, Object> getResultMap() {
		return resultMap;
	}

	public void setResultMap(ConcurrentHashMap<String, Object> resultMap) {
		this.resultMap = resultMap;
	}

}
