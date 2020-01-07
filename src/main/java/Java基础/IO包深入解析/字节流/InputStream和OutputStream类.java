package Java基础.IO包深入解析.字节流;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import Java基础.IO包深入解析.PathUtils;

public class InputStream和OutputStream类 {
	
	//实现一个图片的拷贝
	public static void main(String[] args) throws IOException {
		
		//创建输入流源对象
		String imagePath = PathUtils.getClassFilePath(InputStream和OutputStream类.class) + File.separator + "投胎的兄弟.png";
		File file = new File(imagePath);
		
		//1.创建输出流目标对象
		String imagePathCopy = PathUtils.getDesktopPath() + File.separator + "投胎的兄弟(OutputStream的应用).png";
		File fileCopy = new File(imagePathCopy);
		
		InputStream is = null;
		OutputStream os = null;
		
		try {
			
			//2.创建io流对象
			is = new FileInputStream(file);
			os = new FileOutputStream(fileCopy);
			
			//3.具体的IO操作
			byte[] buff = new byte[1024];
			
			//如果是-1则表示读到了文件尾
			while(is.read(buff) != -1){
				os.write(buff);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			//4.关闭流
			if(is != null) is.close();
			if(os != null) os.close();
		}
		
	}
	
	
}
