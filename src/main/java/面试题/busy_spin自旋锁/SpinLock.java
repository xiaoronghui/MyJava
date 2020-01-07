package 面试题.busy_spin自旋锁;

import java.util.concurrent.atomic.AtomicReference;

public class SpinLock {
	
	 //原子操作的类 , 可以保证赋值操作的原子性,有点像乐观锁的处理.这里相当于定义了一个Thread sign=null;
	 private AtomicReference<Thread> sign =new AtomicReference<>();
	 
	  public static void main(String[] args) {
		  
		  SpinLock spinLock = new SpinLock();
		  
		  AtomicReference<Thread> sign = spinLock.sign;
		  
		  System.out.println(sign.get());
		  
		  System.out.println(sign.compareAndSet(null, Thread.currentThread()));
		  
		  sign.set(null);
		  
		  System.out.println(sign.compareAndSet(null, Thread.currentThread()));
		  
	 }

	   public void lock(){
	     Thread current = Thread.currentThread();
	     //如果原值是null,
	     while(!sign .compareAndSet(null, current)){
	     }
	   }
	  
	   public void unlock (){
	     Thread current = Thread.currentThread();
	     sign .compareAndSet(current, null);
	   }
	   
}
