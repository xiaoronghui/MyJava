package Java并发包.队列Queue容器;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;


public class ArrayBlockingQueue测试 {
	
	public static void main(String[] args) throws Exception{
		
		ArrayBlockingQueue<String> q = new ArrayBlockingQueue<String>(3);
		q.add("张飞");
		q.offer("关羽"); //在ConcurrentLinkedQueue中,add和offer的作用是一样的
		q.add("马超");
		//q.add("黄忠");  //有界队列,超过长度添加会报异常
//		System.out.println(q.poll() + " size ：" + q.size());  //取得第一个元素,并删除到第一个
		System.out.println(q.take() + " size ：" + q.size());  //取得第一个元素,并删除到第一个
		System.out.println("是否执行到这一步");
//		System.out.println(q.peek() + " size ：" + q.size()); //取得第一个元素,并不删除
		
		System.out.println(q.offer("刘备", 3, TimeUnit.SECONDS));  //如果队列已经满了,就等待3秒,3秒后再去加入,如果加成功了则返回true,否则返回false
	}
	
}
