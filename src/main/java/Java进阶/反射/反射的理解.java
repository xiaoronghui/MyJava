package Java进阶.反射;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class 反射的理解 {
	/*
	 *1.反射就是把java类中的各种成分映射成相应的java类.例如,一个java类用Class类的对象来表示,
	 *一个类中的组成部分:成员变量,方法,构造方法,包等等信息页用一个个的java类来表示,就想汽车是一个类,
	 *汽车中的发动机,变速箱等等也是一个个的类,表示java类的Class类显然要提供一系列的方法,来获得其中的变量,方法,构造方法,
	 *修饰符,包等信息,这些信息就是用相应类的实例对象来表示,他们是Field,Method,Contructor,Package等等
	 *
	 *2.一个类中的每个成员都可以用相应的反射API类的一个实例对象来表示.
	 *
	 */
	public static void main(String[] args) {
		DemoPoint demoPoint=new DemoPoint(20,30);
		//test1();
		//test2();
		/*
		demoPoint.str1="apple";
		demoPoint.str2="action";
		test3(demoPoint);
		System.out.println(demoPoint.str1+"==="+demoPoint.str2);*/
		
		 //从cmd传来的的参数,也可以在myeclipse设置 
		//右键-->run configurations-->Arguments选项卡-->输入类路径"反射.DemoPoint"-->执行即可
		String classPath=args[0];
		test4(classPath);
		//数组的反射
		String[] arr={"张飞","关羽","张辽"};
		test5(arr);
	}
	//构造函数类
	public static void test1(){
		try {
			StringBuilder sb=new StringBuilder();
			sb.append("张飞");
			//String类可以用可以用Class对象的实例来说明
			Class<String> clazz=String.class;
			//获取参数为StringBuilder类型的构造函数
			Constructor<String> con=clazz.getConstructor(StringBuilder.class);
			String str=con.newInstance(sb); //传入参数构造一个实例
			System.out.println(str);
			//获得String类下的所有的构造函数
			Constructor<?>[] arr=clazz.getConstructors();
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 *构造函数类总结
		 *   获得构造方法:
		 *    --通过类路径名获得class对象,然后获得构造方法: .Class.forName("java.lang.String").getConstructor(StringBuffer.class);
		 *       好处:可以把类路径放在配置文件中,然后获得class对象,然后获得构造方法
		 *    --直接拿到class对象然后得到构造方法,比如说String.class.getConstructor(StringBuilder.class);
		 *       这种方式是一种简单的使用
		 *         
		 *  创建String实例对象的方式:
		 *     通常方式: String str=new String(new StringBuilder("abc"));
		 *     反射方式: String str=(String)constructor.newInstance(new StringBuilder("abc"));
		 *     
		 *     Class.newInstance()方法:
		 *       1.这种获取的实例是无参构造方法的那个实例.
		 *       2.该方法内部先得到默认的构造方法,然后用该构造方法创建实例对象
		 *       3.该方法内部的具体代码是怎样写的呢? 用到了缓存机制来保存默认构造方法的实例对象
		 *        如: String str=(String)Class.forName("java.lang.String").newInstance();
		 */
	}
	
	//成员变量类Field
	public static void test2(){
		try {
			DemoPoint dp=new DemoPoint(10,20);
			//通过反射获取成员变量x
			Class clazz=Class.forName("反射.DemoPoint");
			//Field x=clazz.getField("x");
			Field y=clazz.getField("y");
			//getField只能获取那些可见的成员变量,那些不可见的成员变量只能通过getDeclaredField来获取
			//Declared:公然的  公告的  getDeclaredField意思是获取声明过的成员变量
			Field x=clazz.getDeclaredField("x");
			//那么属性的值是多少呢?上面我们获取的属性对象是类上的属性变量,而不是对象的属性变量,从而属性值是类的初始值;
			//获取某个实例上属性具体的值
			System.out.println("dp上属性y的值="+y.get(dp)); //获取实例dp上属性y的值
			//发现获取x的值报错,那是因为x是私有的,不可以被访问
			//System.out.println("dp上属性x的值="+x.get(dp)); //获取实例dp上属性x的值
			//访问对象上私有属性值的方式,不管你私有不私有,强行访问
			x.setAccessible(true); //强制设置成该属性可被访问
			System.out.println(x.get(dp));
			System.out.println("dp上属性x的值="+x.get(dp)); //获取实例dp上属性x的值
			//System.out.println(x.get(dp));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//利用反射把修改对象属性的值,把对象中String类型的成员变量字符a变成字符A
	public static void test3(Object obj){
		//如果传入的对象是Object无法得知类型,获取class对象的方式就是obj.getClass()
		Field[] fields=obj.getClass().getDeclaredFields();
		for(Field f :fields){
			//因为class只有一份,所有可以用等号比较类型是否相等
			if(f.getType()==String.class){
				try {
					String oldStr=(String) f.get(obj);
					String newStr=oldStr.replace("a", "A");
					f.set(obj, newStr); //该属性的值设置为新值
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//利用反射,执行DemoPoint类中的main方法
   //好处,若是在cmd中给当前类传入某个类的类名,就可以执行该类的main方法了	
	public static void test4(String className){
		try {
			//获取obj类中所有已声明的方法
			Method[] methods=Class.forName(className).getDeclaredMethods();
			//不用循环也可以直接拿到main方法
			//Method method=Class.forName(className).getMethod("main", String[].class);
			for(Method m :methods){
				//若是方法名是main,那就执行
				if(	"main".equals(m.getName())){
					System.out.println("进来了没有..");
					String[] args={"张飞","关羽"};
					//为什么这么调用主函数会报错?
					/*
					 *编译器会把main方法的传入的参数拆分成多个参数处理,而main方法只要一个数组参数,从而会报错.
					 *该怎么办呢?
					 * 办法就是把这个数组强转成一个Object对象,这样编译器就会认为你传入的是一个对象,
					 * 而不是一个数组.这样它就不会去拆分了,参数个数就正确了
					 **/
					//静态方法是类方法,从而不要传入对象,传入null即可
				    //	m.invoke(null,args); //报参数个数不对的异常
					m.invoke(null,(Object)args); //
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//利用反射打印数组
	public static void test5(Object obj){
	  Class clazz=obj.getClass();
	  //若obj是个数组
	  if(clazz.isArray()){
		  int len=Array.getLength(obj); //Array是表示数组的反射对象,从对象中拿到数组长度
		  for(int i=0;i<len;i++){
			  System.out.println(Array.get(obj, i)); //从数组中拿到每一个元素
		  }
	  }else{
		  System.out.println(obj);
	  }
		
	}
}

