package 设计模式.结构型设计模式.代理模式;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 日志代理处理器
 */
public class LogProxyHandler implements InvocationHandler{
	
	Object target;
	
	public LogProxyHandler(Object target) {
      this.target = target;
    }
	
	//前置处理
	public void beforeHandle(Object[] args){
	  System.out.println("参数 : " + Arrays.asList(args).toString());
	}
	
	//后置处理
	public void afterHandle(Method method){
	  System.out.println("方法" + method.getName() + "调用结束!");   
	}
	
	
	//第一个参数proxy指的是代理对象
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		beforeHandle(args);
		
		Object object = method.invoke(target, args);
		
		afterHandle(method);
		
		return object;
	}

}
