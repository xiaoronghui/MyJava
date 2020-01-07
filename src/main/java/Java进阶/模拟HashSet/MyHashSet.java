package Java进阶.模拟HashSet;
import java.util.HashMap;
import java.util.Iterator;

public class MyHashSet {
   HashMap map;  //使用map作为容器
   private static final Object PRESENT = new Object(); //map中的默认值
   int size;
   /**
	 * 构造函数
	 * @author ronghui.xiao
	 * @date 2015-2-22
	 */
   public MyHashSet(){
	   map=new HashMap();
   }
   /**
	 * 返回set元素的个数
	 * @author ronghui.xiao
	 * @date 2015-2-22
	 * @return int 返回整型数据
	 */
   public int size(){
	   return size;
   }
   /**
	 * 添加一个元素
	 * @param obj 被添加的元素
	 * @author ronghui.xiao
	 * @date 2015-2-22
	 * @return void 无返回值
	 */
   public void add(Object obj){
	   map.put(obj, PRESENT); //set的不可重复就是利用了map里面键对象的不可重复
   }
   /**
	 *  返回对此 set 中元素进行迭代的迭代器
	 * @author ronghui.xiao
	 * @date 2015-2-22
	 * @return Iterator 迭代器
	 */
   public Iterator iterator(){
	   return map.keySet().iterator();
   }
   
   public static void main(String[] args) {
	    //1.看HashSet的JDK,然后使用一下
	 	//2.使用感觉不错了之后再模拟一下   
	   //3.iterator我感觉不太清楚了,查看List中的原理,记录在笔记上
	   MyHashSet set=new MyHashSet();
	   set.add("张飞");
	   set.add("关羽");
	   set.add("刘备");
	   set.add("马超");
	   Iterator iterator=set.iterator();
	   while(iterator.hasNext()){
		   Object obj=iterator.next();
		   System.out.println(obj);
	   }
	}
   
}
