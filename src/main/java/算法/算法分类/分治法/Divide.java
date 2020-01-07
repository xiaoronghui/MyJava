package 算法.算法分类.分治法;

//分治法的应用
public class Divide {
	
	/**
	* @function 假设有一个自然数数组,第一个数为0,第二个数为1,数组从第3项后的每一项开始为前两项之和,
	 						数组下标为0...n.现在给定一个下标n,求出该位置上的数?
	* @param n 数组索引,0...(n-1)
	* @author 肖荣辉
	* @date 2019年4月18日
	*/
	public static int getElement(int n){
		
		if(n == 0) return 0;
		
		if(n == 1) return 1;
		
		if(n > 1) 
		  return getElement(n-1) + getElement(n-2);  //递归调用
		
		return 0;
	}
	
	public static void main(String[] args) {
		for(int i = 0 ; i < 10 ; i ++){
			System.out.print(getElement(i) + " ");
		}
	}
	
}
