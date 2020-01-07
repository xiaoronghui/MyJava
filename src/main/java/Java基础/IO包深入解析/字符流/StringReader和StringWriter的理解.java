package Java基础.IO包深入解析.字符流;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class StringReader和StringWriter的理解 {
	
	
	/**
	 *  这两个类的作用主要就是通过流来访问字符串
	 *  
	 *  应用场景:
	 *    当服务器接收到一个字符串的时候,但是暴露的接口是有流,我们可以通过这两个流来读写.
	 */
	public static void main(String[] args) throws IOException {
		
		String msg  = "在马勒戈壁的荒漠上,有一群草泥马";
		
		StringWriter sw = new StringWriter();
		
		sw.write(msg.toCharArray());
		
		sw.toString();
		
		sw.close();
		
		StringReader sr = new StringReader(sw.toString());
		
		char[] buff = new char[msg.toCharArray().length];
		
		sr.read(buff);
		
		System.out.println(new String(buff));
		
		sr.close();
		
		
		
		
	}
	
	
	
	
}
