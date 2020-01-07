package Java基础.JDK工具类;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Arrays_Test {
	
	public static void main(String[] args) {
		/*
		 	--类 Arrays
		 		此类包含用来操作数组（比如排序和搜索）的各种方法。
		 */
		int[] arr1={95,56,23,56,65,23,68};
		System.out.println(Arrays.toString(arr1));//Arrays.toString(arr1)把数组转化为字符串打印
		Arrays.sort(arr1);	//使数组从小到大排序
		
		System.out.println(Arrays.toString(arr1));
		List list=Arrays.asList("张飞","关羽"); //把传入的参数直接转化为数组
		System.out.println(list);
		
		
		//查找数组中元素第一次出现的位置.注意:查找前要先排序
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.binarySearch(arr1, 68));
		
		//替换
		Arrays.fill(arr1, 3); //把arr1的所有元素都替换为3
		System.out.println(Arrays.toString(arr1));
		
		
		Arrays.fill(arr1, 3); //把arr1的所有元素都替换为3
		Arrays.fill(arr1, 1, 3, 99);//从第索引1个位置替换到索引3,3位置不替换,左闭右开区间取值
		
		System.out.println(Arrays.toString(arr1));
		
	}
	
	/**
	 *@function 判断两个数组是否相等,就是里面的值是否一模一样
	 *@author 肖荣辉
	 *@date 2018年1月30日
	 */
	@Test
	public void equals_test(){
		
		boolean flag = Arrays.equals(new int[]{1,2,3}, new int[]{1,2,3});
		
		System.out.println(flag);
		
		flag = Arrays.equals(new int[]{1,2,3}, new int[]{1,6,3});
		
		System.out.println(flag);
		
	}
	
	/**
	 *@function  拷贝一个数组,并指定新数组的长度,用null填充多余的空位. 如果新长度比原长度小,则截断.
	 *@author 肖荣辉
	 *@date 2018年1月30日
	 */
	@Test
	public void copyOf_test(){
		
		String[] arr = {"张飞","关羽","赵云"};

		String[] arr2 = Arrays.copyOf(arr, 10);
		
		System.out.println(Arrays.asList(arr2));
		
	}
	
	/**
	 *@function  拷贝一个数组,并指定要拷贝的元素范围(左闭右开,从索引0开始)
	 *@author 肖荣辉
	 *@date 2018年1月30日
	 */
	@Test
	public void copyOfRange_test(){
		
		String[] arr = {"张飞","关羽","赵云"};
		
		String[] arr2 = Arrays.copyOfRange(arr, 0, 1);
		
		System.out.println(Arrays.asList(arr2));
	}
	
}
