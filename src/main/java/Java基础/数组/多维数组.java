package Java基础.数组;

public class 多维数组 {
	public static void main(String[] args) {
		/*
		 	多维数组内存分析:
		 	   1) 创建一个数组对象,有3个属性,把首地址赋值给arr;
		 	   2) 然后创建数组{1,2,32},把地址赋值给第一个属性,后面两个数组同理.
		 */
		int[][] arr={  //静态初始化
				{1,2,32},
				{12,54,23,23},
				{54,23,45}
		};
		//动态初始化
		int[][] arr1=new int[3][];
		//arr1[0]=new String[3]; //二维数组也需要是同一种数据类型
		arr1[0]=new int[3]; 
		arr1[0][0]=1; 
		arr1[0][1]=2; 
		arr1[0][2]=3; 
		arr1[1]=new int[4]; 
		arr1[1][0]=4; 
		arr1[1][1]=5; 
		arr1[1][2]=6; 
		arr1[1][3]=7; 
		arr1[2]=new int[3]; 
		arr1[2][0]=8; 
		arr1[2][1]=9; 
		arr1[2][2]=10;
		//System.out.println();
	}
}
