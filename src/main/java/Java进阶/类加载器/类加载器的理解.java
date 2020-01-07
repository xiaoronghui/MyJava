package Java进阶.类加载器;

public class 类加载器的理解 {
	public static void main(String[] args) {
		/*
		 *1.类加载器的作用
		 *   当我们程序执行时候,如果看见一个类,就得先把这个类的字节码文件从硬盘加载到内存中,
		 *   只有加载到内存中之后,cpu才可以调用进行计算
		 *   
		 *2.三个类加载器的介绍 
		 * Java虚拟机中可以安装多个类加载器,系统默认三个主要的类加载器,每个类负责加载特定位置的类
		 * BootStrap类加载器:
		 *    类加载器本身也是java类,从类加载器也要被别的类加载器加载,那必然有第一个类加载器,那就是BootStrap
		 *    类加载器,BootStrap是c++写的二进制类,固化到了加载虚拟机中,也可以称之为引导程序;这个类加载器只加载
		 *    JRE/lib/rt.jar 包上的类,System类就在rt.jar包中.
		 *     BootStrap类是ExtClassLoader类的父类.
		 *    
		 * ExtClassLoader类加载器:
		 * 	    ExtClassLoader类加载器只加载 JRE/lib/ext/*.jar 只加载ext目录下的所有jar包,ext是个扩展放扩展jar包的目录,
		 *      我们自己写的jar包可以扔到这个目录中.
		 *      ExtClassLoader类是AppClassLoder类的父类.
		 *      
		 * AppClassLoder类加载器:
		 *      AppClassLoder类只加载classPath路径下的所有jar或目录.
		 *      AppClassLoder类下面还可以有子类加载器,也就是我们定义的类加载器.
		 * 
		 * 3.类加载器的委托机制
		 *    --当java虚拟机要加载一个类时,到底派出哪一个类加载器去加载呢?
		 *    1) 首先使用当前线程的类加载器去加载线程中的第一个类,我们可以通过线程Thread.setContextClassLoader(ClassLoader cl)
		 *        来设置,如果不设置,那就默认是AppClassLoder类加载器
		 *    2) 如果类A中引用了类B,Java虚拟机将使用加载类A的类加载器来加载类B
		 *    3) 还可以在程序中调用ClassLoader.lodClass()方法来指定某个类加载器去加载某个类
		 *    4) 每个类加载器加载类时,又先委托给其上级类加载器
	     *   比如:
	     *       a)  AppClassLoder类加载器发现了System,先检查内存中是否已经被加载了,如果没有被加载,它先什么都不干,
	     *       叫父亲ExtClassLoader去加载这个类,而ExtClassLoader接到 这个任务后也什么都不干,叫父亲BootStrap去加载这个类.
	     *       然BootStrap到rt.jar包中去找System这个类,发现找到了,然后加载到内存中.
	     *       
	     *       b) 如果发现的这个类,一级一级委托给父类去加载之后,BootStrap没有找到,就把这个任务交给ExtClassLoader去ext目录下的jar
	     *         包中去找,如果还是找不到,就把这个任务交给AppClassLoder去classPath目录中去查找,如果还是找不到,
	     *         则报ClassNotFoundException的异常.
	     *        
	     *       c) 当委托机制往下返回到AppClassLoder的时候,就不会往下了,因为可能它下面有很多我们自定义的类加载器,到底给哪个儿子呢?
	     *           无法知道,从而不往下走了.
	     *         
	     *   4.按照类加载器的委托机制,如果我们定义了一个和rt.jar包和ext目录下一模一样的类的话,这个类永远都无法被加载,
	     *      因为BootStrap和ExtClassLoader总能先找到这个类名一样的类,然后就告诉你说这个类已经被加载了,不用在加载了.
	     *      那怎么办呢?
	     *         比如:
	     *            我定义了一个System类,发现使用System类的时候总是引用的rt.jar中的那个System类
	     *        解决:
	     *           自定义一个类加载器,使用这个类的时候,指定自定义的类加载器去加载这个类.
	     *     
	     *    
		 * */
		
	}
	
	//打印类加载器的名称
	public static void printClassLoaderName(){
		ClassLoader loder=	类加载器的理解.class.getClassLoader();
		//循环打印类加载器
		while(loder!=null){
			System.out.println(loder.getClass().getName());
			loder=loder.getParent();
		}
		//System类的类加载器是个null,其实不是null而是最高级的那个类加载器,使用c++写的二进制程序的,固化到了
		//java虚拟机中,名称叫bootstrap(中文:引导程序)
		//System.out.println(System.class.getClassLoader().getClass().getName());
	}
}
