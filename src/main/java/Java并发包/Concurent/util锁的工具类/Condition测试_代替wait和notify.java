package Java并发包.Concurent.util锁的工具类;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Condition的等待和唤醒机制和wait,notify是一样的,但是更加的灵活.
 *  还可以实例化多个Condition,不同的实例之间的等待和唤醒互不干扰.
 *  比如: c1的signal只能唤醒c1的await,c2的signal只能唤醒c2的await
 */
public class Condition测试_代替wait和notify {
	
	public static void main(String[] args) {
		
		final Task task = new Task();
		
		new Thread(new Runnable() {
			public void run() {
				task.fun1();
			}
		},"t1").start();
		
		
		new Thread(new Runnable() {
			
			public void run() {
				task.fun2();
			}
		},"t2").start();
		
		
		new Thread(new Runnable() {
			
			public void run() {
				task.fun3();
			}
		},"t3").start();
		
		
		new Thread(new Runnable() {
			
			public void run() {
				task.fun4();
			}
		},"t4").start();
		
		
		new Thread(new Runnable() {
			
			public void run() {
				task.fun5();
			}
		},"t5").start();
		
	}
	
	public static class Task{
		
		ReentrantLock lock = new  ReentrantLock();
		
		public Condition c1  = lock.newCondition();
		
		public Condition c2  = lock.newCondition();
		
		public void fun1(){
			
			try{
				lock.lock();
				System.out.println("当前线程:" + Thread.currentThread().getName() + "进入fun1方法等待..");
				c1.await();
				System.out.println("当前线程:" + Thread.currentThread().getName() + "在fun1方法继续..");
			}catch (Exception e) {
				e.printStackTrace();
			}finally{
				lock.unlock();
			}
			
		}
		
		public void fun2(){
			try{
				lock.lock();
				System.out.println("当前线程:" + Thread.currentThread().getName() + "进入fun2方法等待..");
				c1.await();
				System.out.println("当前线程:" + Thread.currentThread().getName() + "在fun2方法继续..");
			}catch (Exception e) {
				e.printStackTrace();
			}finally{
				lock.unlock();
			}
		}
		
		public void fun3(){
			try{
				lock.lock();
				System.out.println("当前线程:" + Thread.currentThread().getName() + "进入fun3方法等待..");
				c2.await();
				System.out.println("当前线程:" + Thread.currentThread().getName() + "在fun3方法继续..");
			}catch (Exception e) {
				e.printStackTrace();
			}finally{
				lock.unlock();
			}
		}
		
		public void fun4(){
			try{
				lock.lock();
				System.out.println("当前线程:" + Thread.currentThread().getName() + "在fun4唤醒..");
				c1.signalAll();
			}catch (Exception e) {
				e.printStackTrace();
			}finally{
				lock.unlock();
			}
		}
		
		public void fun5(){
			try{
				lock.lock();
				System.out.println("当前线程:" + Thread.currentThread().getName() + "在fun5唤醒..");
				c2.signal();
			}catch (Exception e) {
				e.printStackTrace();
			}finally{
				lock.unlock();
			}
		}
		
	}
	
}
