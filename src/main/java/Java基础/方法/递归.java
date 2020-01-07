package Java基础.方法;

public class 递归 {
	public static void main(String[] args) {
		//利用递归计算n的阶乘
		int n=10;
		System.out.println(递归.sum(n));
	}
	
	public static int sum(int n){
		if(n==1)return 1; //若n为1返回1  -->递归头
		return n*sum(n-1); //递归调用  -->递归体
	}
	
	/*	
	 	递归是一种常见的解决问题的方法,即把问题逐渐简单化.递归的基本思想就是"自己调用自己",
	    一个使用递归技术的方法将会直接或者间接的调用自己.
	    递归头: 什么时候不调用自己的条件
	    递归体: 什么时候调用自己的条件
    */
}
