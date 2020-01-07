package 面试题.wait和notify关键字;

import java.util.ArrayList;
import java.util.List;

/**
 * 为什么wait方法一定要放到while循环中呢?

   举例说明,在生产者和消费者的案例中,消费则发现数组里没有元素的时候,就会进入等待状态.当被别的线程唤醒的时候,
   
   会继续往下执行,而下面的操作的是获取元素,并移除该元素.如果是被其它的消费者线程唤醒并竞争到了锁,此时的数组依然为空,这个时候
   
   继续往下执行就会报空指针异常.所以被唤醒的时候依然要去检查一下条件,如果不符合条件继续调用wait方法,如果符合才往下运行.
 *
 */
public class wait方法放到while才是正确的 {
	
	public static void main(String[] args) {
		
		final wait方法放到while才是正确的 obj = new wait方法放到while才是正确的();
		
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
            notifyAll();
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
            notifyAll();
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
