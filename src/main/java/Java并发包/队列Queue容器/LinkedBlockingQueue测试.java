package Java并发包.队列Queue容器;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class LinkedBlockingQueue测试 {
	
	/**
	 * LinkedBlockingQueue 队列(阻塞)

    		基于链表的阻塞队列,同ArrayBlockingQueue类似,其内部也维持着一个数据缓冲队列,LinkedBlockingQueue之所以能够高效的处理并发数据,

    		是因为其内部实现采用分离锁(读写分离两个锁),从而实现生产者和消费者操作的完全并行运行,它是一个无界队列.也可以在初始化的时候给定一个
  
    		界限变成有界队列.

	 */
	public static void main(String[] args) {
		
		//LinkedBlockingQueue<String> q = new  LinkedBlockingQueue<String>(3);  //可以指定一个界限变成有界队列
		LinkedBlockingQueue<String> q = new  LinkedBlockingQueue<String>();
		q.add("张飞");
		q.offer("关羽"); 
		q.add("马超");
		q.add("黄忠");
		
		System.out.println(q);
		
		List list = new ArrayList();
		q.drainTo(list,3);   //从队列头部拿3个元素到list中,队列中的元素会被移除
		System.out.println("queue : " +q);
		System.out.println("list : " + list);
		
	}
	
}
