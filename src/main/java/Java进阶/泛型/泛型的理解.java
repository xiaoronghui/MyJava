package Java进阶.泛型;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

public class 泛型的理解 {
	public static void main(String[] args) throws Exception{
		/*
		 * 泛型的术语:
		 *   ArrayList<E> 和ArrayList<Integer>类举例说明:
		 *    1)整个ArrayList<E>称为泛型类型
		 *    2)整个ArrayList<Integer>称为参数化类型
		 *    3) ArrayList<Integer>中的Integer称为类型参数的实例或实际类型参数
		 *    4) ArrayList<Integer>中的<>念typeof
		 *    5) ArrayList称为原始类型
		 *    参数化类型与原始类型的兼容性:
		 *     1.参数化类型可以引用一个原始类型的对象,编译警告
		 *       Collection<String> c=new Vector();
		 *     2.原始类型可以引用一个参数化类型的对象
		 *       Collection c=new  Vector<String>();
		 *      参数化类型不考虑类型参数的继承关系:(如果等号成立的话,可以思考下为什么报错)
		 *        Vector<String> v=new Vector<Object>(); //编译报错
		 *        Vector<Object> v=new Vector<String>(); //编译报错
		 *       在创建数组实例时,数组的元素不能使用参数化的类型
		 *       Vector<integer> vectorList[] new Vector<integer>[10]; //编译报错
		 * */
		Vector<String> c=new Vector();  //虽然实例可以什么都可以装,但是引用明确告诉装String
		 c.add("a");
		 c.add("b");
		 c.add("c");
		 System.out.println(c.get(1));
		 Vector c2=new  Vector<Integer>(); //虽然实例只能装Integer,但引用什么都可以装,运行期间,泛型消失,所以装什么都可以
		 c2.add("abc");
		 System.out.println(c2.get(0));
	}
	/*
	 * 泛型是提供给javac编译器使用的,可以限定集合中的输入类型,让编译器挡住源程序中的非法输入,编译器编译带类型
	 * 说明的集合时会去除掉"类型"信息,使程序运行效率不受影响,对于参数化的泛型类型,getClass()方法返回值和原始类型
	 * 一样.由于编译生成的字节码会去掉泛型的类型信息,只要能跳过编译器,就可以往某个泛型集合中加入其它类型的数据,
	 * 例如,用发射得到集合,再调用其add方法即可.
	 * 
	 */
	public static  void test1() throws Exception{
		List<Integer>list=new ArrayList<Integer>();
		list.add(1);
		//其实泛型是给编译器看的,在运行期间,泛型就会消失,通过反射可以证明.
	    //我使用反射往数组里面加入一个字符串"abc",因为运行期间泛型已经消失,从而我可以往里面加字符串而不报错
		//由此证明了泛型仅仅是给编译器看的,运行期间泛型会消失
		list.getClass().getMethod("add", Object.class).invoke(list, "abc"); 
		System.out.println(list.get(1));
		List list2=new ArrayList();
		//使用了泛型获取的类字节码和没使用泛型的类字节码是同一份.由此证明泛型不会改变原始的类,泛型仅仅是给编译器看的.
		System.out.println(list.getClass()==list2.getClass());
	}
}
