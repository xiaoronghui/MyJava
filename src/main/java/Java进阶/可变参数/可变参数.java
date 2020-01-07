package Java进阶.可变参数;

public class 可变参数 {
	public static void main(String[] args) {
		System.out.println(可变参数.add(3, 4));
		System.out.println(可变参数.add(3, 4,6));
		System.out.println(可变参数.add(3, 4,7,8));
	}
	
	/*
	 特点:
	     1) 只能出现在参数列表的最后
	     2) ...位于变量类型和变量名之间,前后有无空格都可以
	     3) 调用可变参数的方法时,编译器为该可变参数隐含创建一个数组,在方法体中以数组的形式访问可变参数
	 */
	public static  int add(int x,int... args){
		int sum=x;
		for(int i=0;i<args.length;i++){
			sum+=args[i];
		}
		return sum;
	}
	
	
}
