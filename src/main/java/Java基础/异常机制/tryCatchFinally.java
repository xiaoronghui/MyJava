package Java基础.异常机制;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class tryCatchFinally {
	public static void main(String[] args) {
		/*
		 	try--catch--finally
		 	finally只的是在catch处理异常的过程中依然出现了异常,然而你必须完成某件事,那么就在finally中处理
		 	比如:
		 		比如我们使用i/o流的时候,关闭流是必须执行的,从而我们可以放到finally语句块中.
		     finally通常用来关闭已经打开的系统资源.流就是这种系统资源;
		    使用的原因:
		       有可能出现的异常都没有被catch捕获到.从而我们把这件必须要做的事放在finally中.
		 */
		String proPath=System.getProperty("user.dir");
		String textPath=proPath+File.separator+"src"+File.separator+"config"+File.separator+"将夜1.txt";
		Reader reader=null;
		try {
			reader=new FileReader(textPath);
			int k=reader.read();
		} catch (FileNotFoundException e) { //可能会出现文件不存在的异常
			e.printStackTrace();
		} catch (IOException e) { //可能会出现一些其它的异常
			e.printStackTrace();
		}finally{
			try {
				if(reader!=null){
					reader.close();  //不管怎么样,我都要把流给关闭.就怕出现的异常都没有捕获到,从而放到finally中
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
