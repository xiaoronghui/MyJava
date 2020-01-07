package 面试题.volatile关键字;

/**
 *  线程2是判断j是否大于i,按照happen-before传递规则 i = k;j = i;不会发生指令重排序的情况,就算发生了重排序,j不可能大于i.
 *  所以j>i的情况,只有一种,那么是线程1更改i之后,线程2的缓存并没有失效,而线程j的缓存已经更新,这就造成j大于i了
 *  
 *  所以本例中,会出现j>i的情况
 *
 */
public class 不使用volatile的可见性测试 {
	
	private int i = 0;
    private int j = 0;
    private boolean flag = false;
    
    public long exceptionCount = 0;

    //线程1调用这个方法
    public void f1() {
    	long start = System.currentTimeMillis();
        for(int k = 0; k < Integer.MAX_VALUE; k++) {
            i = k;
            j = i;
        }
        flag = true;
        System.out.println("f1方法执行结束,耗时 : " + (System.currentTimeMillis() - start));
    }

    //线程2调用这个方法
    public void f2() {
    	long start = System.currentTimeMillis();
        while (!flag) {
            //如果线程1对i,j的修改都是可见的，就不会出现j>i的情况了，一旦出现这种情况就能说明线程1对i,j的修改不可见
        	//注意了 : 这个是j大于i,按顺序运行的话,i可定要大于j,因为j后面赋值
            if(j > i) {
                exceptionCount++;
            	break;
            }
        }
        System.out.println("f2方法执行结束exceptionCount : "+exceptionCount+" , 耗时 : " + (System.currentTimeMillis() - start));
    }

    public static void main(String[] args) {
    	
        final 不使用volatile的可见性测试 volatileTest = new 不使用volatile的可见性测试();
        
        //线程1
        new Thread(new Runnable() {
            public void run() {
                volatileTest.f1();
            }
        }).start();
        
        //线程2
        new Thread(new Runnable() {
            public void run() {
                volatileTest.f2();
            }
        }).start();
        
//        f2方法执行结束exceptionCount : 1 , 耗时 : 3
//        f1方法执行结束,耗时 : 82

    }
    
}
