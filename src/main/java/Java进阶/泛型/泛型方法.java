package Java进阶.泛型;

import java.lang.reflect.Array;
import java.util.Arrays;

public class 泛型方法 {
	public static void main(String[] args) {
		String[] arr={"张飞","关羽","刘备"};
		swap(arr, 1, 2); //把第1和第二个位置上的值换一下
		System.out.println(Arrays.toString(arr));
		//泛型参的实参必须是引用类型
		int[] intArr={1,2,3};
		//int[]本来就是一个类型,所以java不会吃饱了撑着给我们自动拆箱装箱了,所以编译报错
		//swap(intArr,1,2);
		try {
			test2(new Exception(),1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//用 <T>加在返回值的前面表示这是个泛型方法,若使用了泛型参数,那么该方法必然是个泛型方法
	//使用泛型来表示两个值的交换
	public static <T> void swap(T[] a,int i,int j){
		T temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	
	//若使用了泛型参数,那么该方法必然是个泛型方法,如果去掉<T>就编译报错 T cannot be resolved to a type
	public  static <T> void test1(T a){
		
	}
	
	//参数化异常的使用,参数有多少个泛型,那么返回值前面的<T,K>就得有多少个,不然就会编译报错
	public static <T extends Exception, K> T  test2(T a,K b) throws T {
		System.out.println("泛型方法.test2()");
		return a;
	}
	
}

