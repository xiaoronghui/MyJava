package Java基础.IO包深入解析.字符流;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;

import Java基础.IO包深入解析.PathUtils;


/**
 * 
 * PushbackReader和PushbakInputStream的原理一样:
 * 
 *   PushbackReader类在初始化的时候声明的一个1字符的数组buf,当然也可以在构造的时候指定长度.pos初始的时候等于buf.length,
 *  当我们往这个数组里面unread(b[] b) 的时候,如果b比buf小,则b数组会被拷贝到buf的尾部,每次读取read(c[] c) 总会
 *  先把buf中尾部的那块内容先拷贝c的前面.然后pos恢复为buf.length. 说白了,就是定义一个缓冲区供你存放临时的字节数组,
 *  再读取的时候每次把这个字符带上.
 * 
 *   应用场景 :
 *   
       可以试探性地读取一个字符，看是否符合要求，然后再回退回去一个字符后，再读取后续的字符。
         
       有时候我们可以读取某些文本,如果不是xxx作者写的,就不读. 

 */
public class PushbackReader的理解 {

	public static void main(String[] args) throws IOException {
		
		String filePath = PathUtils.getClassFilePath(BufferedReader和BufferedWriter的理解.class) + File.separator + "说明";
		
		File file = new File(filePath);
		
		PushbackReader pr = new PushbackReader(new FileReader(file));
		
		pr.unread(new char[]{'A'});
		
		BufferedReader br = new BufferedReader(pr);
		
		System.out.println(br.readLine());
		
		br.close();
		
	}
	
	
}
