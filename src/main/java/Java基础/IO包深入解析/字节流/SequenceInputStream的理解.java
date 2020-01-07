package Java基础.IO包深入解析.字节流;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;

import Java基础.IO包深入解析.PathUtils;

public class SequenceInputStream的理解 {
	
	public static void main(String[] args) throws IOException {
		
		String currentDirPath  = PathUtils.getClassFilePath(SequenceInputStream的理解.class);
		
		//创建输入流源对象
		String filePath1 = currentDirPath +File.separator +  "恶魔法则";
		String filePath2 = currentDirPath +File.separator +  "将夜";
		String filePath3 =  currentDirPath +File.separator +  "恶魔将夜(合并文件)";
		
		FileInputStream fis1 = new FileInputStream(new File(filePath1));
		FileInputStream fis2 = new FileInputStream(new File(filePath2));
		
		Enumeration<FileInputStream> enumeration = Collections.enumeration(Arrays.asList(fis1,fis2));
		
		SequenceInputStream sis = new SequenceInputStream(enumeration);
		
		byte[] buff =new byte[1024];
		int len ;
		
		
		File file3 = new File(filePath3);
		
		FileOutputStream fos = new FileOutputStream(file3);
		
		while ((len = sis.read(buff)) != -1) {
			fos.write(buff, 0, len);
		}
		
		sis.close();
		fos.close();
		
	}
	
}
