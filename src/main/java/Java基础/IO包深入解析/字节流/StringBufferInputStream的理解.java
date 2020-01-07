package Java基础.IO包深入解析.字节流;

import java.io.IOException;
import java.io.StringBufferInputStream;
import java.io.StringReader;


public class StringBufferInputStream的理解 {
	
	/**
	 *  这个类的作用主要就是通过流来访问字符串 , 其实和数组流差不多,但是这个流已经过时,推荐使用StringReader
	 * 
	 *  读出来的东西也乱码,而用StringReader就不会有乱码
	 *  
	 */
	public static void main(String[] args) throws IOException {
		
		StringBufferInputStream sbs = new StringBufferInputStream("张飞");
		
		byte[] buff = new byte[1024];
		
		int len;
		
		while((len = sbs.read(buff)) != -1){
			System.out.println(new String(buff,0,len,"utf-8"));
		}
		
		sbs.close();
		
		char[] chars = new char[1024];
		len = 0;
		
		StringReader sr = new StringReader("张飞");
		
		while((len = sr.read(chars)) != -1){
			System.out.println(new String(chars,0,len));
		}
		
	}
	
	
}
