package Java基础.IO包深入解析.字节流;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PushbackInputStream;

import Java基础.IO包深入解析.PathUtils;


/**
 *   PushbakInputStream类在初始化的时候声明的一个1字节的数组buf,当然也可以在构造的时候指定长度.pos初始的时候等于buf.length,
 *  当我们往这个数组里面unread(b[] b) 的时候,如果b比buf小,则b数组会被拷贝到buf的尾部,每次读取read(c[] c) 总会
 *  先把buf中尾部的那块内容先拷贝c的前面.然后pos恢复为buf.length. 说白了,就是定义一个缓冲区供你存放临时的字节数组,
 *  再读取的时候每次把这个字节带上.
 * 
 *   应用场景 :
 *   
       可以试探性地读取一个字节，看是否符合要求，然后再回退回去一个字节后，再读取字节。 (这种场合还没有)
       
       我的想法  : 如果我想在不关闭流的情况下返回读取某个文件,我可以把缓冲区设置为文件大小,读完我全部弹回去,然后继续读.
                         (其实和用ByteArrayOutputStream输出到内存中做的效果是一样的,该类还是用于试探性读取是最好的场合,
                         这样会比全部读取再去判断的效率更高)
         

 */
public class PushbakInputStream的理解 {

	public static void main(String[] args) throws IOException {
		
		
		//创建输入流源对象
		String filePath = PathUtils.getClassFilePath(PushbakInputStream的理解.class) + File.separator + "说明";
		File file = new File(filePath);
		PushbackInputStream pis = null;
		
		try {
			
			//pis默认的buf默认为1个字节,给它设置个1024
			pis = new PushbackInputStream(new FileInputStream(file) , 1024);
			
			InputStreamReader isr = new InputStreamReader(pis);
			
			BufferedReader br = new BufferedReader(isr);
			
			String temp;
			
			pis.unread("=".getBytes());
			
			while((temp = br.readLine()) != null){
				System.out.println(temp);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			if(pis != null) pis.close();
		}
		
	}
	
}
