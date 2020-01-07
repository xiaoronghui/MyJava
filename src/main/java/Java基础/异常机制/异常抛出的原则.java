package Java基础.异常机制;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

public class 异常抛出的原则 {
	
	/*
	 *  抛出异常三原则 : 

		    具体明确 : 应该抛出具体的异常,而不是想也不想统一抛出exception
		
		    提早抛出 : 什么地方可能出问题,那么就什么地方抛出
		
		    延迟捕获 : 当异常发生时，不应立即捕获，而是应该考虑当前作用域是否有有能力处理这一异常的能力，
		
		                     如果没有，则应将该异常继续向上抛出，交由更上层的作用域来处理。
		                     
		   参考 : http://www.importnew.com/20645.html                  
		      
	 * 
	 * */
	public static void main(String[] args) {
		
		try {
			String filePath = "/config/将夜.txt";
			String txt = readFile(filePath);
			System.out.println(txt);
		} catch (FileNotFoundException e) {
			System.out.println("文件未找到!");
		} catch (IOException e) {
			System.out.println("读取文件异常!");
		}
		
	}
    
	/**
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static String readFile(String filePath) throws FileNotFoundException, IOException {
		
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		
		try {
			
			URL url = Object.class.getResource(filePath);
			
			if(url == null){
				throw new FileNotFoundException();
			}
			
			String path = url == null ? null : java.net.URLDecoder.decode( url.getPath() ,Charset.defaultCharset().name());
			
			InputStream in  = new FileInputStream(new File(path));
			
			Reader reader = new InputStreamReader(in);
			
			 br = new BufferedReader(reader);
		
			String buff = null;
			
			while((buff = br.readLine()) != null){
				sb.append(buff);
			}
		
		} finally{
			if(br != null)
				br.close();
		}
		
		return sb.toString();
	}
	
	
	
	
	
	
}
