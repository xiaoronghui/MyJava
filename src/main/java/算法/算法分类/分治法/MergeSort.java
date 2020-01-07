package 算法.算法分类.分治法;

//归并排序
public class MergeSort {
	
    //两路归并算法，两个排好序的子序列合并为一个子序列
    public static void merge(int []a,int left,int mid,int right){
    	
    	//k用于记录要排序的那个小规模数组的位置,temp为排好序后的数组,用于置换原来没排序的那些位置,所以k=left
        int []tmp=new int[a.length];
        
        int p1=left,p2=mid+1,k=left;//p1、p2是检测指针，k是存放指针

        while(p1<=mid && p2<=right){
        	tmp[k++] = a[p1]<= a[p2] ? a[p1++] : a[p2++];  //从小到大放到tmp中去
        }
        
        //如果左边的数组全部都大于右边,则左边的指针没有往下移动,所以要把左边的依次放到临时数组中,如果加上下面这两个循环,
        //则说明两个数组比较最少要比较len1+len2次.len表示每个数组的长度
        while(p1<=mid) tmp[k++]=a[p1++];
        
        //原理同上
        while(p2<=right) tmp[k++]=a[p2++];//同上

        //复制回原数组
        for (int i = left; i <=right; i++) 
            a[i]=tmp[i];
        
    }

    public static void mergeSort(int [] a,int start,int end){
        if(start<end){//当子序列中只有一个元素时结束递归
            int mid=(start+end)/2;//划分子序列
            mergeSort(a, start, mid);//对左侧子序列进行递归排序  
            mergeSort(a, mid+1, end);//对右侧子序列进行递归排序
            merge(a, start, mid, end);//合并
        }
    }
    
    public static void main(String[] args) {
    	 int[] a = { 49, 38, 65, 97, 76, 13, 27, 50 };
         mergeSort(a, 0, a.length-1);
         System.out.println("排好序的数组：");
         for (int e : a)
             System.out.print(e+" ");
	}

}
