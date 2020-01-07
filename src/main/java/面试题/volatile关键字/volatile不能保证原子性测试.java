package 面试题.volatile关键字;

public class volatile不能保证原子性测试 {

	public volatile int a = 0;
	
	public static void main(String[] args) throws InterruptedException {
		
		final volatile不能保证原子性测试 test = new volatile不能保证原子性测试();
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				for(int i = 0 ; i < 100000; i ++){
					test.a++;
				}
			}
		});
		
		t1.start();
		
		Thread t2 = new Thread(new Runnable() {
								public void run() {
									for(int i = 0 ; i < 100000; i ++){
										test.a++;
									}
								}
							});
		
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("a的预期值是200000 , 最终值为 :" +test.a );
	}
	
}
