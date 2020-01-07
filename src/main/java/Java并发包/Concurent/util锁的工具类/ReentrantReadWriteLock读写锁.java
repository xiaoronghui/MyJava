package Java并发包.Concurent.util锁的工具类;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**
 *  实现的读写分离锁,写的时候,所有的读写锁都会被阻塞,而读的时候不会阻塞.
 *  适用于读多写少的场合
 */
public class ReentrantReadWriteLock读写锁 {
	
	public static void main(String[] args) {
		
		final Task task = new Task();
		

		new Thread(new Runnable() {
			public void run() {
				task.write();
			}
		},"t3").start();
		
		new Thread(new Runnable() {
			public void run() {
				task.read();
			}
		},"t1").start();
		
		new Thread(new Runnable() {
			public void run() {
				task.read();
			}
		},"t2").start();
		
		
		
	}
	
	public static class Task{
		
		private  ReentrantReadWriteLock rwLock = new  ReentrantReadWriteLock();
		private ReadLock readLock = rwLock.readLock();
		private WriteLock writeLock = rwLock.writeLock();
				
		public void read(){
			
			try{
				readLock.lock();
				System.out.println("当前线程:" + Thread.currentThread().getName() + "进入...");
				Thread.sleep(3000);
				System.out.println("当前线程:" + Thread.currentThread().getName() + "退出...");
			}catch (Exception e) {
				e.printStackTrace();
			}finally{
				readLock.unlock();
			}
		}
		
		public void write(){
			
			try{
				writeLock.lock();
				System.out.println("当前线程:" + Thread.currentThread().getName() + "进入...");
				Thread.sleep(3000);
				System.out.println("当前线程:" + Thread.currentThread().getName() + "退出...");
			}catch (Exception e) {
				e.printStackTrace();
			}finally{
				writeLock.unlock();
			}
		}
	}
}
