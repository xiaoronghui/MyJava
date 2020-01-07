package Java基础.System类的了解;

import java.util.Arrays;

public class System常用方法 {
	public static void main(String[] args) {
		String[] arr1={"张飞","关羽","赵云","马超","刘备","黄忠"};
		String[] arr2=new String[10];
		/*
		  从指定源数组中复制一个数组，复制从指定的位置开始，到目标数组的指定位置结束。
			src - 源数组。
			srcPos - 源数组中的起始位置。
			dest - 目标数组。
			destPos - 目标数据中的起始位置。
			length - 要复制的数组元素的数量。 
			System.arraycopy(src, srcPos, dest, destPos, length);
		 */
		System.arraycopy(arr1, 1, arr2, 0, 3);
		System.out.println(Arrays.toString(arr2));
		System.currentTimeMillis(); //获取当前时刻
		System.out.println("System常用方法.main()"); //输入syst,然后alt+/ 就可以打印所在的类和方法了
	}
}
