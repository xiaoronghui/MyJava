package Java进阶.List接口和模拟ArrayList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class List接口实现的容器 {
	public static void main(String[] args) {
		/*
			List接口下的子类Vector,LinkedList,ArrayList的区别:
			   ArrayList:底层是用数组实现的,查询快,修改,删除,插入效率低;
			   LinkedList:底层是用Node节点来链式储存数据的,查询慢,修改,删除,插入的效率高.
			   Vector:ArrayList的实现几乎一样,只不过是线程安全的,效率低;
		*/
		//testVector();
		//testLinkedList();
		//testArrayList();
	}
	
	//测试Vector
	public static void testVector(){
		/*
		 * Vector的实现和ArrayList几乎是一模一样,只不过Vector是线程安全的,方法上加上了synchronized
		 */
		List list=new Vector();
		list.add("张飞");
		list.add("关羽");
		list.add("刘备");
		System.out.println(list);
		System.out.println(list.get(0));
	}
	
	//测试LinkedList
	public static void testLinkedList(){
		/*
		 LinkedList的大概原理:
		 	LinkedList有个内部类Node,该类只有三个属性E item; Node<E> next; Node<E> prev;
      		而LinkedList自身只有Node<E> first,Node<E>last,int size三个属性.
		 	当调用add(obj)的时候,只不过是再新创建一个Node,把自己的prev设置为原来的last,next设置为新增加
      		的元素,然后把该Node赋值给last属性;如果要指定的index上插入元素,比较简单,先拿到这个位置上的元素.
      		有个方法node(index)返回这个位置上的node,然后把上一个位置和这个node创建一个新node就可以了.
      		从而说LinkedList插入,修改,删除效率是比较高的.
		 */
		List list=new LinkedList();
		list.add("张飞");
		list.add("关羽");
		list.add("刘备");
		System.out.println(list);
	}
	
	//测试ArrayList
	public static void testArrayList(){
		List list=new ArrayList(); //ArrayList的原来里面是以数组的形式来实现的
		list.add(1);
		list.add("张飞");
		list.add("aaaa");
		List list2=new ArrayList();
		list2.add("aaaa");
		list2.add("关羽");
		list.add(list2); //把list2作为单个元素添加进list中
		System.out.println(list);
		list.retainAll(list2); //list和list2取交集
		System.out.println(list);
		System.out.println(list.contains(new String("aaaa"))); //是否包含字符串aaaa,只比较值
		System.out.println(list.containsAll(list2)); //是否包含list2中的所有元素
		list.addAll(list2); //把list2的所有元素合并到list中
		System.out.println(list);
		list.set(0, "马超");//给指定位置上重新赋值
		System.out.println("set之后:"+list);
		list.add(1, "刘备");//在指定的位置上插入一个元素.因为该位置上本来就有元素,从该位置到末尾的元素都要往后移动一格,从而效率低.
		System.out.println("指定位置插入元素 :"+list);
		list.remove(1); //指定位置移除元素
		System.out.println("指定位置移除元素:"+list);//在指定的位置上插入一个元素.因为该位置上突然少了个元素,从该位置到末尾的元素都要往前移动一格,从而效率低.
		/*
		  Iterator iterator=list.iterator();是什么意思呢?
			从源码可以看出返回了return new Itr();Itr是哪个类呢?
			Itr是ArrayList的内部类,它实现了Iterator接口.该类是ArrayList的私有类,别人无法访问.
			那它的hasNext大概是怎么实现的呢?
			它有个int的属性cursor,是个数组的索引,初始为0;hasNext就是比较cursor是否等于size,不等于返回true;
			next()方法就是返回Object[cursor]的那个元素.然后在cursor+1很简单.
		*/
		Iterator iterator=list.iterator(); 
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		list.remove(2);//移除指定位置上的元素
		System.out.println(list);
		//ArrayList的一个有用的构造器,把无序的Set直接转化为有序的List
		Set set=new HashSet();
		set.add("张飞");
		set.add("关羽");
		System.out.println(set);
		List list3=new ArrayList(set);
		System.out.println(list3);
	}
}
