package 设计模式.创建型设计模式.单例模式;

/**
 * 
 * 双检测锁单例模式
 * 
 * 设计方式:
 * 
 *    1.定义一个私有的自身静态实例,初始值为null
 *    
 *    2.私有化构造方法.
 *    
 *    3.提供一个公共的方法返回该静态实例.需要两次检测和一个同步锁,
 *       从而称之为双检测锁单例设计;
 * 
 * 解析:
 * 
 *   为什么第二次还要去检测一次?
 *      
 *       假设现在A,B两个线程同时在第一次检测为null,A线程进入了同步锁,new了一个实例,然后
 *       释放锁,正准备返回的时候,B线程也进入了同步锁,如果此时不判断是否为null的话,那么又会产生一个
 *       新的实例,那么A和B线程返回的实例是不一样的.所以第二次还要检测一次;
 *       
 *  为什么要使用关键字volatile呢?
 *  
 *      因为线程B有可能读取的是缓存,使用volatile之后必须从内存中重新读取一次.
 *
 */
public class DoubleCheckSingleton {
	
	private static volatile DoubleCheckSingleton singleton = null;
	
	private DoubleCheckSingleton(){};
	
	public DoubleCheckSingleton getInstance(){
		if(singleton == null){  //--> 第一次检测是否为null
			synchronized (DoubleCheckSingleton.class) {     //--> 给class加上同步锁
				if(singleton == null){  //-->第二次检测是否为null
					singleton = new DoubleCheckSingleton();
				}
			}
		}
		return singleton;
	}
	
}
