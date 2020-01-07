package Java基础.时间类;

import java.util.concurrent.TimeUnit;

public class TimeUnit的使用 {

	
	/**
	 * TimeUnit是java.util.concurrent包下面的一个类，表示给定单元粒度的时间段
	 * 主要作用 : 1.时间颗粒度转换 2.延时
	 * 
	 * 解析:
	 *   1.它是一个枚举
	 * @throws InterruptedException 
	 * 
	 */
	public static void main(String[] args) throws InterruptedException {
		
		
		/**
		 * 时间颗粒度转化,中间那个枚举是什么意思,参数就是什么意思.方法就是将要转化的单位
		 */
		//1天有24个小时    1代表1天：将1天转化为小时
        System.out.println( TimeUnit.DAYS.toHours( 1 ) );
 
        //1小时有3600秒
        System.out.println( TimeUnit.HOURS.toSeconds( 1 ));
         
        //把3天转化成小时
        System.out.println( TimeUnit.HOURS.convert( 3 , TimeUnit.DAYS ) );
        
        /*
         *  延时,功能.和Thread.sleep有什么区别?
         *  
         *  不仅仅有sleep方法,还有Thread的wait和join方法
         *    
         *   区别 :
         *       Thread.sleep单位是毫秒,当我随便设置一个的时候,比如 Thread.sleep(500000).
         *       根本就看不出它睡了多久.而TimeUnit可以设置不时间粒度的睡眠时间,很直观,又方便.
         *       事实上TimeUnit内部调用的就是Thread.sleep方法
         */
        
        TimeUnit.SECONDS.sleep(5);
        System.out.println("睡眠了5秒");
        
	}
	
	
}
