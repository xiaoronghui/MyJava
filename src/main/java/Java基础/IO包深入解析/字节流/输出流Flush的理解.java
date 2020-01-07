package Java基础.IO包深入解析.字节流;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import Java基础.IO包深入解析.PathUtils;

public class 输出流Flush的理解 {
	
	
	/**
	 * 1 . FileOutputStream的 flush()是继承于其父类OutputStream的，但是OutputStream类的flush()什么都没做。
	    
	    2 . 当OutputStream是BufferedOutputStream时，BufferedOutputStream中重写了flush()方法，
	         并在其中调用了flushBuffer()方法以及OutputStream的flush()方法

	     3 . 而在BufferedOutputStream中 缓冲区buffer其实就是一个byte[]，BufferedOutputStream的每一次write
	          其实是将内容写入byte[]，当buffer容量到达上限时，会触发真正的磁盘写入。
	       
	      4 . 那么什么时候才需要调用flush()呢？
     
               close()方法会默认调用flash()方法,当没写close()方法的时候就得手动去调用flush().
               
               当然,close()方法是必须写的,我们基本上不会用到flush()方法.
               
           5.方法write(int b) 为什么不直接把参数换成write(byte b)呢,反正都是最后强转的.
           
              byte表示的范围是-128~127,使用int作为参数也没什么错. 可能是人们习惯了int,才这么设计的
              
	 * 
	 */
	public static void main(String[] args) throws IOException {
		
		//1.创建输出流目标对象
		String filePath = PathUtils.getDesktopPath() + File.separator + "输出流flush方法使用.txt";
		File file = new File( filePath);
		
		//2.创建输出缓冲流
		BufferedOutputStream bos = null;
		
		try {
			
			//根据源码可以得知,缓冲数组默认大小为8192,也可以在构造的时候指定,故意设置小一点,为了验证flush的功能
			bos = new BufferedOutputStream(new FileOutputStream(file),30);
			String word = "这里是测试输出流flush方法的类...这里是测试输出流flush方法的类...这里是测试输出流flush方法的类";
			
			byte[] bytes = word.getBytes();
			
			/**
			 * 看了下源码,这样写其实和不用缓冲输出流是一样的,所以如果要想提高性能,每次写入的字节数组长度要小于缓冲区的长度
			 */
			//bos.write(bytes.getBytes());  //
			
			/*如果不关闭流的话,我们又不使用flush,则会导致有一部分缓冲区的数据没有被写入磁盘,从输出的文件可以看出*/
			for(int i = 0 ; i < bytes.length ; i ++){
				bos.write(bytes, i, 1);
			}
			
			bos.flush();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
//			if(bos != null) bos.close();  //故意不关闭流,为了手动试一下flush
		}
		
	}
	
}
