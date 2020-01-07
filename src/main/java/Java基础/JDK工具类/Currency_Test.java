package Java基础.JDK工具类;

import java.util.Currency;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Locale;

public class Currency_Test {
	
	//代表的是各个国家的获取,获益获取
	public static void main(String[] args) {
		
		//获取某个国家的货币实例
		Currency currency  = Currency.getInstance(Locale.CHINA);
		
		//获取该国货币代码
		System.out.println(currency.getCurrencyCode());
		
		//如对于欧元，默认的小数位数为 2，而对于日元，则为 0。对于伪货币（如 IMF Special Drawing Rights），则返回 -1。 
		System.out.println(currency.getDefaultFractionDigits());
		
		//获取该国的货币符号
		System.out.println(currency.getSymbol());
		
		//返回该国的货币代码
		System.out.println(currency.toString());
		
	}
}
