package Java进阶.框架的概念以及使用反射开发框架;

import java.io.File;
import java.io.FileInputStream;
import java.util.Collection;
import java.util.Properties;

public class 框架的理解 {
	/*
	 *  我做房子卖给用户住,由用户自己安装门窗和空调,我做的房子就是框架,用户需要使用我的框架,把门窗
	 *  插入进我提供的框架中.框架与工具类有区别,工具类被用户的类调用,而框架则是调用用户提供的类.
	 *  框架要解决的核心问题:
	 *    -- 我在写框架(房子)时,你这个用户可能还在上小学,还不会写程序呢?我写的框架程序怎样能调用到你以后写的
	 *     类(门窗)呢?
	 *     --因为在写程序时无法知道要被调用的类名,所以,在程序中无法直接new某个类的实例对象了,而要用反射方式来做
	 *    
	 *   我的理解:
	 *   框架能让程序员在配置文件配置好自己定义的类,然后供框架来调用,从而框架基本上都用到了反射机制,
	 *   因为只有到执行期间才知道所使用的类是哪个类.
	 *    
	 */
	public static void main(String[] args) {
		try {
			 //模拟框架,类路径被配置在了className.properties属性文件中
			String proPath=System.getProperty("user.dir");
			File file=new File(proPath+"/张孝祥java加强/框架的概念以及使用反射开发框架/className.properties");
			FileInputStream fis=new FileInputStream(file);
			Properties properties=new Properties();
			properties.load(fis);
			fis.close();
			//获取配置文件中的类路径
			String className=properties.getProperty("className");
			Class clazz=Class.forName(className);
			//我们经过约定,对方只能穿数组类型的类
			Collection collection=(Collection) clazz.newInstance();
			collection.add("张飞");
			collection.add("关羽");
			System.out.println(collection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
