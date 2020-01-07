package Java并发包.队列Queue容器;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *  要求: 
 *    当队列到达上限的时候,必须等待有空位才能往里面插入.后面等着插入的线程都得排队等候.
 *    当队列到达下限的时候,必须等待有元素的时候才能拿走第一个.后面等着拿走的线程都得排队
 *    当有内容的时候需要唤醒其它线程
 *    
 *    1.如果需要让多个线程进行排队等候则需要使用到synchronized
 *    
 *    2.分析,我本想把synchronized放到方法上面,但是我不想让put和take方法产生互斥,因为put和take是可以同时进行的,所以需要变量锁
 *    
 *    3.如果想唤醒其它线程需要用到notify,如果需要线程等待,则使用wait
 */
public class MyQueue {

	private LinkedList<Object> list = new LinkedList<Object>();
	
	/*锁*/
	private int[] lock = new int[0];
	
	/*队列上限*/
	private int max = 5;
	
	/*队列下限*/
	private int min = 0;
	
    public MyQueue(){}
    	
    public  MyQueue(int max){
    	this.max = max;
    }
	
    /**
     * 在队列的尾部插入一个元素
     * @param obj
     */
    public void put(Object obj){
     	
    	synchronized(lock){
     		
    		if(list.size() == 5){
     			try {
     				lock.wait();
     			} catch (InterruptedException e) {	e.printStackTrace();}
     		}
     		
 			list.add(obj);
 			lock.notify();  //唤醒那个正在等待take的线程
     		
     	}
    }
    
    public void print(){
    	System.out.println("当前list内容有:" + list);
    }
    
    /**
     * 拿走队列的第一个元素
     */
    public Object take(){
    	
    	Object obj = null;
    	
    	synchronized(lock){
    		
    		if(list.size() == 0){
    			try { 
    				lock.wait();	
    			} catch (InterruptedException e) {	e.printStackTrace();}
        	}
    		
    		obj =  list.remove();
    		lock.notify();  //唤醒正在等待put的那个线程
    	}
    	return obj;
    }
    
    public static void main(String[] args) {
    	
    	final MyQueue mqMyQueue = new MyQueue();
    	
    	for(int i = 0 ; i < 5 ; i ++){
    		mqMyQueue.put(i);
    	}
    	
    	System.out.println("当前长度:" + mqMyQueue.list.size());
    	
    	/*t1线程想加入两个元素*/
    	Thread t1 = new Thread(new Runnable() {
			
			public void run() {
				for(int i = 5 ; i < 7 ; i ++){
					mqMyQueue.put(i);
				}
			}
			
		},"t1");
    	
    	t1.start();
    	
    	/*t2线程想取出两个*/
    	Thread t2 = new Thread(new Runnable() {
    		
    		public void run() {
    			System.out.println(mqMyQueue.take());
    			System.out.println(mqMyQueue.take());
    		}
    		
    	},"t2");
    	
    	
    	/*两秒后才启动t2*/
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	
    	t2.start();
    	
    	//如果2秒后t1在能加入元素,证明模拟的是正确的
	}
    
	
	
	
	
}
