package Java并发包.队列Queue容器;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueue测试 {
	
	/**
	 *
	 * 
	 * ConcurrentLinkedQueue队列

           		它是一个适用于高并发场景下的队列,通过无锁的方式,实现了高并发状态下的高性能,通常ConcurrentLinkedQueue性能好于BlockingQueue,

           		它是一个基于链接节点的无界限线程安全队列.该队列的元素遵循先进先出的原则.头是最先加入的,尾是最近加入的,该队列不允许null元素.

           重要的两个方法:

       			add()和offer()都是加入元素的方法 (在ConcurrentLinkedQueue中,这个两个方法没有任何区别)

       			poll()和peek()都是取头元素节点,区别在于前者会删除元素,后者不会.
	 * 
	 */
	public static void main(String[] args) {
		
		ConcurrentLinkedQueue<String> q = new ConcurrentLinkedQueue<String>();
		
		q.add("张飞");
		q.offer("关羽"); //在ConcurrentLinkedQueue中,add和offer的作用是一样的
		q.add("马超");
		q.add("黄忠");
		System.out.println(q.poll() + " size ：" + q.size());  //取得第一个元素,并删除到第一个
		System.out.println(q.peek() + " size ：" + q.size()); //取得第一个元素,并不删除
		
	}
	
}
