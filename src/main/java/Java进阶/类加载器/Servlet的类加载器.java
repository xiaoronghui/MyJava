package Java进阶.类加载器;

public class Servlet的类加载器 {
	public static void main(String[] args) {
		/*
		 * 1.Servlet是由tomcat下的lib目录的servlet-api.jar提供的
		 * 2.从而Servlet的类加载器应该是一个陌生的类,这个类是AppClassLoder加载器的子类
		 *    加载Servlet的类是WebappClassLoader,它的父类是StandarClassLoader类,StandarClassLoader
		 *    的父类是AppClassLoder
		 * 3.经过sevlet的测试,循环打印类加载器,如下
		 *  org.apache.catalina.loader.WebappClassLoader
			org.apache.catalina.loader.StandardClassLoader
			sun.misc.Launcher$AppClassLoader
			sun.misc.Launcher$ExtClassLoader 
		 * 4.jvm和tomcat的关系  
		 * 
		 * 
		 * */
	}
}
