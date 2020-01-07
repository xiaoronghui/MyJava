package Java基础.常用类和注释;

public class 方法注释 {
	/**
	 * 计算n的阶乘,如5!=5x4x3x2x1
	 * @param n 被阶乘的数
	 * @author ronghui.xiao
	 * @date 2015-1-14
	 * @return 返回阶乘的值
	 */
	public static long sum(int n){
		if(n==1)return 1; //若n为1返回1  -->递归头
		return n*sum(n-1); //递归调用  -->递归体
	}
	
	public static void main(String[] args) {
		方法注释.sum(5); //鼠标移上去就可以看到注释
	}
}
