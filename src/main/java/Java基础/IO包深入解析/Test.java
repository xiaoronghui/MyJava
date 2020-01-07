package Java基础.IO包深入解析;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Test {
	
	public static void main(String[] args) throws IOException {
		
		String filePath = PathUtils.getClassFilePath(Test.class) + "控制器模板.txt";
		
		String desktop = PathUtils.getDesktopPath();
		
		File file = new File(filePath);
		
		FileInputStream fis = new FileInputStream(file);
		
		InputStreamReader isr = new InputStreamReader(fis);
		
		BufferedReader br = new BufferedReader(isr);
		
		String temp = null;
		
		String bigClassName = "Manager";
		String littleClassName = "manager";
		
		String bigClassNameMark = "##bigClassName##";
		String littleClassNameMark = "##littleClassName##";
		
		String mapPutMark = "##object2map##";
		
		File outFile = new File(desktop +File.separator + "控制器模板生成文件.txt");
		
		System.out.println(outFile.getAbsolutePath());
		
		//输出文件
		FileOutputStream fos = new FileOutputStream(outFile);
		
		OutputStreamWriter osw  = new OutputStreamWriter(fos);
		
		while((temp = br.readLine()) != null){
			
			//替换首字母大写的类名
			if(temp.contains(bigClassNameMark)){
				temp = temp.replaceAll(bigClassNameMark, bigClassName);
			}
			
			//替换首字母小写的类名
			if(temp.contains(littleClassNameMark)){
				temp = temp.replaceAll(littleClassNameMark, littleClassName);
			}
			
			if(temp.contains(mapPutMark)){
				String tab = temp.substring(0, temp.indexOf(mapPutMark));
				temp = generateReplaceMapPutTxt(tab);
			}
			osw.write(temp);
			osw.write("\n");
		}
		
		br.close();
		osw.close();
	}
   
	/**
	* @function
	* @param tab 缩进部分的空白字符串
	* @author 肖荣辉
	* @date 2018年5月11日
	*/
	private static String generateReplaceMapPutTxt(String tab) {
		
		String txt =  tab +"map.put(\"managerId\", manager.getManagerId());\n"+
							 tab +"map.put(\"name\", manager.getName());\n"+
							 tab +"map.put(\"createMan\", manager.getCreateMan());\n"+
							 tab +"map.put(\"createDate\", manager.getCreateDate());\n"+
							 tab +"map.put(\"updateMan\", manager.getUpdateMan());\n"+
							 tab +"map.put(\"updateDate\", manager.getUpdateDate());\n"+
							 tab + "map.put(\"isDeleted\", manager.getIsDeleted());\n";
		
		return txt;
	}
	
}
