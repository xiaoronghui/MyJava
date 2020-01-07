package 面试题.synchronized关键字;

public class TestUtils {
	
	//实例对象锁
	public  static  Integer lock = 0;
	
	/**
	* @function 检测获取锁的时间是否正确, true表示正确,false表示错误
	* @param  startTime 线程开始执行时间
	* @param  occupyTime 上一个线程占用的时间
	*/
	public static boolean checkTime(long startTime , long occupyTime){
		long getLockEarliestTime = startTime + occupyTime; //获取锁的最早时间
		return System.currentTimeMillis() >= getLockEarliestTime; 
	}
	
	/**
	* @function 检测并打印获取锁的时间是否正确, true表示正确,false表示错误
	* @param  startTime 线程开始执行时间
	* @param  occupyTime 上一个线程占用的时间
	*/
	public static void printCheckTimeRst(long startTime , long occupyTime){
		System.out.println("线程"+Thread.currentThread().getName()+"获取锁的时间是否正常 : " + checkTime(startTime, occupyTime));
	}
	
	public synchronized static void f1(){
		System.out.println("线程" + Thread.currentThread().getName() + "正在执行f1()");
	}
	
	public synchronized static void f2(){
		System.out.println("线程" + Thread.currentThread().getName() + "正在执行f1()");
	}
	
	public static void f3(){
		System.out.println("线程" + Thread.currentThread().getName() + "正在执行f3()");
	}
	
	//对象锁方法
	public static void f4(){
		synchronized (lock) {
			System.out.println("线程" + Thread.currentThread().getName() + "正在执行f4()");
		}
	}
	
	//实例方法上的锁
	public synchronized void f5(){
		System.out.println("线程" + Thread.currentThread().getName() + "正在执行f5()");
	}
	
	//当前实例上的锁
	public  void f6(){
		synchronized (this) {
			System.out.println("线程" + Thread.currentThread().getName() + "正在执行f6()");
		}
	}
	
	//当前类的锁
	public  void f7(){
		synchronized (TestUtils.class) {
			System.out.println("线程" + Thread.currentThread().getName() + "正在执行f7()");
		}
	}
	
}
