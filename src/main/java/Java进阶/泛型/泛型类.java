package Java进阶.泛型;

/*
 *1.如果类的实例对象中多处都要用到同一个泛型参数,即这些地方引用的泛型类型都要
 *保持同一个实际类型时,这时候就要采用泛型类型的方式进行定义,也就是类级别的泛型,
 *语法格式:
 *public class MyClass<T>{
 *	private T f;
 * public void test1(T t){
 * 
 * }
 *  public void test2(T t){
 * }
 *} 	
 * 注意:
 * 1. 静态变量和静态方法不能使用泛型.
 *     因为静态方法和静态属性通过类名可以直接调用
 *     这个时候还不知道泛型的实际类型呢,所以不能使用
 * 
 * 2.但是可以把静态方法定义成泛型方法,但是这个泛型跟类级别的那个泛型没有关联了
 * 
 * 3.类级别的泛型主要是起到保证不同的方法和不同的属性之间使用的泛型都是同一个
 * 
 * 
 * */
public class 泛型类<T> {
	
	public void add(T t){
		
	}
	public void update(T t){
		
	}
	//静态方法不能使用类级别泛型
	/*public static void delete(T t){
		
	}*/
	
	//这个T和类级别的那个T没有任何关系,可以是任意类型
	public static <T> void fuck(T t){
		
	}
}
