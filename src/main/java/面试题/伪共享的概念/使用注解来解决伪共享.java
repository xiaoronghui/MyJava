package 面试题.伪共享的概念;

//使用注解来占满缓存行
public class 使用注解来解决伪共享 {
	
	public static void main(String[] args) throws InterruptedException {
		
		long start = System.currentTimeMillis();
		
		final Pointer pointer = new Pointer();
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				for(int i = 0 ; i < 100000000 ; i ++){
					pointer.x++;
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for(int i = 0 ; i < 100000000 ; i ++){
					pointer.y++;
				}
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		//存在伪共享问题时的执行时间 : 1098ms,运行的时候VM参数中需要加入
		System.out.println("存在伪共享问题时的执行时间 : " + (System.currentTimeMillis() - start)  + "ms");
		
	}

	static class Pointer {
		@sun.misc.Contended
	    volatile long x;
		@sun.misc.Contended
	    volatile long y;
	}
	
}
