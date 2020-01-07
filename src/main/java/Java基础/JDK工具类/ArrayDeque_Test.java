package Java基础.JDK工具类;

import java.util.ArrayDeque;
import java.util.Iterator;

public class ArrayDeque_Test {

	public static void main(String[] args) {
		
		System.out.println("=========1==========");
		
		ArrayDeque<String> array = new ArrayDeque<>();
		
		array.add("张飞");
		array.add("关羽");
		array.add("赵云");
		
		System.out.println(array);
		
		//后去第一个和最后一个
		System.out.println(array.getFirst());  //等价于  array.element()
		System.out.println(array.getLast());
		
		System.out.println("=========2==========");
		
		//获取并移除第一个元素
		String pollItem = array.poll();  //等价于 array.pollFirst(),等价于  array.pop(),等价于remove()和removeFirst()
		
		System.out.println(pollItem);
		System.out.println(array);
		
		//获取并移除最后一个元素
	//	array.peekLast();
	
		
		System.out.println("=========3==========");
		
		 //从头部或者尾部添加一个元素,不允许为null
		 array.addFirst("马超");   //等价于array.push()
		 array.addLast("狗日的");
		 
		 System.out.println(array);
		 
		 System.out.println("=========4==========");
		 
		 //返回此队列的一个副本
		 ArrayDeque<String> temp = array.clone();
		 
		 System.out.println(temp);
		 
		 //移除所有元素
		 temp.clear();
		 System.out.println(temp);
		 
		 System.out.println("=========5==========");
		 
		 //返回以逆向顺序在此双端队列的元素上进行迭代的迭代器 , iterator()是正向的迭代器
		 Iterator<String> iterator = array.descendingIterator();
		 
		 while(iterator.hasNext()){
			 System.out.print(iterator.next() + " ");
		 }
		 
		 System.out.println("\n========6===========");
		 
		 array.offer("刘备");   //和addLast一样,只不过返回boolean值
		 array.offerFirst("刘禅");  //和addFirst一样,只不过返回boolean值
		 array.offerLast("貂蝉");  //和addLast一样,只不过返回boolean值
		 
		 System.out.println(array);
		 
		 System.out.println("==========7=========");
		 
		 array.peek();          //和getFirst一样,允许返回值为null
		 array.peekFirst();   //和getFirst一样,允许返回值为null
		 array.peekLast();    //和getLast一样,允许返回值为null
		 
		 System.out.println( array );
		 
	}
	
	
}
