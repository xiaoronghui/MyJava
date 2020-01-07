package 设计模式.结构型设计模式.代理模式;

import java.lang.reflect.Proxy;

public class Test {
	
	/**
	 * 使用JDK动态代理可以实现任意接口的动态代理,同时可以绑定任意的处理类.spring就是利用配置先读取哪些类要进行动态代理,然后一个一个实例化放到容器里.
	 * 每次我们调用接口的时候,实际上调用的是代理类,这样就做到了面向切面编程.
	 * 
	 */
	public static void main(String[] args) {
		
		BusinessService businessService = new BusinessServiceImpl();
		
		//代理类
		BusinessService businessServiceProxy = (BusinessService) Proxy.newProxyInstance(BusinessService.class.getClassLoader(), 
				businessService.getClass().getInterfaces(), new LogProxyHandler(businessService));
		
		int resultResult = businessServiceProxy.add("张飞");
		System.out.println("返回结果 : " + resultResult);
		
		businessServiceProxy.update("12");
				
	}
	
}
