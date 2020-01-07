package 面试题.伪共享的概念;

public class 由伪共享带来的执行效率问题 {
	
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
		
		//存在伪共享问题时的执行时间 : 3486ms
		System.out.println("存在伪共享问题时的执行时间 : " + (System.currentTimeMillis() - start)  + "ms");
	}

	static class Pointer {
	    volatile long x;
	    volatile long y;
	}
	
}
