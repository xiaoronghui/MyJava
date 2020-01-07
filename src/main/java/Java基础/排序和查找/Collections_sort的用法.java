package Java基础.排序和查找;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Collections_sort的用法 {

	
	/**
	 * 
	 * 注 : sort方法会改变原有数组点位置,是引用传递
	 */
	public static void main(String[] args) {
		
		//数组默认情况下是按照升序排序
		List<Integer> numbers = Arrays.asList(1,4,2,143,0,543,12,76,2343);
		Collections.sort(numbers);
		System.out.println(numbers);
		
		//如果需要降序,使用反转方法reverse即可
		Collections.reverse(numbers);
		System.out.println("如果需要降序,使用反转方法reverse即可==>");
		System.out.println(numbers);
		
		//字符默认情况下是按照升序排序
		List<Character> letters = Arrays.asList('z','b','d','m','e');
		Collections.sort(letters);
		System.out.println(letters);
		
		//字符串字符默认情况下是按照升序排序
		List<String> strings = Arrays.asList("z","b","d","m","e");
		Collections.sort(strings);
		System.out.println(strings);
		
		//字符串默认情况下是按照首字母升序排序
		List<String> strings2 = Arrays.asList("z43","b123","d543","m534","ese");
		Collections.sort(strings2);
		System.out.println(strings2);
		
		//混合字符点排序规则 (数字排在最前，英文字母其次，汉字不知道按什么排序)
		List<String>mixstrings = Arrays.asList("234","乌龟54","adsb","魔王","傻逼");
		Collections.sort(mixstrings);
		System.out.println(mixstrings);
		
		/*当我们排序的是自定义对象点时候,sort方法不知道怎么排序,所以需要我们告诉它怎么排序*/
		/**
		 * compare（a,b）方法:根据第一个参数小于、等于或大于第二个参数分别返回负整数、零或正整数。
		 */
		List<Cat> cats = Arrays.asList(new Cat(45),new Cat(54),new Cat(21),new Cat(3),new Cat(2));
		
		Collections.sort(cats , new Comparator<Cat>() {
			
			public int compare(Cat cat1, Cat cat2) {
				
				if(cat1.age < cat2.age){
					return -1;
				}else if(cat1.age > cat2.age){
					return 1;
				}
				
				return 0;
			}
		});
		
		System.out.println(cats);
		Collections.reverse(cats);
		System.out.println(cats);
	}
	
	
	//猫类
	static class Cat{
		int age;
		public Cat(int age){
			this.age = age;
		}
		@Override
		public String toString() {
			return "Cat"+age;
		}
	}
	
}
