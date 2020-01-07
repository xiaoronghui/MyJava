package Java基础.方法;

public class 程序入口main方法 {
	/*
	 	args是命令行的参数,main方法是程序的入口,可以参考坦克大战
	 	在坦克大战里面,我们在某个整个工程只有一个main方法,通过main方法来调用其它类来达到我们要的效果.
	 	在我封装为安装文件的时候,我设置了main方法所在的类,计算机会自动去找个这个类,然后找到main方法,
	 	然后从main方法开始执行.
	 */
	public static void main(String[] args) {
		/*
		 	1)在cmd执行java文件传入参数 
		 	   现在有一个Test.java文件,然后编译成Test.class,然后我们在cmd执行的时候传入参数如下:
			   java Cat  "张飞" "关羽"--> 那么就会打印张飞和关羽. 参数之间用空格隔开,不用引号也可以
			  经过测试,成功了!
			2) 在myeclipse执行java文件传入参数
			   右键-->Run as-->Run Configurations..-->打开-->Arguments选项卡-->Program arguments-->
			   输入参数,参数之间用空格隔开,不用双引号也可以.然后点击Run按钮即可
		 */
		for(String s :args){
			System.out.println("命令行参数:"+s);
		}
	}
}
