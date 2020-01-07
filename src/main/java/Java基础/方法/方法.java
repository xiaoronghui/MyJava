package Java基础.方法;

public class 方法 {
	/**
	 * 
	 * @param a和b是形参
	 * @author ronghui.xiao
	 * @date 2015-1-14
	 * @return
	 */
	public static int sum(int a,int b){
		return a+b;  //return用于结束方法的运行并返回值
	}
	
	public static void main(String[] args) {
		int a=1,b=2;
		int sum=方法.sum(a, b); //1和2是实计参数
		System.out.println(sum);
	}

	/*
	 --方法
     1) java的方法类似于其他语言的函数,是一段用来完成特定功能的代码片段
        注意:
            1) return 语句终止方法的运行并指定要返回的数据
            2) 值传递的原则: 基本类型传递的是该数据值本身,引用类型传递的是对对象的引用,而不是对象本身
            3) 设计方法的原则:
                 方法的本意是功能块,就是实现某个功能的语句块的集合.我们设计方法的时候,最好保持方法的原子性,就是一个方法只完成1个功能,
                 这样利于我们后期的扩展.
    */
}
