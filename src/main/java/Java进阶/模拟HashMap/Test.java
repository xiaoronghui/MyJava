package Java进阶.模拟HashMap;

import java.util.HashMap;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		//HashMap map=new HashMap();
	}
	//测试MyHashMap类
	public static void test1(){
		MyHashMap map=new MyHashMap();
		map.put("name", "张飞");
		map.put("sex", "男");
		map.put("hobby", "篮球");
		map.put("age", "26");
		System.out.println(map.get("name"));
		System.out.println(map);
		map.remove("age");
		System.out.println(map);
		System.out.println(map.containsKey("name"));
		System.out.println(map.containsKey("sdf"));
		map.put("name", "关羽"); //
		System.out.println(map);
		MyHashMap map2=new MyHashMap();
		map2.put("ab", "你好");
		map2.put("cd", "长城");
		map.putAll(map2);
		System.out.println(map);
	}
}
