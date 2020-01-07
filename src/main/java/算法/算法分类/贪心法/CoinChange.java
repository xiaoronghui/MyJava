package 算法.算法分类.贪心法;

/**
    钱币找零问题 : 
    
		这个问题在我们的日常生活中就更加普遍了。假设1元、2元、5元、10元、20元、50元、100元的纸币分别有c0, c1, c2, c3, c4, c5, c6张。
		
		现在要用这些钱来支付K元，至少要用多少张纸币？用贪心算法的思想，很显然，每一步尽可能用面值大的纸币即可。在日常生活中我们
		
		自然而然也是这么做的。在程序中已经事先将Value按照从小到大的顺序排好。
		
	结论 : 
		
		可以看出，求出的结果也刚好等于442元。正好为最优解。但是，当面额及数量为下种特殊情况时，贪心算法就无法给出最优解。
		
		于是我们可以看出，有些情况，贪心算法确实可以给出最优解，然而，还有一些问题并不是这种情况。对于这种情况，我们关心的是近似解，
		 
		或者只能满足于近似解，贪心算法也是有价值的。
		
 *
 */
public class CoinChange {
	
    public static void main(String[] args) {
        //人民币面值集合
        int[] values = { 1, 2, 5, 10, 20, 50, 100 };
        //各种面值对应数量集合
        int[] counts = { 3, 1, 2, 1, 1, 3, 5 };
//        int[] counts = {1, 0, 0, 0, 0, 0, 0 };
        //求442元人民币需各种面值多少张
        int money = 419;
        int[] num = change(money, values, counts);
        
        print(money , num, values , counts);
    }

    public static int[] change(int money, int[] values, int[] counts) {
    	
        //用来记录需要的各种面值张数
        int[] result = new int[values.length];
        
        //从面值大的往面值小的开始查找,所以每一次都是在寻求最优解
        for (int i = values.length - 1; i >= 0; i--) {
        	
            int num = 0;
            
            //需要最大面值人民币张数
            int c = min(money / values[i], counts[i]);
            
            //剩下钱数
            money = money - c * values[i];
            
            //将需要最大面值人民币张数存入数组
            num += c;
            
            result[i] = num;
        }
        return result;
    }

    /**
     * 返回最小值
     */
    private static int min(int i, int j) {
        return i > j ? j : i;
    }
    
    private static void print(int money , int[] num, int[] values ,  int[] counts) {
    	
    	int sum = 0;
    	
    	int total = 0;
    	
        for (int i = 0; i < values.length; i++) {
        	
        	if (num[i] != 0) {
        		sum += values[i] * num[i];
                System.out.println("需要面额为" + values[i] + "的人民币" + num[i] + "张");
            }
        	
        	total +=  values[i] * counts[i];
        }
        
        if(sum == money){
        	System.out.println("刚刚好凑齐");
        }
        
        if(sum < money && money > total ){
        	System.out.println("余额不足 , 还差"+money+" - "+total+" = "+ (money - total)+"元");
        }
        
        if(sum < money && money <= total){
        	System.out.println("当前余额无法找零,现在是sum = " + sum + "元,还要"+(money - sum)+"元");
        }
        
        
    }
}