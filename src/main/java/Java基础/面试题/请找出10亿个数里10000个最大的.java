package Java基础.面试题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class 请找出10亿个数里10000个最大的 {
	public static void main(String[] args) {
		test2();
	}
	/**
	 * 1000万个数,找出最大的10000个数
	 * @param
	 * @author ronghui.xiao
	 * @date 2015-2-2
	 * @return
	 */
	public static void test2(){
		int[] arr=createArr(10000000);
		int[] temp=new int[10000];
		//f1(arr,temp);
		//f2(arr,temp);
		f3(arr,temp);
	}
	//每次记住最小的那个数的索引,时间大概是200ms左右
	public static void f3(int[] arr,int[] temp){
		long startTime=System.currentTimeMillis();
		Arrays.sort(temp); //排序;
		//-----------------------------------------------------------
		int minIdx=0;
		int zoneIdx=minIdx;
		for(int i=temp.length;i<arr.length;++i){
			if(arr[i]>temp[minIdx]){
				temp[minIdx]=arr[i];
				if(minIdx==zoneIdx)zoneIdx++;
				if(zoneIdx>=600){ //没必要等到整个数组都比完了才去排序,没600个排一次序,不然超找最小值的范围会越来越大.在600这个范围就好了
					Arrays.sort(temp); //排序;
					minIdx=0;
					zoneIdx=minIdx;
					continue;
				}
				//每次替换完之后,拿着可能是最小的位置和换好的比
				int idx=zoneIdx; //后续元素中最小的那个,如果换好的元素都比它大,那么最小元素依然是它.若换好的元素有一个A元素比它小,那最小元素就是A
				int lastIdx=idx-1; //上一次位置
				for(;lastIdx>=0;lastIdx--){ //查找最小的那个元素
					if(temp[lastIdx]<temp[idx]){  //
						idx=lastIdx;
					}
				}
				minIdx=idx;
			}
		}
		//-----------------------------------------------------------
		long endTime=System.currentTimeMillis();
		System.out.println(endTime-startTime+"ms");
		Arrays.sort(temp); //排序;
		System.out.println(Arrays.toString(temp));
	}
		//每次记住最小的那个数的索引,时间大概是2000ms左右
		public static void f2(int[] arr,int[] temp){
			long startTime=System.currentTimeMillis();
			Arrays.sort(temp); //排序;
			//-----------------------------------------------------------
			int minIdx=0;
			int zoneIdx=minIdx;
			for(int i=temp.length;i<arr.length;++i){
				if(arr[i]>temp[minIdx]){
					temp[minIdx]=arr[i];
					if(minIdx==zoneIdx)zoneIdx++;
					if(zoneIdx>=temp.length){ //若是temp中的最后一个,重新排序,跳过这次循环
						Arrays.sort(temp); //排序;
						minIdx=0;
						zoneIdx=minIdx;
						continue;
					}
					//每次替换完之后,拿着可能是最小的位置和换好的比
					int idx=zoneIdx; //后续元素中最小的那个,如果换好的元素都比它大,那么最小元素依然是它.若换好的元素有一个A元素比它小,那最小元素就是A
					int lastIdx=idx-1; //上一次位置
					for(;lastIdx>=0;lastIdx--){ //查找最小的那个元素
						if(temp[lastIdx]<temp[idx]){  //
							idx=lastIdx;
						}
					}
					minIdx=idx;
				}
			}
		//-----------------------------------------------------------
		long endTime=System.currentTimeMillis();
		System.out.println(endTime-startTime+"ms");
		Arrays.sort(temp); //排序;
		System.out.println(Arrays.toString(temp));
	}
	//每次都排序
	public static void f1(int[] arr,int[] temp){
		long startTime=System.currentTimeMillis();
		//减少排序的次数
		for(int i=temp.length-1;i<arr.length;i++){
			if(arr[i]>temp[0]){
				temp[0]=arr[i];
				Arrays.sort(temp);
			}
		}
		long endTime=System.currentTimeMillis();
		System.out.println(endTime-startTime+"ms");
		System.out.println(Arrays.toString(temp));
	}
	//创建一个随机数组
	public static int[] createArr(int num){
		int[] arr=new int[num];
		for(int i=0;i<num;i++){
			arr[i]=(int)(Math.random()*num);
		}
		return arr;
	}
}
