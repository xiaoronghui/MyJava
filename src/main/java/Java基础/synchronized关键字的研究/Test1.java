package Java基础.synchronized关键字的研究;

/**
 *  同步同一个对象 : synchronized(this) 
 *     
 *  1.当两个并发线程访问同一个对象object中的这个synchronized(this)同步代码块时，
 *     一个时间内只能有一个线程得到执行。另一个线程必须等待当前线程执行完这个代码块以后才能执行该代码块。
 *     
     2.然而，当一个线程访问object的一个synchronized(this)同步代码块时，
        另一个线程仍然可以访问该object中的非synchronized(this)同步代码块。
        
     3.尤其关键的是，当一个线程访问object的一个synchronized(this)同步代码块时，
       其他线程对object中所有其它synchronized(this)同步代码块的访问将被阻塞。
      
     4.第三个例子同样适用其它同步代码块。也就是说，当一个线程访问object的一个synchronized(this)同步代码块时，
        它就获得了这个object的对象锁。结果，其它线程对该object对象所有同步代码部分的访问都被暂时阻塞。
        
     同步整个类: synchronized(Test1.class) 
     
       1) 既然锁住的是class,注意了,是调用该类的同步方法和同步代码静态方法的时候会被锁住
      
     同步静态方法:
       
         无论类的哪个对象来调用该同步静态方法,都应该等待
       
    synchronized(this) 　和　synchronized(Test1.class) ：
    　　　
    　　前者只是对同一个对象的同步方法进行访问控制．synchronized(Test1.class) 和同步静态方法的效果是一样的．
    　　只不过写到方法里面而已．
    
    同步某个变量synchronized(var) :
    
       因为同步整个对象还是范围比较大,我们有时候可以采用同步某个变量的方式来达到同步的作用.
       减小同步的范围,更加灵活
    
    总结： synchronized 称之为锁,钥匙是某个变量的引用.开锁的时候,该钥匙不能被其它锁占用.
       
 */
public class Test1{
	
    private byte[] lock = new byte[0]; // 特殊的instance变量
    
	private  String lock1 = "张飞";
	
	public static void main(String[] args) throws InterruptedException {
		
		//参考网址: http://www.cnblogs.com/GnagWang/archive/2011/02/27/1966606.html
		
		final Test1 t1 = new Test1(); 
		
		//t1.testSynchronizedThis(t1);  //测试同步代码块 synchronized(this)
        
		//t1.testSynchronizedClass(t1);  //测试同步代码块 synchronized(class)
		
		//t1.testSynchronizedFun(t1);  //测试同步静态方法
		
		//t1.testSynchronizedVar(t1);  //同步某个变量
		
	
	}
	
	public Test1(){
		System.out.println("正在构建对象...");
	}
	
	/**
	 * 同步某个变量
	 */
	public void testSynchronizedVar(final Test1 t1){
		   Thread tj = new Thread(  new Runnable() {  public void run() {  t1.fun9();  }  }, "I"  );  
		   tj.start();
		  // Test1.fun7();  //对静态同步方法不受影响
		  // t1.fun9();
	}
	
	/**
	 * 测试同步静态方法
	 */
	public void testSynchronizedFun(final Test1 t1){
		/**
         *  同步静态方法:
                 无论类的哪个对象来调用该同步静态方法,且调用其它的静态同步方法也,都应该等待.
                 结果:正确; 
         */
        Thread tg = new Thread(  new Runnable() {  public void run() {  Test1.fun8();  }  }, "G"  );  
        Thread th = new Thread(  new Runnable() {  public void run() {  Test1.fun8();  }  }, "H"  );  
        Thread ti = new Thread(  new Runnable() {  public void run() {  Test1.fun7();  }  }, "I"  );  
        tg.start();
        ti.start();
        th.start();
	}
	
	
	/**
	 * 测试同步代码块 synchronized(class)
	 */
	public void testSynchronizedClass(final Test1 t1){
		/**
         *  同步整个类: synchronized(Test1.class) 
         *  
         *     1.我们调用了fun5,理论上,在fun5睡眠期间,我们无法调用静态同步方法fun6,必须等fun5睡完之后才可以调用fun6.
         *        但是静态变量照常调用.锁住整个类和synchronized(this)不会产生互斥作用.
         *        
         */
        Thread tf = new Thread(  new Runnable() {  public void run() {  t1.fun5();  }  }, "F"  );  
        tf.start();
        Test1.fun6();
	}
	
	/**
	 * 测试同步代码块 synchronized(this)
	 */
   public void testSynchronizedThis(final Test1 t1){
	   /**
		 * 1.论证第一点,我在fun1上使用了synchronized (this),
		 * 
		 *   1) 我new一个Test1,新建线程A和B,理论上讲,B线程必须等A线程执行完fun1之后
		 *         才可以执行fun1.  结果: 正确
		 *         
		 *   2) 如果我再new 一个Test2,是否还需要等待?     结果: 不需要等待
		 *       
		 */
		Thread ta = new Thread(  new Runnable() {  public void run() {  t1.fun1();  }  }, "A"  );  
		Thread tb = new Thread(  new Runnable() {  public void run() {  t1.fun1();  }  }, "B"  );  
       ta.start(); 
       tb.start();  
       
       /**
        * 2.论证第二点: 当一个线程访问object的一个synchronized(this)同步代码块时，另一个线程仍然可以访问该object中的非synchronized(this)同步代码块。
        *    结果: 正确
        *    
        */
       Thread tc = new Thread(  new Runnable() {  public void run() {  t1.fun2();  }  }, "C"  );  
       tc.start(); 
       
       /**
        * 3.论证第三点: 当一个线程访问object的一个synchronized(this)同步代码块时，其他线程对object中所有其它synchronized(this)同步代码块的访问将被阻塞。
        *    结果: 正确
        */
       Thread td = new Thread(  new Runnable() {  public void run() {  t1.fun3();  }  }, "D"  );  
       td.start();
       
       /**
        * 4.论证第四点: 当一个线程访问object的一个synchronized(this)同步代码块时，其他线程对object中所有其它synchronized(this)同步代码块的访问将被阻塞。
        *    结果: 正确
        */
       Thread te = new Thread(  new Runnable() {  public void run() {  t1.fun4();  }  }, "E"  );  
       te.start();
       
       /**
        * synchronized (this)结论,当一个线程访问object的一个synchronized(this)同步代码块时，它就获得了这个object的对象锁.其它线程访问该对象的
        *  任何加synchronized的部分都会被阻塞(需要等待).
        */
       
   }
	
	
	/**
	 * 同步代码块
	 */
	public void fun1(){
		System.out.println("-------------当前线程: " + Thread.currentThread().getName()+"---------------------");
		synchronized (this) {
			for (int i = 0; i < 100; i++) { 
                System.out.println("当前线程: " + Thread.currentThread().getName() + " -->序号:" + i); 
           } 
		}
	}
	
	/**
	 * 非同步代码块
	 */
	public void fun2(){
			System.out.println("这里是fun2....");
	}
	
	/**
	 * 同步代码块
	 */
	public void fun3(){
		synchronized (this) {
			System.out.println("这里是fun3....");
		}
	}
	
	/**
	 * 同步方法
	 */
	public synchronized void fun4(){
		System.out.println("这里是fun4....");
	}
	
	/**
	 * 同步整个类
	 */
	public  void fun5(){
		synchronized (Test1.class) {
			System.out.println("这里是fun5....");
			try {
				Thread.sleep(5000); //睡眠5秒
				System.out.println("fun5睡醒了...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 静态方法
	 */
	public synchronized static  void fun6(){
		System.out.println("这里是fun6");
	}
	
	/**
	 * 同步整个类
	 */
	public synchronized static  void fun7(){
			System.out.println("这里是fun7");
	}
	
	/**
	 * 同步整个类
	 */
	public synchronized static  void fun8(){
			System.out.println("这里是fun8");
			try {
				Thread.sleep(1000);
				System.out.println("fun8睡醒了...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	
	/**
	 * 同步某个引用
	 */
	public  void fun9(){
		synchronized(lock){
			System.out.println("这里是fun9");
			try {
				Thread.sleep(2000);
				System.out.println("fun9睡醒了...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
