package Java基础.排序和查找;

import java.util.Arrays;

public class 二分法查找 {
	public static void main(String[] args) {
		int[] arr1={95,56,23,56,65,23,68,0,2,3,94,6};
		binarySearch(arr1,95);
		binarySearch(arr1,94);
	}
	
	//二分法查找
	public static void binarySearch(int[] arr,int searchWord){
		/*
		 	什么叫二分法查找?为什么要使用二分法查找?
		 	  比如有100万资料,他们都有一个编号,是0-100万,杂乱无章的存放在数组里头,现在我想找
		    54213这个编号的资料放在哪里的,该怎么办呢?
		    分析:
		         1) 遇到这个问题的时候,我们可能想的就是,一份一份资料取出来,然后看他们的编号是多少,
		             如果是我们想要找的那就拿出来.
		             这样找实在是太麻烦了.我么需要检查的次数实在太多,累都会累死,效率太低.
		         2) 因为效率太低,从而我们就像,如何用最少的检查次数找到我们所要的资料?
		             我们可以把这100万份资料按编号从小到大的排好序,然后找54213,那我们就
		             从5万以上开始找,一会就找到了.
		         3) 对于计算机来说,当100万个数字存放在数组的时候,我们先排好序,然后找54213,
		             我们把54213和中间那个位置的数字进行比较,如果大于,则只找数组的后半部分,如果
		             小于,则只找数组的上办部分.同理,当从其中一部分找的时候,又跟中间那个数比较,依此
		             类推,最终找到54213这个数,而且效率高的多;
		        
		             
		           
		 */
		Arrays.sort(arr); //排序
		int arrLen=arr.length;
		System.out.println(Arrays.toString(arr));
		System.out.println("arrLen/2:"+arrLen/2);
		int iIndex=0;
		int iStart=0;  //起始位置
		int iEnd=arr.length-1; //结束位置
		for(int i=0;i<arrLen/2;i++){ //最多查询一半的次数就可以找到,从而是arr.length
			//当只有第一个和第二个的时候,那就是(0+1)/2=0 取的是第1个,因为iEnd是上一次的中间那个.从而取前一个
			//当只有倒数第二个和最后一个的时候,那就是(10+11)/2=9 取的是第1个,但是发现不是这个.然后又循环一次,
			//这次循环会不会死循环啊?由于我们限制了最多一半的次数,从而不会死循环.但是倒数第二个和最后一个还是会有重复的现象.
			//我们可以通过判断限制这种现象
			iIndex=(iStart+iEnd)/2; 
			System.out.println("i:"+i+" iStart:"+iStart+" iEnd:"+iEnd+" 索引值:"+iIndex+" arr[iindex]:"+arr[iIndex]+" searchWord:"+searchWord);
			if(arr[iIndex]<searchWord){ //如果大于
			      if(iIndex==arrLen-2){  //如果是最后一个,那么我们把起始位置设为最后一个,省的重复循环
			    	  iStart=arrLen-1;
			      }else{
			    	  iStart=iIndex; //起始位置变成中间这个位置
			      }
			}else if(arr[iIndex]>searchWord){ //如果小于
			      iEnd=iIndex;  //终点位置变成中间那个
			}else if(arr[iIndex]==searchWord){
				System.out.println("找到了,索引位置是:"+iIndex);
				break;
			}else{
				System.out.println(searchWord+"不在数组中!");
				break;         
		    }
		}
	}
}
