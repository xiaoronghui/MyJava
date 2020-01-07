package Java基础.面试题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _10万个字符串求前10个出现次数最多字符串 {
	public static void main(String[] args) {
		test1();//使用200个数字好了
	}
	/**
	 *200个数字,求前10个出现次数最多的
	 * @param
	 * @author ronghui.xiao
	 * @date 2015-2-2
	 * @return
	 */
	public static void test1(){
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<200;i++){
			list.add((int)(Math.random()*10));
		}
		System.out.println(list);
		Set set=new HashSet();
		set.add(list.get(0));
		set.add(list.get(1));
		set.add(list.get(2));
		set.add(list.get(3));
		set.add(list.get(4));
		System.out.println(set);
		int size=set.size();
		Map map=new HashMap();
		Iterator iterator=set.iterator();
		while(iterator.hasNext()){
			map.put(iterator.next(), 0);
		}
		//有两百个数字,求前10个出现次数最多的那个
		for(int i :list){
			if(set.contains(i)){
				map.put(i, (Integer)map.get(i)+1);
			}
		}
		System.out.println(map);
	}
}
