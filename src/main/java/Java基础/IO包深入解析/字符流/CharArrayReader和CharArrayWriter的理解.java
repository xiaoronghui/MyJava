package Java基础.IO包深入解析.字符流;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;

public class CharArrayReader和CharArrayWriter的理解 {

	
	/**
	 *  这两个类的原理和字节的数组流一样,但是感觉没什么用
	 *  
	 *  这两个类为使用流操作字节数组提供了api
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		CharArrayWriter caw = new CharArrayWriter();
		
		caw.write("在马勒戈壁的荒漠上,有一群草泥马");
		
		char[] charArray = caw.toCharArray();
		
		caw.close();
		
		CharArrayReader car = new CharArrayReader(charArray);
		
		char[] charTemp = new char[1024];
		
		int len = car.read(charTemp);
		
		System.out.println(new String(charTemp, 0, len));
		
	}
	
	
}
