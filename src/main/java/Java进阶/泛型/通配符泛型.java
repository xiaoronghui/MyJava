package Java进阶.泛型;

import java.util.ArrayList;
import java.util.Collection;

public class 通配符泛型 {
	public static void main(String[] args) {
		Collection<Integer> c1=new ArrayList<Integer>();
		c1.add(1);
		c1.add(2);
		c1.add(3);
		test1(c1);
		Collection<String> c2=new ArrayList<String>();
		c2.add("张飞");
		c2.add("关羽");
		c2.add("赵云");
		test1(c2);
		Collection<Number> c3=new ArrayList<Number>();
		c3.add(1);
		c3.add(2);
		c3.add(3);
		//向下限制泛型
		test2(c1);
		test2(c3);
		test3(c1);
		
		
	}

	public static void test1(Collection<?> collection){
		for(Object o :collection){
			System.out.println(o);
		}
	}
	
	//只能是Number是子类和本身
	public static void test2(Collection<? extends Number> collection){
		for(Object o :collection){
			System.out.println(o);
		}
	}
	
	//只能是Integer的父类和本身
	public static void test3(Collection<? super Integer> collection){
		for(Object o :collection){
			System.out.println(o);
		}
	}
	
}



