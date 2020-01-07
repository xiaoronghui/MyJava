package Java基础.变量;

public class 变量和常量 {
	int x;  //成员变量
	
	public static void main(String[] args) {
		int a=10; //局部变量
		int b;
		//System.out.println(b); //局部变量b并没有赋初值,从而会报错
		System.out.println(a);   //局部变量a已经赋初值了
		变量和常量 obj=new 变量和常量(); //类名也可以是中文
		System.out.println(obj.x);//成员变量会自动初始化,int默认值为0
		
		//常量
		final double C=3.14;
		final int MAX_SPEED=120;
		System.out.println(C);
		//C=3.14159;  //常量只能被初始化一次,如果在这再初始化就要报错.只能再第一次赋值的地方修改
		
		/*
		---Java变量和常量
	    1) Java是一种强类型语言,每个变量都必须声明其类型
	    2) 变量在使用前必须对其声明,只有在变量声明以后才能为其分配相应的长度的存储单元.格式:type varName [=value][,varName[=value]]
	    3) 局部变量
	            使用之前必须先声明和赋初值,不然就会报错
	    4) 成员变量
	            a) 方法外部,类的内部定义的变量
	            b) 不过不自行初始化,他会自动初始化成该类型的默认初始值 (数组类型:0,字符型:null,布尔型:false)
	    5) 常量
	         常量使用final关键字修饰,只能初始化一次,约定用大写字母和下滑线来命名;如:final int MAX_SPEED=120;
	         
	    */

	}
}
