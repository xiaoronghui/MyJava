package Java并发包.wait和notify方法;

import java.util.ArrayList;
import java.util.List;

public class ListAdd1 {
	
	private volatile List<String> list = new ArrayList<String>();
	
	public void add(){
		list.add("妈妈的");
	}
	
	public int size(){
		return list.size();
	}
	
	/**
	 * 程序的目的:  当线程添加到5个的时候,线程2需要停止.为此,线程开启了一个死循环一直在监视list的长度是否为5
	 *                      这样实现是不好的,有没有更好的实现方式? 那就是使用线程提供的关键字wait和notify
	 * 
	 */
	public static void main(String[] args) {
		
		final ListAdd1 listadd1 = new ListAdd1();
		
		Thread t1 = new Thread(new  Runnable() {
			public void run() {
				try {
					for(int i = 0 ; i < listadd1.size() ; i ++){
						listadd1.add();
						System.out.println("当前线程:" + Thread.currentThread().getName() + "添加了一个元素");
						Thread.sleep(500);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		},"t1");
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
					while (true) {
						if(listadd1.size() == 5){
							System.out.println("当前线程接收到通知:" + Thread.currentThread().getName() + "线程停止");
							throw new RuntimeException();
						}
					}
			}
		},"t2");
		
		t1.start();
		t2.start();
		
	}
	
	
}
