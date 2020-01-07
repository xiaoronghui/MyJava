package Java并发包.队列Queue容器;

import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueue测试 {
	
	/**
	 *  PriorityBlockingQueue里面存储的对象必须是实现Comparable接口。
	 *  
	 *   队列通过这个接口的compare方法确定对象的优先级。 
	 * 
	 * 
	 */
	public static void main(String[] args) {
		
		PriorityBlockingQueue<Task> p = new PriorityBlockingQueue<Task>();
		
		p.add(new Task(1,"张飞"));
		p.add(new Task(2,"关羽"));
		p.add(new Task(3,"刘备"));
		p.add(new Task(0,"曹操"));
		
		System.out.println( p.peek().name);
		
	}
	
	public static class Task implements Comparable{
		
		int id ;
		String name ;
		
        public Task(){
        	
        }
        
        public Task(int id,String name){
        	this.id = id;
        	this.name = name;
        }
		
		/*优先级算法*/
        
        /**
         * 规定返回：
              负整数、零或正整数，根据此对象是小于、等于还是大于指定对象。 
             
             规则: 
                 负数的优先级最高,然后是0,然后是其它数.
         */
		public int compareTo(Object o) {
			return	this.id > ((Task)o).id ? 1    :  this.id < ((Task)o).id ? -1 : 0;  
		}
		
	}
	
	
}
