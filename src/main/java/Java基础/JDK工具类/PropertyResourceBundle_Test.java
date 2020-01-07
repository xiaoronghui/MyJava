package Java基础.JDK工具类;

import java.util.Enumeration;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class PropertyResourceBundle_Test {
	
	/**
	 * 为什么读取个资源还要国际化?
	 * 参考 : https://www.cnblogs.com/fjdingsd/p/5143551.html
	 */
	public static void main(String[] args) {
		
		//根据当前的语言环境,默认选取属性文件后缀为当前环境语言代码的文件.
		//当前语言环境是中文,语言代码是zh_cn,所以读取application_zh_cn.properties文件,所以ResourceBundle才会称之为国际化资源包
		ResourceBundle resourceBundle = PropertyResourceBundle.getBundle("config/application",Locale.CHINA);
		
		Enumeration<String> enumeration = resourceBundle.getKeys();
		
		while(enumeration.hasMoreElements()){
			String key = enumeration.nextElement();
			System.out.println(key + " = " + resourceBundle.getString(key));
		}

	}
	
}
