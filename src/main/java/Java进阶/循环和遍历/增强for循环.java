package Java进阶.循环和遍历;

//JAVA的foreach语法中，冒号后面的变量可以是两种，一个是数组，一个便是实现了Iterable接口的任何类，
//增强for循环称之为foreach语法
public class 增强for循环 {
	public static void main(String[] args) {
		int[] arr={3,12,4,6,2,4,6,23,5};
		for(int k :arr){
			System.out.println(k);
		}
	}
}
