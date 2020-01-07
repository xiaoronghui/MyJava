package Java并发包.volatile关键字;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileNoAtomic extends Thread{
	
//	private static volatile int count = 0;
    	private static  AtomicInteger count  = new AtomicInteger(0);
	
	private  /*synchronized*/ static void addCount(){
		for(int i = 0 ; i < 1000 ; i ++){
//			count ++ ;
			count.incrementAndGet();
		}
		System.out.println(count);
	}
	
	public void run(){
		addCount();
	}
	
	/**
	 *   分析 : 为什么最终的值不是10000呢?
	 *   
	 *   原因 : 每一个线程都有count变量的副本内存,操作完之后再把新值刷新到主存中. 
	 *             count ++ 对于java虚拟机来说是3步操作,1.读取count的值 2.使count加1 3.加1后赋值给count,然后刷新到主存中
	 *             当线程1读取到count值之后,突然被中断,此时并没有改变count的值,所以不会让其它的副本内存失效,然后轮到线程2执行,
	 *             线程2读取到的也是0,然后+1刷新到主存并使其它线程的缓存失效. 由于线程只有在刚开始读取缓存的时候才会去检测有效性,
	 *             此时的线程1已经过了有效性检测阶段,从而线程1给count加1然后刷新到主存.这样就导致两个线程执行了两次count++但是得到
	 *             的值是1.这也就是最终值不是10000的原因.
	 *             
	 *    如何解决: 
	 *       
	 *               1.addCount()方法加上synchronized
	 *               
	 *               2.或者使用原子类AtomicInteger(还有其它各种各样的原子类)
	 * 
	 */
	public static void main(String[] args){
		VolatileNoAtomic[] arr = new  VolatileNoAtomic[10];
		
		for(int i = 0 ; i < 10 ; i ++){
			arr[i] = new VolatileNoAtomic();
		}
		
		for(int i = 0 ; i < 10 ; i ++){
			arr[i].start();
		}
	}
	
}
