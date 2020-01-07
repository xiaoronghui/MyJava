package Java基础.JDK工具类;

import java.util.Enumeration;
import java.util.ListResourceBundle;

/**
 * 该类好像模拟一个属性文件,好像没什么卵用,完全可以使用hashMap
 */
public class ListResourceBundle_Test extends ListResourceBundle{
	
	  protected Object[][] getContents() {
		  	
			 Object[][] arr = {
					 
				         {"s1", "The disk \"{1}\" contains {0}."}, 
				         {"s2", "1"},                        
				         {"s3", "My Disk"},                     
				         {"s4", "no files"},                      
				         {"s5", "one file"},                      
				         {"s6", "{0,number} files"},                
				         {"s7", "3 Mar 96"}          
			  };
			  
	         return arr;
	   }

	  public static void main(String[] args) {
		 
		  ListResourceBundle_Test lb = new ListResourceBundle_Test();
		  
		  Enumeration<String> enumeration = lb.getKeys();
			
			while(enumeration.hasMoreElements()){
				String key = enumeration.nextElement();
				System.out.println(key + " = " + lb.getString(key));
			}
	  }
	  
}
