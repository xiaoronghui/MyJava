package Java进阶.模拟HashMap;

import java.util.Date;
import java.util.LinkedList;

/**
 * 1.如何解决第一个版本查询效率低的问题呢?
 *   每一个对象都有一个哈希码值.不同哈希码值的对象放到数组的不同位置上去,这样
 *  获取元素的时候根据哈希码值就可以取到自己想要的元素.
 *  数组长度是990,我们让哈希码值%数组长度取余数,那么余数就是0-990这个区间内.
 *  2.如果有两个哈希码值不同,但是取的余数相同,那该怎么办的?
 *   每一个元素设计成一个链表,相同余数的放在同一个list里面,获取的时候先得到这个位置,
 *   取出这个位置的链表,查找自己需要的那个元素
 *  好处:
 *    查找元素的时候进行小范围的遍历,这样效率就高多了
 *  3.Java中规定,两个内容相同的对象应该具有相等hashcode.这点很重要
 *  4.如果哈希码值是负数怎么办?
 *     你那我取绝对值好了
 *  5.put的时候超出范围怎么办?
 *     容量扩大两个,元素拷贝进去
 * 
 */
public class MyHashMap02 {
	LinkedList[] arr=new LinkedList[990]; //链表数组
	int size;
	/**
	 * 加入一条键值对
	 * @param key 键对象 value 值对象
	 * @author ronghui.xiao
	 * @date 2015-2-20
	 * @return 无返回值
	 */
	public void put(Object key,Object value){
		Entry entry=new Entry(key,value);
		int index=key.hashCode()%arr.length;
		if(index<0)index=Math.abs(index);
		if(arr[index]==null){   //如果该位置为空,加入该元素
			LinkedList list=new LinkedList();
			list.add(entry);
			arr[index]=list;
			size++;
		}else{   
			//如果不为空,看是否和原有的key相等,如果相等则覆盖,否则在该链表后添加一个
			for (int i = 0; i <arr[index].size(); i++) {
				entry=(Entry) arr[index].get(i);
					if(entry.key.equals(key)){
						entry.value=value;
						return;
					}
			}
			arr[index].add(entry);
		}
	}
	/**
	 * 根据键对象获取值对象
	 * @param key 键对象
	 * @author ronghui.xiao
	 * @date 2015-2-20
	 * @return void 无返回值
	 */
	public Object get(Object key){
		int index=key.hashCode()%arr.length;
		if(index<0)index=Math.abs(index);
		if(arr[index]!=null){  //不能于null的时候说明已经取到了东西
			Entry entry;
			for (int i = 0; i <arr[index].size(); i++) {
				 entry=(Entry) arr[index].get(i);
					if(entry.key.equals(key)){
						return entry.value;
					}
			}
		}
		return null; //若是没有取到,直接返回null
	}
	public static void main(String[] args) {
		MyHashMap02 map=new MyHashMap02();
		map.put("name", "张飞");
		map.put("sex", "男");
		map.put("hobby", "篮球");
		map.put("age", "26");
		System.out.println(map.get("hobby"));
		Date d=new Date();
		map.put(d, "时间");
		System.out.println(map.get(d));
	}
}
