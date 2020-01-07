package Java进阶.泛型;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

public class 获取泛型类型中的实际类型参数 {
	public static void main(String[] args) throws Exception {
		//求test方法中参数中实际类型参数
		Class clazz=获取泛型类型中的实际类型参数.class;
		Method method=clazz.getMethod("test", List.class);
		Type[] types=method.getGenericParameterTypes(); //获取参数列表中每个参数的类型
		Type type=types[0]; //我知道它只有一个参数
		ParameterizedType pt=(ParameterizedType) type; //我知道这个参数是参数化类型
		System.out.println(pt.getRawType()); //原始类型
		Type[] type2=pt.getActualTypeArguments();//获取实际参数类型,可能有多个
		System.out.println(type2[0]); //我知道它只有一个
	}
	public static <T> T test(List<Date> list){
		return null;
	}
}
