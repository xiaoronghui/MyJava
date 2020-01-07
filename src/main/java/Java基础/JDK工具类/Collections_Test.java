package Java基础.JDK工具类;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Collections_Test {
	
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		
		Collections.addAll(list, 1,3,2,4,5);
		
		System.out.println(list);
		
		System.out.println("==========================");
		
		//双端队列转化成单向的对列(只支持在头部弹出和添加)
		LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(1,2,3));
		
		Queue<Integer> rQue = Collections.asLifoQueue(linkedList);
		
		System.out.println(rQue);
		System.out.println(rQue.poll());
		rQue.add(4);
		System.out.println(rQue);
		
		//排序
		Collections.sort(list);
		System.out.println(list);
		
		//随机打乱顺序
		Collections.shuffle(list);
		
		System.out.println(list);
		
		
		
		
		
	}
	
}
