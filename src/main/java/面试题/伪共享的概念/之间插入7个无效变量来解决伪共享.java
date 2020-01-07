package 面试题.伪共享的概念;

/**
 * 变量x,y之间插入7个long变量,占满缓存行
*/
public class 之间插入7个无效变量来解决伪共享 {
	
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
		
		//存在伪共享问题时的执行时间 : 1080ms,缩短了3倍
		System.out.println("存在伪共享问题时的执行时间 : " + (System.currentTimeMillis() - start)  + "ms");
		
	}

	static class Pointer {
	    volatile long x;
	    long p1, p2, p3, p4, p5, p6, p7;
	    volatile long y;
	}
	
}
