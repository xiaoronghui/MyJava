package Java进阶.枚举;

public class 枚举的定义和入门 {
	/*
	 * 枚举类中每个元素其实都是一个枚举类的静态实例对象.从而每一个元素都有相应方法.
	 * 这些都已经由JDK设计好了,供我们方便使用
	 * 可以参考使用类模拟枚举
	 */
	public static void main(String[] args) {
		//test1();
		for(WeekDay3 d :WeekDay3.values()){
			System.out.println(d.name()+"="+d.ordinal());
		}
	}

	public static void test1(){
		WeekDay2 day=WeekDay2.MON;
		//查看每个枚举元素的方法
		System.out.println(day.name()); //该枚举元素的名称
		System.out.println(day.ordinal());  //该枚举元素的序号
		System.out.println(day.valueOf("SUN")); //把字符串转化给枚举元素
		System.out.println(day.values()); //返回枚举类WeekDay2中的所有元素
		for(WeekDay2 element :day.values()){  //也可以直接使用WeekDay2.values();
			System.out.println(element.name());
		}
		/*
		 *枚举原理:
		 *   枚举其实是一个抽象类,它定义了好多的抽象方法,这些方法由子类去实现
		 *   比如:
		 *      abstract name()
		 *      abstract ordinal()
		 *      abstract valueOf()
		 *      abstract values()
		 *      ...
		 *   枚举中每一个元素都是实现了枚举类抽象方法的子类实例,从而我们可以这么用的原因,如下:
		 *   WeekDay2 day=WeekDay2.MON; //父类引用指向子类实例
		 *   请参考枚举的模拟
		 */
	}
	
	enum WeekDay2{
		MON,TUE,WED,THU,FRI,STA,SUN
	}
	
	//含构造函数的枚举
	enum WeekDay3{
		MON(5),TUE(),WED,THU(8),FRI,STA,SUN;
		
		private WeekDay3(){
			System.out.println("无参构造函数!");
		}
		private WeekDay3(int i){
		   System.out.println("含参数构造函数"+i);
		}
	}
}