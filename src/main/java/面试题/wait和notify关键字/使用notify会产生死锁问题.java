package 面试题.wait和notify关键字;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 为什么要使用notifyAll而不应该使用notify呢?
 
   因为只要调用wait方法,线程都会进入到等待池中.等待池中即包含消费者线程,也包含生产者线程.如果此时此刻等待池中有1个生产者线程,
   
   1个消费者进行,另外一个消费者消费完进行notify()唤醒的是消费者,则消费者发现没有元素则继续等待.而生产者也在等待,导致无法继续进行下去,
   
   这就是死锁现象.如果用notifyAll的话,则锁池的所有线程都会进入到锁池中,去竞争锁,所有不会发生死锁现象.
   
  也就是说,如果是消费者被生产者唤醒,生产者被消费者唤醒,一点问题都没有.如果是消费者唤醒消费者,生产者唤醒生产者,那就会产生死锁的问题.
  
  所以要用notifyAll,确保能唤醒对方.总有一个消费者或生产者消费一个或生产一个让程序继续运行下去.
 *
 *注 : 其实就是notify可能造成线程一直在等待状态,没人去竞争锁,也就造成了没人生产或没人消费的情况.
 *
 *下面运行结果程序无法结束,这是因为发生了死锁现象.
 */
public class 使用notify会产生死锁问题 {
	
	public static void main(String[] args) {
		
		final 使用notify会产生死锁问题 obj = new 使用notify会产生死锁问题();
		
		//生产者线程
		for(int i = 0 ; i < 100 ; i ++){
			new Thread(new Runnable() {
				public void run() {
					obj.produce();
				}
			},"生产者"+i).start();
		}
		
		
		//两个消费者线程
		for(int i = 0 ; i < 100 ; i ++){
			new Thread(new Runnable() {
				public void run() {
					obj.consume();
				}
			},"消费者"+i).start();
		}
		
		System.out.println("程序成功执行");
	}
	

	private Buffer mBuf = new Buffer();
	
	//生产产品方法
    public void produce() {
        synchronized (this) {
        	while (mBuf.isFull()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            mBuf.add();
            notify();
        }
    }
    
    //消费产品方法
    public void consume() {
        synchronized (this) {
            while (mBuf.isEmpty()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            mBuf.remove();
            notify();
        }
    }

    private class Buffer {
        private static final int MAX_CAPACITY = 1;
        private List innerList = new ArrayList<>(MAX_CAPACITY);

        void add() {
            if (isFull()) {
                throw new IndexOutOfBoundsException();
            } else {
                innerList.add(new Object());
            }
            System.out.println(Thread.currentThread().getName()+ " add");

        }

        void remove() {
            if (isEmpty()) {
                throw new IndexOutOfBoundsException();
            } else {
                innerList.remove(MAX_CAPACITY - 1);
            }
            System.out.println(Thread.currentThread().getName()+ " remove");
        }

        boolean isEmpty() {
            return innerList.isEmpty();
        }

        boolean isFull() {
            return innerList.size() == MAX_CAPACITY;
        }
	
    }
}
