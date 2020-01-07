package Java并发包.synchronized关键字的研究;

public class 异常释放锁的情况 {
	
	private int i = 0 ; 
	
	public synchronized void operation(){
		while(i < 100){
			try {
				i ++;
				Thread.sleep(100);
				System.out.println(Thread.currentThread().getName() + " , i = " + i);
				if(i == 10){
					Integer.parseInt("a");
				}
			 } catch (Exception e) {
				e.printStackTrace();
				System.out.println(" log info i = " + i + "发生错误!");
				throw new RuntimeException();
			 } 
		}
	}
	
	/**
	 *  如果发生异常的的时候,如果我们还想继续,需要try--catch就行了
	 *  如果不想往下走的话,就抛出RuntimeException
	 */
	public static void main(String[] args) {
		final 异常释放锁的情况 instance = new 异常释放锁的情况();
		Thread t1 = new Thread(new  Runnable() {
			public void run() {
				instance.operation();
			}
		});
		t1.start();
	}
	
	
}
