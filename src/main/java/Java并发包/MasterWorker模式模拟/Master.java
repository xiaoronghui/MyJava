package Java并发包.MasterWorker模式模拟;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Master {
	
	//1.应该有一个承装任务的集合,需要是线程安全的
	private ConcurrentLinkedQueue<Task> workQueue = new ConcurrentLinkedQueue<Task>();
	
	//2.使用HashMap去承装所有的worker对象
	private HashMap<String, Thread> workers = new HashMap<String, Thread>();
	
	//3.使用一个容器承装每一个worker执行任务的结果集,需要线程安全
	private ConcurrentHashMap<String, Object> resultMap = new ConcurrentHashMap<String, Object>();
	
	//4.构造方法
	public Master(Worker worker , int workerCount){
		
		//每一个worker对象都需要Master的workQueue引用来领取任务,resultMap用于任务的提交
		worker.setWorkQueue(workQueue);
		worker.setResultMap(resultMap);
		
		for(int i = 0 ; i < workerCount ; i  ++ ){
			workers.put("子节点" + i, new Thread(worker));
		}
		
	}
	
	//5.客户端提交一个任务
	public void submit(Task task){
		this.workQueue.add(task);
	}
	
	//6.需要有一个执行的方法(启动应用程序,让所有worker工作)
	public void execute(){
		
		for(Map.Entry<String, Thread> me : workers.entrySet()){
			me.getValue().start();
		}
	}
	
	//判断线程是否都执行完毕
	public boolean isComplete(){
		
		for(Map.Entry<String, Thread> me : workers.entrySet()){
			if(me.getValue().getState() != Thread.State.TERMINATED){
				return false;
			}
		}
		return true;
	}
	
	/*获取所有worker的执行结果*/
	public int getResult(){
		
		int ret = 0;
		
		for(Map.Entry<String, Object> me : resultMap.entrySet()){
			ret += (Integer)me.getValue();
		}
		
		return ret;
	}
	
}
