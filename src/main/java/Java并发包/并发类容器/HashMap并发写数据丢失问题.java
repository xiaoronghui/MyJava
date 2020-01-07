package Java并发包.并发类容器;

import java.util.HashMap;

public class HashMap并发写数据丢失问题 {
	
	/**
	 *  反复的执行main,我们发现有时候会丢失t2线程中的put(new Integer(7), "B");
	 *  为什么呢?
	 *    因为3和7在hashMap中对应的是同一个链表位置,当他们并发的时候,两个线程同事拿到这个位置的Entry,
	 *    把自己加在链表头部,那么先执行完的那线程就会被后执行完的那个线程覆盖,导致第一个线程的put丢失
	 */
	public static void main(String[] args) {
		
		final  HashMap map = new HashMap();
		
		new Thread(new Runnable() {
			public void run() {
				map.put(new Integer(3), "A");
			}
		},"t1").start();
		
	   new Thread(new Runnable() {
			public void run() {
				map.put(new Integer(7), "B");
			}
		},"t2").start();
	   
		System.out.println(map);
	}
	
}
