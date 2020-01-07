package Java并发包.并发类容器;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMap原理和分析 {
	
	private static ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<Integer, Integer>();
	
	/**
	 * 
	 * 原理:
	 * 　　从ConcurrentHashMap代码中可以看出，它引入了一个“分段锁”的概念，
	 * 　　具体可以理解为把一个大的Map拆分成N个小的HashTable，根据key.hashCode()来决定把key放到哪个HashTable中。
	 * 
	 * 分析：
	 * 
	 * 		　我们在ConcurrentHashMap中的419行打一个断点,由于3和1的hashcode一样,
 　* 	　　从而线程Thread2必须等线程Thread1执行完才能put进去,Thread3正常．从而
	 * 　　证明ConcurrentHashMap采用了分段锁．
	 * 
	 */
	public static void main(String[] args) {
		
		new Thread("Thread1"){
			public void run() {
				map.put(3, 33);
			}
		}.start();
		
		new Thread("Thread2"){
			public void run() {
				map.put(4, 44);
			}
		}.start();
		
		new Thread("Thread3"){
			public void run() {
				map.put(7, 77);
			}
		}.start();
		
		System.out.println(map);
	}
	
}
