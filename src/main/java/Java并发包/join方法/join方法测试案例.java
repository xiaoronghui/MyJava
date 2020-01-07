package Java并发包.join方法;

public class join方法测试案例 {

	static class MyThread extends Thread {  
		
	    public MyThread() {  
	        super("MyThread");  
	    };  
	    public void run() {  
	        String threadName = Thread.currentThread().getName();  
	        System.out.println(threadName + " start.");  
	        try {  
	            for (int i = 0; i < 5; i++) {  
	                System.out.println(threadName + " loop at " + i);  
	                Thread.sleep(1000);  
	            }  
	            System.out.println(threadName + " end.");  
	        } catch (Exception e) {  
	            System.out.println("Exception from " + threadName + ".run");  
	        }  
	    }  
	}  
	
	//
	/**
	 * 说明 : 
	 *    表示把线程t加入到主线程里来,这样主线程就必须等待线程t执行完才会往下走
	 *     就这么简单
	 */
	public static void main(String[] args) {
		 	String threadName = Thread.currentThread().getName();  
	        System.out.println(threadName + " start.");  
	        MyThread t = new MyThread();  
	        try {  
	        	t.start();
	            t.join();  
	        } catch (Exception e) {  
	            System.out.println("Exception from main");  
	        }  
	        System.out.println(threadName + " end!");  
	        
	}
	
	
	
}
