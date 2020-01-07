package Java基础.排序和查找;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
* @function String的compareTo方法按字母排序的研究
* @author 肖荣辉
* @date 2018年6月4日
*/
public class String的compareTo方法 {
	
	
	public static void main(String[] args) {
		
		
		
		List<String> list = Arrays.asList("nice","can","i","fuck","you","userName");
		
		Collections.sort(list , new Comparator<String>() {

			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
			
		});
		
		/*序号大小和我们读的顺序是成正比的 ,大写的从65开始,小写的从97开始*/
		String letters = "abcdefghijklmnopqrstuvwxyz";
		
		char[] lettersArr = letters.toCharArray();
		
		for(int i = 0 ; i < lettersArr.length ; i ++){
			char item = lettersArr[i];
			int  intValue = (int) item;
			String bigItem =  String.valueOf(item).toUpperCase();
			System.out.println(item + " : " + intValue + "==>" + bigItem + " : " + (int)bigItem.toCharArray()[0]);
		}
		
		
		/*String 的compareTo方法解析*/
		
		/**
		 * 1.先从首字母往后比较两个字母的序号,只要发现第N个字母不一样,且谁的字母序号更小,谁就排在前面
		 * 
		 * 2.如果一个两个字符串首字母按顺序比较都一样,则谁的长度更小,谁就排在前面
		 * 
		 */
//		 public int compareTo(String anotherString) {
//		        int len1 = value.length;
//		        int len2 = anotherString.value.length;
//		        int lim = Math.min(len1, len2);
//		        char v1[] = value;
//		        char v2[] = anotherString.value;
//		        int k = 0;
//		        while (k < lim) {
//		            char c1 = v1[k];
//		            char c2 = v2[k];
//		            if (c1 != c2) {
//		                return c1 - c2;
//		            }
//		            k++;
//		        }
//		        return len1 - len2;
//		    }
		  
		
	}
	
}
