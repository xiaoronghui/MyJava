package 算法.算法分类.动态规划法;

import java.util.HashMap;
import java.util.Map;

//分治法的应用
public class Divide {
	
	//保存计算过的值
	static Map<Integer , Integer>	 cacheMap = new HashMap<>();
	
	/**
	* @function 假设有一个自然数数组,第一个数为0,第二个数为1,数组从第3项后的每一项开始为前两项之和,
	 						数组下标为0...n.现在给定一个下标n,求出该位置上的数? (斐波那契数列)
	* @param n 数组索引,0...(n-1)
	* @author 肖荣辉
	* @date 2019年4月18日
	*/
	public static int getElement(int n){
		
		//如果已经有了,则直接返回
		if(cacheMap.get(n) != null){
			return cacheMap.get(n);
		}
		
		if(n == 0) return 0;
		
		if(n == 1) return 1;
		
		if(n > 1) {
			int s = getElement(n-1) + getElement(n-2);
			cacheMap.put(n , s);
			return s;
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		for(int i = 0 ; i < 10 ; i ++){
			System.out.print(getElement(i) + " ");
		}
	}
	
}
