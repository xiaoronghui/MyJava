package Java进阶.内省的简单应用;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import Java进阶.反射.MyPoint;

public class 通过属性名得到属性值 {
	public static void main(String[] args) throws Exception{
		//这里通过反射从配置文件得到一个实例(这里简单的处理下,直接new个实例好了)
		Object point=new MyPoint(3, 4);
		//告诉你有一个属性叫x,你给我得到它的值 (模拟,类是从配置文件读取的,通过反射得到的实例)
		String propertyName="x";
		//通过PropertyDescriptor来得到get方法
		PropertyDescriptor pd1=new PropertyDescriptor(propertyName, point.getClass());
		Method methodGetX=pd1.getReadMethod();
	    Object x=methodGetX.invoke(point); //调用get方法
	    System.out.println(x);
	    
	    //通过PropertyDescriptor来得到set方法
	    PropertyDescriptor pd2=new PropertyDescriptor(propertyName, point.getClass());
		Method methodSetX=pd2.getWriteMethod();
	     methodSetX.invoke(point, 8);  //调用set方法
	    System.out.println(((MyPoint)point).getX());
	    
	}
}
