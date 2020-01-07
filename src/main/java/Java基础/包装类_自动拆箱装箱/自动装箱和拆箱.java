package Java基础.包装类_自动拆箱装箱;

public class 自动装箱和拆箱 {
	public static void main(String[] args) {
		/*
		 * 自动装箱:
		 * 		编译器编译到这句的时候,会自动编译成Integer n=new Integer(300);
		 * 把整型数据300自动构建成一个Integer对象赋值给n
		 */
		Integer n=300; 
		/*
		 * 自动拆箱:
		 * 		编译器编译到这句的时候,会自动编译成int m=new Integer(400).intValue();
		 * 创建好new Integer(300)对象后自动调用inValue()方法,把值赋给m
		 */
		int m=new Integer(300);

		Integer a1=1234;
		Integer a2=1234;
		System.out.println(a1==a2); //两个对象指向的地址不一样,从而不相等
		System.out.println(a1.equals(a2)); //Integer重写了equals()方法,之比较值是否相等,从而不相等
		
	Integer a3=123; //[-128,127]之间的数,装箱的Integer对象会被缓存起来.
	Integer a4=123;
	System.out.println("a3:"+a3.hashCode()+" a4:"+a4.hashCode());
	/*
	 	而valueOf方法对值在-128到127之间的数值缓存了,
	 	当数值在这个范围的时候,比如Integer n=new Integer(123);会自动把new Integer(123)这个对象放到
	 	缓存里,然后下次发现数值是123的时候,就直接引用这个对象了.从而他们的地址一样.
	 	从而a3==a4返回true
	 */
	System.out.println(a3==a4);  //
	System.out.println(a3.equals(a4)); 
	}
}
