package Java基础.IO包深入解析.字符流;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Java基础.IO包深入解析.PathUtils;

public class BufferedReader和BufferedWriter的理解 {
	
	/**
	 * 
	 * BufferedReader和字节缓冲输入流的原理是一样的,该流有一个好处就是可以读取一整行,很方便
	 * BufferedWriter和字节缓冲输出流的原理是一样的,该流有一个好处就是可以写一整行和追加一行,很方便
	 * 
	 */
	public static void main(String[] args) throws IOException {
		
		String filePath = PathUtils.getClassFilePath(BufferedReader和BufferedWriter的理解.class) + File.separator + "说明";
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filePath)));
		
		bw.write("你好呀");
		bw.append("=======================================");
		
		bw.close();
		
		
		BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
		
		String temp ;
		
		while((temp = br.readLine()) != null){
			System.out.println(temp);
		}
		
		br.close();
		
		
	}
	
	
}
