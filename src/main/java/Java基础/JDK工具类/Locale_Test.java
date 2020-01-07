package Java基础.JDK工具类;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;

/*
 * 
 * Locale类代表一个特定的地理、语言和国家环境。一个Locale的实例对象本身不会验证它代表的语言和国家地区信息是否正确;
 * 
 * 作用 :
 *      它的作用仅仅是向一些对国家和语言、地理等比较敏感的类提供国家地区语言信息，这些类有DateFormat、NumberFormat等等。
 *   在ResourceBundle中也有使用
 * 
 * */
public class Locale_Test {
	
	public static void main(String[] args) {
		
		Locale locale =  Locale.CHINA;
			
		//返回所有已安装语言环境的数组
		System.out.println(Arrays.asList(locale.getAvailableLocales()));
		
		//返回此语言环境的国家/地区代码，将为空字符串或大写的 ISO 3166 两字母代码。
		System.out.println(locale.getCountry());
		
		//获得此 Java 虚拟机实例的当前默认语言环境值
		System.out.println(Locale.getDefault());
		
		//返回适合向用户显示的语言环境国家/地区名。
		System.out.println(locale.getDisplayCountry());
		
		//返回适合向用户显示的语言环境语言名。
		System.out.println(locale.getDisplayLanguage());
		
		System.out.println("返回适合向用户显示的语言环境名 ==> " + locale.getDisplayName());
		
		//返回此语言环境语言的三字母缩写。
		System.out.println(locale.getISO3Language());
		
		//返回此语言环境国家/地区的三字母缩写。
		System.out.println(locale.getISO3Country());
		
		/*不同的本地语言,数字显示的格式也不一样*/
		System.out.println("=============不同的本地语言,数字显示的格式也不一样=================");
		double num = 2132323213.23266666666;
		System.out.println(num);
		System.out.println( "正常的数字显示 : " + NumberFormat.getInstance().format(num));
		System.out.println( "德语环境的数字显示 : " + NumberFormat.getInstance(Locale.GERMAN).format(num));
		  
	}
	
}
