package Java并发包.线程池;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @function 线程池工具类,工具的线程池
 * @author ronghui.xiao
 * @date 2017年7月31日
 */
public class ThreadPoolUtils {
	
	//创建一个根据需要自动创建线程的线程池
   private final static ExecutorService pool = Executors.newCachedThreadPool();
	
   /**
	 * @function 添加一个任务
	 * @author ronghui.xiao
	 * @date 2017年7月31日
	 */
   public static Future<?> addTask(Runnable task){
	   return pool.submit(task);
   }
   
   
   /**
 * @function 把某个实例中的方法用一个单独的线程执行(只支持无参方法)
 * @param instance 实例
 * @param methodName 方法名
 * @author ronghui.xiao
 * @date 2017年7月31日
 */
   public static Future<?> addTask(final Object instance , final String methodName){
	   return addTask(new Runnable() {
					public void run() {
						 try {
							executeMethod(instance,methodName);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
   }
   
   /**
 * @function 把某个实例中的一些方法给一个单独的线程扔进线程池进行执行,该方法会阻塞到所有方法执行完成(只支持无参方法)
 * @param instance 实例
 * @param methodNames 方法名(可变参数)
 * @author ronghui.xiao
 * @date 2017年7月31日
 */
   public static void executeMethods(final Object instance , final String... methodNames) throws Exception{
	   
	   List<Future<?>> list = new ArrayList<Future<?>>();
	   
	   //方所有方法添加进任务
	   for(int i = 0 ; i < methodNames.length ; i ++){
		   Future<?> f = addTask(instance , methodNames[i]);
		   list.add(f);
	   }
	   
	   //等待所有方法执行
	   for(Future<?> f : list){
		   f.get();
	   }
	   
   }
   
	/**
	 * @function 执行统计条数的方法
	 * @author ronghui.xiao
	 * @date 2017年7月11日
	 */
	private static void  executeMethod(Object instance , String methodName) throws Exception{
		Method m =	instance.getClass().getMethod(methodName);
		m.invoke(instance);
	}
	
   
   public static void main(String[] args) {
	   
	   Dog dog = new Dog();
	   
	   try {
		   ThreadPoolUtils.executeMethods(dog, "cry","fuck");
		} catch (Exception e) {
			e.printStackTrace();
		}

   }
	
}
