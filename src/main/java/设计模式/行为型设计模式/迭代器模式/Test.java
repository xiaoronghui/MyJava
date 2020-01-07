package 设计模式.行为型设计模式.迭代器模式;

import java.util.Iterator;

public class Test {
	
	public static void main(String[] args) {
		
		//实现了Iterable的容器类
		MyArrayList<String> list = new MyArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		
		System.out.println(list);
		
		Iterator<String> iterator = list.iterator();
		
		//iterator遍历
		System.out.println("iterator遍历");
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
		System.out.println("foreach语法遍历");
		
		for(String s : list){
			System.out.println(s);
		}
		
	}
}
