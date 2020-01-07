package Java基础.文件操作;

import java.io.File;
import java.util.Arrays;

public class 以树状结构打印目录及子目录 {
	public static void main(String[] args) {
		/*
		 	目的:
		 	   以树状结构打印D盘下的Myplan目录
		 	解析: 
		 	    1.我可以创建Myplan目录的File对象.我如何去遍历它的子目录?
		 	    2.去JDK找找看..file.list()返回一个字符串数组,里面存的是子文件的文件名
		 	    3.我想以什么样的形式显示呢?
		 	    4.显示的结构就是,子文件名的前面总是比父文件多一个"-"
		 	    5.我已经打印了该目录下的所有文件名,如何加上层级结构?
		 	    6.做是做出来了,但是要传两个参数,而且不能控制,层级间的符号;
		 	    7.经过改造好多了
		 	    总结:
		 	       老师的做法比我的做法好多了,我的做法太蠢了..
		 */
		File file=new File("d:/MyPlan");
		//String[] names=file.list();
		//System.out.println(Arrays.toString(names));
		//printTreeDir(file,"~");//我的做法
		printTreeDir2(file,0); //老师的做法
	}
	
	//打印树状结构(我的做法)
	public static void printTreeDir(File file,String prefix){
		System.out.println(prefix+file.getName());
		prefix+=prefix;
		if(file.isDirectory()){
			String[] arr=file.list();
			for(String temp :arr){
				File son=new File(file, temp);
				printTreeDir(son,prefix);
			}
		}
	}
	
	//打印树状结构(老师的做法)
	public static void printTreeDir2(File file,int level){
		String str="";
		for(int i=0;i<level;i++){
			str+="-";
		}
		System.out.println(str+file.getName());
		if(file.isDirectory()){
			String[] arr=file.list();
			for(String temp :arr){
				File son=new File(file, temp);
				printTreeDir2(son,level+1); //不能用++level,否则会印象其它节点
			}
		}
	}
}
