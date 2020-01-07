package Java并发包.线程基础;

public class Run方法启动和start启动的区别 {
	
    static class T1 implements Runnable{

		public void run() {
			try {
				Thread.sleep(1000);  //睡眠1秒
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("草泥马麻麻");	
		}
    }
	
	public static void main(String[] args) {
		
		T1 t1 = new T1();
//		t1.run();  //如果调用run方法则仅仅把run当成一个普通的方法来使用,从而"+++++"总是在后面执行
		new Thread(t1).start();  //而使用start启动才回去真正的创建一个线程,从而"+++++"总是在前面执行
		
		System.out.println("+++++");

		
	
		
		
		
	}
	
}
