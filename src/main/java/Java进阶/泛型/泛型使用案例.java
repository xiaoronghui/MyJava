package Java进阶.泛型;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class 泛型使用案例 {
	@SuppressWarnings("all")
	public static void main(String[] args) {
		/*
		 * 1.编写一个泛型方法,自动将Object类型的对象转换成其它类型
		 * 2.定义一个方法,可以将任意参数化类型的数组中的所有元素填充为相应类型的某个对象
		 * 3.采用自定义泛型方法的方式打印出任意参数化类型的中的所有内容
		 * 4.定义一个方法,把任意参数类型的集合中的数据安全地复制到相应类型的数组中
		 * 5.定义一个方法,把任意参数类型的一个数组中的数据安全的复制到相应类型的另一个数组中
		 * */
		//1.
		泛型使用案例 instance=new 泛型使用案例();
		Object obj="张飞";
		String name=instance.converter(obj);
		System.out.println(name);
		
		//2.
		String name1="刘备";
		String[] arr=new String[10];
		instance.test1(arr, name1);
		System.out.println(Arrays.toString(arr));
		
		//3.
		Collection<Integer> c=new ArrayList<Integer>();
		c.add(1);
		c.add(1);
		instance.print(c);
		
		//4.
	}
	
	//自动将Object类型的对象转换成其它类型
	public <T> T converter(Object obj){
		return (T)obj;
	}
	
	//可以将任意参数化类型的数组中的所有元素填充为相应类型的某个对象
	public <T> T test1(T[] arr,T obj){
		for(int i=0,len=arr.length;i<len;i++){
			arr[i]=obj;
		}
		return obj;
	}
	
	//采用自定义泛型方法的方式打印出任意参数化类型的中的所有内容
     public <T> void print(Collection<T> collection){
		for(T t :collection){
			System.out.println(t);
		}
	}
   
}
