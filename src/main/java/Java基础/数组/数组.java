package Java基础.数组;

public class 数组 {
	public static void main(String[] args) {
		/*
		  1.数组是相同数据类型的有序集合
		  2.数组也是对象.数组元素相当于对象的成员变量------------------>(注意)
		  3.数组长度的是确定的,不可变的,越界则报越界异常.
		  4.数组有个length属性,使用了final修饰,不能被赋值,表示数组的长度
		  内存分析:
		     1) 栈中创建一个变量,在堆中创建一个数组对象,对象中有3个属性,因为是整型,
		         每个属性占用4个字节,默认值为0
		 */
		int[] intarr=new int[3];  //new 的是数组类,int表示元素的类型
		intarr[0]=1;  //这种给数组赋值的方式叫做动态初始化
		intarr[1]=2;
		intarr[2]=3;
		//intarr[3]=4; //越界ArrayIndexOutOfBoundsException异常
		/*
		 	引用类型的数组内存分析:
		 	  1) 栈中创建一个变量,在堆中创建一个数组对象,对象中有3个属性,因为是引用类型,每个属性
		 	      占用4个字节用于存放引用地址;
		 	  2) 当运行到cars[0]=new Car("奔驰");时候,先创建一个Car对象,把该对象的首地址赋给数组
		 	      的第一个属性.
		 */
		Car[] cars=new Car[3]; //new 的是数组类,Car表示元素的类型
		cars[0]=new Car("奔驰");
		String[] arr={"张飞","关羽","赵云"}; //这种给数组赋值的方式叫做动态初始化
		
		//空数组,这样表示一个空数组,表示长度为0的数组,等同于Object[] emptyArr = new Object[0];
		Object[] emptyArr = {};  
//		Object[] emptyArr = new Object[0];
		
		//空数组直接赋值回报越界异常
		emptyArr[0] = 1; 
		
	}
}
