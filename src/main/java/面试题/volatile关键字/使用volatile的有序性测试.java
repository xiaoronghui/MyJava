package 面试题.volatile关键字;

/**
 *  通常我们会认为,count=1写在flag=true前面,当flag为true的时候, count值肯定不为null.
 *  而事实的运行结果就是,会发现flag为true的时候,count为null,而抛出空指针.
 *  真是为什么呢?
 *    根据happen-before原则,这两条语句没有依赖关系,所以他们会被重新排序.从而导致,
 *    flag=true先执行,在还没来得及给count赋值的时候,线程2判断flag成功,从来执行count.toString()而
 *    抛出空指针异常.  
 *    
 *    我们给flag加上volatile关键字禁止指令重排序,也就是禁止count=1放到flag=true的后面取执行,这样就保证了
 *    不会发生空指针异常.
 *    
 *    注 : 只有数量级到达100万次的时候,才有可能出现异常的情况,概率极小.难怪我用1万次总是试不出来.加上volatile之后,100万次也不会出现.
 */
public class 使用volatile的有序性测试 {
	
	public Integer count = null;
	
	public volatile boolean flag = false;
	
	public void init(){
		count = 1;
		flag = true;
	}
	
	public void out(){
		if(flag) count.toString();
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		final 使用volatile的有序性测试 test = new 使用volatile的有序性测试();
		
		for(int i = 0 ; i < 1000 ; i ++){
			
			//线程1
			Thread t1 = new Thread(new Runnable() {
									public void run() {
										test.init();
									}
								});
			
			//线程2
			Thread t2 =  new Thread(new Runnable() {
				public void run() {
					test.out();
				}
			});
			
			t1.start();
			t2.start();
			
			t1.join();
			t2.join();
			
			//等待t1和t2都执行完成,重置共享变量
			test.count = null;
			test.flag = false;
		}
		
	}
	
}
