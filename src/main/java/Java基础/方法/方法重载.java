package Java基础.方法;

//两个同名的方法add重载了
public class 方法重载 {
	String name;
	//构造方法重载
	public 方法重载(){
		
	}
	public 方法重载(String name){
		this.name=name;
	}
	public int  add(int a,int b){
		return a+b; 
	}
	public double  add(double a,double b){
		return a+b; 
	}

	/*
	 --34.重载
	   1) 方法的重载是指一个类中可以定义有相同的名字,但参数不同的多个方法.调用时,会根据不同的参数表选择对应的方法;
	   2) 构成重载的条件(两同,三不同)
	       两同: 同一个类,同一个方法名
	       不同:参数列表不同(类型或个数或顺序不同)
	       注:只要调用同名函数的时候,不会造成歧义,那就可以构成重载;
	   3) 若只有返回值不同或只有形参名称不同,则不构成重载.
	   4) 构造方法也是可以重载的.
	 */
	
}
