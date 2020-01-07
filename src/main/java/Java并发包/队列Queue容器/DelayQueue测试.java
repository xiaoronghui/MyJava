package Java并发包.队列Queue容器;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 模拟网吧营业上机和下机
 */
public class DelayQueue测试 {
	
	public static void main(String[] args) {
		System.out.println("网吧开始营业");
		Wangba wangba = new  Wangba();
		
		Thread shangwang = new Thread(wangba);
		shangwang.start();
		
		wangba.shangji("张飞", "123", 15);
		wangba.shangji("马超", "432", 5);
		wangba.shangji("关羽", "234", 10);
		wangba.shangji("关羽", "234", 8);
		
		/**
		 *  
		 *   1.订单来了,查询订单,计算出到点时间,放入到队列中.
		 *  
		 *     如果两个订单id相同,会覆盖吗?  我们可以控制到让后面那个覆盖前面那个,重写equal()方法
		 *     
		 *   2. 每次往队列里面写的时候就往redis写一个id和时间
		 *   
		 *   3. 每次初始化从redis中拿出来的时候需要验证它的状态是否超期什么的.
		 *     
		 *    
		 */
		
	}
	
	/**
	 * 网吧 
	 */
	public static class Wangba implements Runnable{
		
		private DelayQueue<Wangmin> queue = new DelayQueue<Wangmin>();
		
		public boolean yingye = true;
		
		/**
		 * 上机,网费1元1秒钟 
		 */
		public void shangji(String name ,  String id , int money){
			Wangmin man = new Wangmin(name, id , 1000 * money + System.currentTimeMillis());
			System.out.println("网名:" + man.getName() + "  身份证" + man.getId()  + "交钱" + money + "块,开始上机...");
			
			/*如果id一致,让后面那个覆盖前面那个*/
			if(this.queue.contains(man)){
				this.queue.remove(man);
			}
		    this.queue.add(man);
		}
		
		/*下机*/
		public void xiaji(Wangmin man){
			System.out.println("网名:" + man.getName() + "  身份证" + man.getId()  +"时间到下机...");
		}
		
		/**
		 * 拿出队列最前面的那个元素
		 */
		public void run() {
			while(yingye){
				try{
					Wangmin man = queue.take();
					xiaji(man);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		public DelayQueue<Wangmin> getQueue() {
			return queue;
		}
		
	}
	
	public static class Wangmin implements Delayed{
		
		private String name;
		
		private String id;
		
		private long endTime;
		
		private TimeUnit timeUnit = TimeUnit.SECONDS;
		
		/**
		 * 网民
		 * @param name
		 * @param id
		 * @param endTime  //上机结束时间
		 */
		public Wangmin(String name , String id , long endTime){
			this.name = name;
			this.id = id;
			this.endTime = endTime;
		}

		/**
		 * 快到上机时间的优先级更高
		 * 
		 *  整数 < 0 < 负数  //优先级等级
		 */
		public int compareTo(Delayed o) {
			if(this.getDelay(timeUnit) == o.getDelay(timeUnit)){
				return 0;
			}
			return this.getDelay(timeUnit) > o.getDelay(timeUnit) ? 1 : -1 ;
		}
		
		/**
		 * 返回上网剩余时间
		 */
		public long getDelay(TimeUnit unit) {
			return endTime - System.currentTimeMillis();
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public long getEndTime() {
			return endTime;
		}

		public void setEndTime(long endTime) {
			this.endTime = endTime;
		}

		public TimeUnit getTimeUnit() {
			return timeUnit;
		}

		public void setTimeUnit(TimeUnit timeUnit) {
			this.timeUnit = timeUnit;
		}
		
		/*id相等则认为他们相等*/
		public boolean equals(Object obj) {
			return ((Wangmin)obj).id == this.id;
		}
		
	}
	
}
