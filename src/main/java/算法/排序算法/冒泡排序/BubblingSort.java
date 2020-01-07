package 算法.排序算法.冒泡排序;

import java.util.Arrays;
import java.util.Random;

/**
* 思路 :  通过相邻元素之间的比较和交换,将排序码较小的元素逐渐从底部移向顶部.由于整个排序的过程就像
             水底下的气泡一样逐渐向上冒,因此成为冒泡算法.
    
   逻辑 :
   
	   1) 最好的序列是,只有第一个和第二个无序,然后只排一趟就可以了.
	   
	   2) 最坏的序列是倒叙的,需要两两交换n-1次
	   
	   3) 每次排序都能把第一个位置排好,所以下一次排序,第一个元素就不用参与排序了.
	   
	   4) 当交换次数为0的时候代表排序已经完成
             
*/
public class BubblingSort {
	
	public static void main(String[] args) {
		
		//最好的结果,第一个和第二个无序,排一趟即可
		int[] bestArr =  {23, 1, 43, 54, 67, 765, 888};
		
		//最糟糕的数组,倒叙的时候,要排n-1次序
		int[] worstArr  = {888, 765, 67, 54, 43, 23, 1};
		
		//最好的排序
		sort(bestArr);
		
		//最差的结果
		sort(worstArr);
		
		//随机生成一个序列
		int[] randomArr = random(10, 1000);
		
		sort(randomArr);
		
		System.out.println("================用一个方法做冒泡排序=================");
		bubblingSort(random(10, 1000) , true);
		
	}
	
	/**
	* @function 随机生成一个数组
	* @param length 数组长度
	* @param max 数组元素的最大值,不包括该值
	* @author 肖荣辉
	* @date 2019年7月3日
	*/
	public static int[] random(int length , int max){
		
		Random random = new Random();
		
		int[] arr = new int[length];
		
		for(int i = 0 ; i < arr.length ; i ++){
			arr[i] = random.nextInt(max);
		}
		
		return arr;
	}
	
	/**
	* @function 给数组从小到大排序
	* @author 肖荣辉
	* @date 2019年7月3日
	*/
	public static void sort(int[] arr){
		
		System.out.println("正在给数组"+Arrays.toString(arr)+"排序,最少1次,最多"+(arr.length - 1)+"次\n");
		
		//数组长度
		int n = arr.length;
		
		//最多n - 1趟就能排好
		int x = n - 1;
		
		for(int i = 0 ; i < x ; i ++){
			
			//每排一趟序,总能把最小的浮到上面来,那么这个位置上的元素就不用排序了
			boolean isComplete = sort(arr , x , i);
			
			//判断是否排好序
			if(isComplete){
				System.out.println("==============排序已经完成 , 总共排了"+(i)+"次 , 是否有序 : "+isAsc(arr)+"=============\n");
				break;
			}
			
		}
		
	}
	
	
	/**
	* @function  对数组起始位置和结束位置的所有元素进行一次冒泡排序
	* @param arr 待排序的数组
	* @param start 数组起始位置
	* @param end 数组结束为止
	* @author 肖荣辉
	* @date 2019年7月3日
	* reutrn 是否已经排好序
	*/
	public static boolean sort(int[] arr ,  int start , int end){
		
		//置换次数,用于判断是否已经排好序
		int exchangeCount = 0;
		
		//最后一次交换的位置
		int lastExchangeIndex = end;
		
		for(int i = start ; i > end ; i --){
			
			//当前位置的值
			int current = arr[i];
			
			//上一个位置的值
			int prev = arr[i - 1];
			
			//从小到大排列(每一次循环,排一趟序会把最小的那个浮到最上面,就像气泡一样)
			//如果当前位置小于上一个位置,则交换位置,把更小的放到前面.
			if(current < prev){
				
				//上一个位置放更小的值
				arr[i - 1] = current;
				
				//当前位置放更大的值
				arr[i] = prev;
				
				//有交换,交换次数+1
				exchangeCount ++;
				
				//最后一次交换的位置
				lastExchangeIndex = i - 1;
			}
			
		}
		
		//打印排一趟的结果
		if(exchangeCount > 0){
			System.out.println("【" + arr[lastExchangeIndex] + "】就像气泡一样浮了上来 , 排完一趟的结果 :");
			System.out.println(Arrays.toString(arr));
			System.out.println();
		}
		
		//当没有置换的时候,代表已经排好序
		return exchangeCount == 0;
		
	}
	
	/**
	* @function 一个方法排好序
	* @param arr 待排序的数组
	* @param isAsc  true :  升序 , fase 降序
	* @author 肖荣辉
	* @date 2019年7月3日
	*/
	public static void bubblingSort(int[] arr , boolean isAsc){
		
		//最多排n-1趟就可以排好序
		for(int i = 0 ; i < arr.length - 1 ; i ++){
			
			//从最后一个位置开始和前一个比较
			boolean isComplete = true;
			
			for(int k = arr.length - 1 ; k > 0 ;  k --){
				
				int current = arr[k];
				int prev = arr[k - 1];
				
				//不需要交换的情况
				if((isAsc && current >= prev) || (!isAsc && current <= prev)) 
					continue;
				
				 arr[k - 1] = current;
				 arr[k] = prev;
				 isComplete = false;
				
			}
			
			//若排好序,则停止
			if(isComplete) break;
			
		}
		
		System.out.println("正在给数组 :  " + Arrays.toString(arr) + "进行冒泡排序 , 排序结果 : " + (isAsc ?  isAsc(arr) : isDesc(arr)));
		
	}
	
	/**
	* @function 判断数组是否是升序
	* @param  arr 待判断的数组
	* @author 肖荣辉
	* @date 2019年7月3日
	*/
	public static boolean isAsc(int[] arr){
		
		for(int i = 0 ; i < arr.length - 1 ; i ++){
			
			//当前位置的值
			int current = arr[i];
			
			//下一个位置的值
			int next = arr[i + 1];
			
			if(current > next)
				return false;
			
		}
		
		return true;
		
	}
	
	/**
	* @function 判断数组是否是降序
	* @param  arr 待判断的数组
	* @author 肖荣辉
	* @date 2019年7月3日
	*/
	public static boolean isDesc(int[] arr){
		
		for(int i = 0 ; i < arr.length - 1 ; i ++){
			
			//当前位置的值
			int current = arr[i];
			
			//下一个位置的值
			int next = arr[i + 1];
			
			if(current < next)
				return false;
			
		}
		
		return true;
	}
	
}
