package Java基础.IO包深入解析.字节流;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import Java基础.IO包深入解析.PathUtils;

public class BufferedInputStream的理解 {

	
	/*
	 * 通过源码可以看到，如果用read()方法读取一个文件，每读取一个字节就要访问一次硬盘，这种读取的方式效率是很低的。
	 * 
	 * 该类在初始化的时候会创建一个8kb的数组,每次读取文件的时候会一次性读取8kb的数据到数组里面,后面的read(byte[] buff) 都是
	 * 
	 * 从这个缓冲区读取的.有个属性count用来记录缓冲区中还剩下多少个字节没有读完,如果全部读完,则会再访问下磁盘,再读取8kb出来.
	 * 
	 * 注 :
	 * 
	 *    其实FileInputStream的read(byte[] buff)也可以任意设置缓冲区的大小,做到和BufferedInputStream一样的效果,如果buff设置的比
	 *    
	 *    8kb大,效率反而会更高. 从而BufferedInputStream仅仅是提供了一个更为方便的包装类而已,效率未必更高更好.
	 * 
	 * */
	public static void main(String[] args) {
		
		//创建输入流源对象
		String imagePath = PathUtils.getClassFilePath(BufferedInputStream的理解.class) + File.separator + "投胎的兄弟.png";
		File file = new File(imagePath);
				
		BufferedInputStream bis = null;
		
		//1.创建输出流目标对象
		String imagePathCopy = PathUtils.getDesktopPath() + File.separator + "投胎的兄弟(缓冲流的应用).png";
		File fileCopy = new File(imagePathCopy);
		
		BufferedOutputStream bos = null;
		
		try {
			
			bis = new BufferedInputStream(new FileInputStream(file));
			bos = new BufferedOutputStream(new FileOutputStream(fileCopy));
			
			byte[] buff= new byte[1024];
			
			int len;
			
			while((len = bis.read(buff)) != -1){
				bos.write(buff, 0, len);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
