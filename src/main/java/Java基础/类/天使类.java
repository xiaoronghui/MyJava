package Java基础.类;

/**
 * 我们把那些具有翅膀,善良的女生归类出来,称之为天使
 * @param
 * @author ronghui.xiao
 * @date 2015-1-14
 * @return
 */
public class 天使类 {
	String wing;
	String gril;
	String honest;
	static String sex;
	
	//天使会祝福
	public void benison(){
		System.out.println("圣光会祝福你!");
	}
	//静态方法
	public static void fuck(){
		System.out.println("fuckyouwc");
	}
	
	//内存分析
	public static void main(String[] args) {
		/*
		 
		   1)  当程序运行到"天使类"的时候,先去堆中方法去寻找"天使类"是否存在,若不存在则按照classPath使用类加载器把类加载进方法区.
		        存放类的代码信息,static变量,类中字面常量(称之为常量池).
		   2)  当程序运行到ts的时候,去栈中存入一个名称为ts的变量
		   3)  当程序运行到new 天使类() 的时候,按照方法区的类模板在堆中创建一个对象,对象数据是一片连续的内存区域,
		        创建好后把对象的首地址赋值给栈中的ts变量;
		        注意:对象中的方法指向的是方法区中的方法,并不是独立的一份.(我甚至认为对象中根据没存方法的地址)
		   4) 当程序运行到ts.wing="白色翅膀"的时候,先创建字符串"白色翅膀"对象,然后把首地址赋值给ts.wing属性.ts.gril和ts.honest同理;
		       "白色翅膀"这个对象会放置在方法区的常量池中.(main方法在天使类中,所以这个常量会放在天使类的方法区的常量池中)
		   5) 当运行到ts.benison()的时候,先从对象中找benison,对象中的benison又指向方法区,从而最终在方法区中找到了该方法.然后在栈中
		       创建一个栈帧,通过栈帧来完成函数的调用执行返回.当函数执行完毕,栈帧也被清除;
		   注意:
		       static变量或static方法只存在方法区中,在实例对象中并没有static变量,static变量值从属于类;
		  栈帧:
		      栈帧就是一个函数执行的环境：函数参数、函数的局部变量、函数执行完后返回到哪里等等。
		 * */
		天使类 ts=new 天使类(); 
		ts.wing="白色翅膀";
		ts.gril="女";
		ts.honest="善良";
		ts.benison();
	}
	/*
	 --类         
	   抽象: 把两个东西的共同点提取出来归类命名,这就是抽象.(抽象就是抽出相像的部分)
	   类:类就是对对象的抽象.
	*/
}
