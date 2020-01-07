package Java并发包.volatile关键字;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicUse extends Thread{

		private static  AtomicInteger count  = new AtomicInteger(0);

		public   static  void addCount(){
			for(int i = 0 ; i < 1000 ; i ++){
				count.addAndGet(1);
				count.addAndGet(2);
				count.addAndGet(3);
				count.addAndGet(4);
			}
			System.out.println(count); //理论上,每次加完都是10的整数倍
		}
		
		public void run(){
			addCount();
		}
		
		/**
		 * 分析: 为什么有时候的值不是100000呢?
		 *   
		 *     原子类只能保证单个方法的原子性,如果连续出现多次的话就无法保证了.addAndGet出现了4次,
		 */
		public static void main(String[] args) {
			AtomicUse[] arr = new  AtomicUse[10];
			
			for(int i = 0 ; i < 10 ; i ++){
				arr[i] = new AtomicUse();
			}
			
			for(int i = 0 ; i < 10 ; i ++){
				arr[i].start();
			}
		}
}
