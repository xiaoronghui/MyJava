package Java并发包.线程局部变量ThreadLocal;

public class ThreadLocalTest {
	
	// ①通过匿名内部类覆盖ThreadLocal的initialValue()方法，指定初始值  
    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {  
        public Integer initialValue() {  
            return 0;  
        }  
    };  
  
    // ②获取下一个序列值  
    public int getNextNum() {  
        seqNum.set(seqNum.get() + 1);  
        return seqNum.get();  
    }  
  
    /**
     * 概念: 
     *    
     *  测试 结果:
     *     每个线程会独立拷贝 ThreadLocal的副本进行运行,线程执行完之后释放,不影响其它线程
     */
    public static void main(String[] args) {  
    	
    	ThreadLocalTest sn = new ThreadLocalTest();  
    	
        // ③ 3个线程共享sn，各自产生序列号  
        TestClient t1 = new TestClient(sn);  
        TestClient t2 = new TestClient(sn);  
        TestClient t3 = new TestClient(sn);  
        t1.start();  
        t2.start();  
        t3.start();  
        
        System.out.println("main :" + sn.getNextNum() );
    }  
  
    private static class TestClient extends Thread {  
        private ThreadLocalTest sn;  
  
        public TestClient(ThreadLocalTest sn) {  
            this.sn = sn;  
        }  
  
        public void run() {  
            for (int i = 0; i < 3; i++) {  
                // ④每个线程打出3个序列值  
                System.out.println(Thread.currentThread().getName() + " --> "  + sn.getNextNum());  
            }  
        }  
        
    }  
	
	
	
}
