package Java基础.文件操作;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;

/**
 * 读写的工具类
 * @param
 * @author ronghui.xiao
 * @date 2015-1-27
 * @return
 */
public class OperFileUtil {
	//读取文件并打印
	public static void printFile(File file ){
		try {
			Reader reader=new FileReader(file);
			BufferedReader br=new  BufferedReader(reader);
			String str;
			while((str=br.readLine())!=null){
				System.out.println(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//读取文件并打印(重载)
	public static void printFile(String path){
		try {
			File file=new File(path);
			Reader reader=new FileReader(file);
			BufferedReader br=new  BufferedReader(reader);
			String str;
			while((str=br.readLine())!=null){
				System.out.println(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
