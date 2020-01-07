package Java基础.排序和查找;

import java.util.Arrays;

public class 各种排序 {
	public static void main(String[] args) {
		int[] arr1={95,56,23,56,65,23,68};
		mpSortAsc(arr1);
		mpSortDesc(arr1);
	}
	//冒泡排序(升序)
	public static void mpSortAsc(int[] arr){
		/*
		    {95,56,23,56,65,23,68};我想把该数组从小到大排序
		 	分析:
		 	   1) 使用循环遍历每一个元素,前后两个位置比较大小,把小的放到前一个位置上,
		 	       遍历一次,最大的数就会沉到数组末尾.
		 	       if(arr[i]>arr[i+1])..  -->因为i是最后一个的时候,i+1超出了数组范围,从而我们遍历
		 	       的范围是从0到arr.length-1
		 	       for(int i=0;i<arr.length-1;i++){
						if(arr[i]>arr[i+1]){
							temp=arr[i];
							arr[i]=arr[i+1];
							arr[i+1]=temp;
						}
					}
		 	       
		 	   2) 然后继续遍历,因为上一次末尾那个数已经排好,从而我们遍历的范围是从0到arr.length-2.
		 	       再遍历一次就是arr.length-3. 遍历n次就是arr.length-(1+n).
		 	       我们在外面再套一个循环,用于循环变化n.那么n的变化范围是多少呢?
		 	       最后一次比较是第1个和第2个的比较,那么arr.length-(1+n)范围只能是0到1,也就是说
		 	       arr.length-(1+n)最后的取值是1.
		 	       arr.length-(1+n)=1-->arr.length=1+(1+n)-->n=arr.length-2
		 */
		int temp;
		for(int n=0;n<=arr.length-2;n++){
			for(int i=0;i<arr.length-(1+n);i++){
				if(arr[i]>arr[i+1]){
					temp=arr[i];
					arr[i]=arr[i+1];
					arr[i+1]=temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	//冒泡排序(降序)
	public static void mpSortDesc(int[] arr){
		/*
		 	 {95,56,23,56,65,23,68};我想把该数组从大到小排序
		 	 分析:
		 	     1) 使用循环遍历每一个元素,前后两个位置比较大小,把大的放到前一个位置上,
		 	       遍历一次,最小的数就会沉到数组末尾.
		 	       if(arr[i]>arr[i+1])..  -->因为i是最后一个的时候,i+1超出了数组范围,从而我们遍历
		 	       的范围是从0到arr.length-1
		 	       for(int i=0;i<arr.length-1;i++){
						if(arr[i]<arr[i+1]){
							temp=arr[i];
							arr[i]=arr[i+1];
							arr[i+1]=temp;
						}
					}
			 	2) 然后继续遍历,因为上一次末尾那个数已经排好,从而我们遍历的范围是从0到arr.length-2.
		 	       再遍历一次就是arr.length-3. 遍历n次就是arr.length-(1+n).
		 	       我们在外面再套一个循环,用于循环变化n.那么n的变化范围是多少呢?
		 	       最后一次比较是第1个和第2个的比较,那么arr.length-(1+n)范围只能是0到1,也就是说
		 	       arr.length-(1+n)最后的取值是1.
		 	       arr.length-(1+n)=1-->arr.length=1+(1+n)-->n=arr.length-2
		 	    总结:
		 	        冒泡排序就是没排一次序,都能排出一个沉到末尾,就像冒泡一样,不管从水的哪个位置都能冒到顶部.
		 	        升序和降序只不过把arr[i]<arr[i+1]的">"号改为小于号就可以了
		 */
		int temp;
		for(int n=0;n<=arr.length-2;n++){
			for(int i=0;i<arr.length-(1+n);i++){
				if(arr[i]<arr[i+1]){
					temp=arr[i];
					arr[i]=arr[i+1];
					arr[i+1]=temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
