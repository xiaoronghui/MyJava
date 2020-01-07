package Java基础.IO包深入解析;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


/**
* @function 文件工具类
* @author 肖荣辉
* @date 2018年8月1日
*/
public class FileUtils {
	
	/**
	* @function 保存到磁盘
	* @author 肖荣辉
	* @date 2018年8月1日
	*/
	public static void save2disk(byte[] data , String path , String fileName ) throws IOException{
	
		File file = new File(path);
		file.mkdirs();  
		
		String filePath = path  + File.separator + fileName ;
		
		file = new File(filePath);
		
		//若存在则删除
		if(file.exists()) file.delete();
		
		file.createNewFile();
		
		ByteArrayInputStream bis = new ByteArrayInputStream(data);
		
		FileOutputStream fos = new FileOutputStream(file);
		
		byte[] buff = new byte[1024];
		
		int len;
		
		while((len = bis.read(buff)) != -1){
			fos.write(buff , 0 , len); 
		}
		
		fos.close();
		
	}
	
}
