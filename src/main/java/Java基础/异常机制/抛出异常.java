package Java基础.异常机制;

import java.io.File;
import java.io.FileNotFoundException;

public class 抛出异常 {
	public static void main(String[] args) {
		/*
		 	抛出异常就是指把可能产生的异常抛给外界去处理.
		 	比如我以前做的事务处理就是需要别人把异常给抛出来.
		 	注意:
		 	   方法重写的时候,子类抛出的异常的范围不能比父类的大,否则会编译错误;
		 	
		 */
		try {
			compute(1,2);
		} catch (Exception e) {
			e.printStackTrace();
		};
		readFile(); 
	}
	
	public static int compute(int a,int b) throws Exception{
		return a/b;
	}
	//自己创建一个异常
	public static void readFile(){
		File file=new  File("d:/my.txt");
		try {
			if(!file.exists()){
				throw new FileNotFoundException("文件没有找到!");
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
