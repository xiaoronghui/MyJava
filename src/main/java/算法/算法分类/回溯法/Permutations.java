package 算法.算法分类.回溯法;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    //给定一个数组,求数组可能存在的所有排列集合
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list , new ArrayList<Integer>() , nums);
        return list;
    }

    private static  void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums){
        
    	//回溯条件,回溯点,回溯到上一层调用的地方
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
        	
        	if(tempList.contains(nums[i])){
        		continue;
        	}
            
            tempList.add(nums[i]);
            
            backtrack(list, tempList, nums);
            
       	    System.out.println(tempList + "已经走不通了,需要剔除一个["+tempList.get(tempList.size() - 1)+"]试试看");
       	    
            tempList.remove(tempList.size() - 1);
        }
        
    }

    public static void main(String[] args){
        int[] nums={1,2,3};
        List<List<Integer>> list = permute(nums);
        System.out.println(list);
    }
}