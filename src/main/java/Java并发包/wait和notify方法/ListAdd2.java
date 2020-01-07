package Java并发包.wait和notify方法;

import java.util.ArrayList;
import java.util.List;

public class ListAdd2 {
	
	private volatile List<String> list = new ArrayList<String>();
	
	public void add(){
		list.add("妈妈的");
	}
	
	public int size(){
		return list.size();
	}
	
	/**
	 *   wait()方法表示当前线程进行等待,notify()方法表示唤醒其它等待中的一个线程,唤醒之后会参与到锁竞争当中,
	 *   所以wait()和notify()必须结合synchronized一起使用,否则会报错.
	 *   
	 *   注: notify()不是实时的唤醒
	 */
	public static void main(String[] args) {
		
		final ListAdd2 listadd2 = new ListAdd2();
		
		final Integer lock = 0;
		
		Thread t1 = new Thread(new  Runnable() {
			public void run() {
				try {
					synchronized(lock){
						System.out.println("t1抢到了lock");
						for(int i = 0 ; i < 10; i ++){
							listadd2.add();
							System.out.println("当前线程:" + Thread.currentThread().getName() + "添加了一个元素");
							//Thread.sleep(500);
							if(i == 5){
								System.out.println("已经发出通知");
								lock.notify(); //唤醒其它等待的线程
							}
						}
						System.out.println("t1执行完成");
					}
					System.out.println("t1释放了lock");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		},"t1");
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				  synchronized(lock){
						System.out.println("t2抢到了lock");
					  if(listadd2.size() != 5){
						  try {
							lock.wait();  //当前线程等待,wait会使释放锁
						  } catch (Exception e) {
							e.printStackTrace();
						  }
						  System.out.println("当前线程接收到通知:" + Thread.currentThread().getName() + "线程停止");
							throw new RuntimeException();
					  }
					  System.out.println("t2释放了lock");
				  }
			}
		},"t2");
		
		t2.start();
		t1.start();
	}
	
	
}
