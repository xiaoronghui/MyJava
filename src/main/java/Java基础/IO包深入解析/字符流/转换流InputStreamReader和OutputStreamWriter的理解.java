package Java基础.IO包深入解析.字符流;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import Java基础.IO包深入解析.PathUtils;

public class 转换流InputStreamReader和OutputStreamWriter的理解 {
	
	/**
	 *  这两个流的主要作用就是可以把字节流转换为字符流
	 *  
	 *  应用场合: 当用字节流读取一个文件的时候,发现是一个文本文件,这个时候就可以
	 *                  转换为字符流进行操作,更为方便;
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		String filePath = PathUtils.getClassFilePath(转换流InputStreamReader和OutputStreamWriter的理解.class) + File.separator + "说明";
		
		File file = new File(filePath);
		
		FileOutputStream fos = new FileOutputStream(file);
		
		//字节流转换为字符流
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		
		osw.write("马勒戈壁");
		osw.append("的草泥马");
		
		osw.close();
		
		FileInputStream fis = new FileInputStream(file);
		
		//输入流转化为字符输入流
		InputStreamReader isr = new InputStreamReader(fis);
		
		//包装一下
		BufferedReader br = new BufferedReader(isr);
		
		String temp ;
		
		while((temp = br.readLine()) != null){
			System.out.println(temp);
		}
		
		br.close();
		
	}
	
	
	
	
}
