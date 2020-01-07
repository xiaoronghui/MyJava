package Java并发包.并发类容器;

import java.util.HashMap;
import java.util.Hashtable;

public class HashMap并发读写环形链表问题 {
	
	public  HashMap map = new HashMap();
	
	public HashMap并发读写环形链表问题(){
		
		 Thread t1 = new Thread() {
	            public void run() {
	                for (int i = 0; i < 50000; i++) {
	                    map.put(new Integer(i), i);
	                }
	                System.out.println("t1 over");
	            }
	        };

	        Thread t2 = new Thread() {
	            public void run() {
	                for (int i = 0; i < 50000; i++) {
	                    map.put(new Integer(i), i);
	                }

	                System.out.println("t2 over");
	            }
	        };

	        Thread t3 = new Thread() {
	            public void run() {
	                for (int i = 0; i < 50000; i++) {
	                    map.put(new Integer(i), i);
	                }

	                System.out.println("t3 over");
	            }
	        };

	        Thread t4 = new Thread() {
	            public void run() {
	                for (int i = 0; i < 50000; i++) {
	                    map.put(new Integer(i), i);
	                }

	                System.out.println("t4 over");
	            }
	        };

	        Thread t5 = new Thread() {
	            public void run() {
	                for (int i = 0; i < 50000; i++) {
	                    map.put(new Integer(i), i);
	                }

	                System.out.println("t5 over");
	            }
	        };

	        Thread t6 = new Thread() {
	            public void run() {
	                for (int i = 0; i < 50000; i++) {
	                    map.get(new Integer(i));
	                }

	                System.out.println("t6 over");
	            }
	        };

	        Thread t7 = new Thread() {
	            public void run() {
	                for (int i = 0; i < 50000; i++) {
	                    map.get(new Integer(i));
	                }

	                System.out.println("t7 over");
	            }
	        };

	        Thread t8 = new Thread() {
	            public void run() {
	                for (int i = 0; i < 50000; i++) {
	                    map.get(new Integer(i));
	                }

	                System.out.println("t8 over");
	            }
	        };

	        Thread t9 = new Thread() {
	            public void run() {
	                for (int i = 0; i < 50000; i++) {
	                    map.get(new Integer(i));
	                }

	                System.out.println("t9 over");
	            }
	        };

	        Thread t10 = new Thread() {
	            public void run() {
	                for (int i = 0; i < 50000; i++) {
	                    map.get(new Integer(i));
	                }

	                System.out.println("t10 over");
	            }
	        };

	        t1.start();
	        t2.start();
	        t3.start();
	        t4.start();
	        t5.start();

	        t6.start();
	        t7.start();
	        t8.start();
	        t9.start();
	        t10.start();
		
	}
	
	/**
	 *   问题: 发现某个线程未打印,一直在运行,好像是出现了死循环
	 *   当发生这种情况的时候,CPU使用率一直居高不下.
	 *   
	 *   原因参考: http://blog.csdn.net/xiaohui127/article/details/11928865
	 *   
	 *   当多线程并发的给hashMap扩容的时候,可能某个Entry的最后一个next指向了第一个,变成了环形链表,
	 *   这样扩容的那段代码会变成死循环,get这个Entry的时候也是死循环.
	 *   
	 */
	public static void main(String[] args) {
		
		HashMap并发读写环形链表问题 h = new HashMap并发读写环形链表问题();
		
		
		
	}
	
}
