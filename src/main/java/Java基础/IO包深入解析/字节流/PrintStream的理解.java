package Java基础.IO包深入解析.字节流;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;

public class PrintStream的理解 {

	/*
	 *  System是一个对象,而out是System的一个属性,类型就是PrintStream,
	 *  
	 *  用了这么久,偏偏就忽略了PrintStream,就从来未对out属性的由来产生过疑问.
	 * 
	 * */
	public static void main(String[] args) throws IOException {
		
		System.out.println("====================");
		
		PrintStream printStream = System.out;
		
		//格式化并打印
		printStream.format("%1$tF %1$tT", new Date());
		
		printStream.println("你好呀");
		
		//写入一个字节数组并打印
		printStream.write("草泥马".getBytes());
		
		//和print一个意思,内部调用的就是print
		printStream.append("abc");
		printStream.append("dg");
		
	}
	
	
	
}
