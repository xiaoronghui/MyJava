package Java基础.IO包深入解析;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class File类 {
		
	public static void main(String[] args) throws IOException {
		
		String filePath = PathUtils.getCurrentProjectFilePath("/config/将夜.txt");
		
		//File的实例代表一个文件或文件夹
		File file = new File(filePath);
		
		System.out.println("获取文件绝对路径 : " + file.getAbsolutePath());
		System.out.println("判断文件是否存在 : " + file.exists());
		System.out.println("是否是文件类型 : " + file.isFile());
		System.out.println("获取文件名 : " + file.getName());
		System.out.println("是否是可执行文件 : " + file.canExecute());
		System.out.println("是否可以写入 : " + file.canWrite());
		System.out.println("是否可读 : " + file.canRead());
		System.out.println("最后修改时间 : " + String.format("%1$tF %1$tT", new Date(file.lastModified()))); //new Date(file.lastModified())
		System.out.println("判断文件是否是一个文件夹 : " + file.isDirectory());
		System.out.println("获取父级文件名称 : " + file.getParentFile().getName());
		System.out.println("获取子文件数组 : " + file.listFiles());
		
		String curretClassFilePath = PathUtils.getClassFilePath(File类.class);
		
		System.out.println(curretClassFilePath);
		
		File dFile = new File(curretClassFilePath);
		
		System.out.println("目录文件是否存在 : " + dFile.exists());
		System.out.println("目录文件绝对路径 : " + dFile.getAbsolutePath());
		
		File cFile  = new File(dFile.getAbsolutePath() + File.separator + "新建文档.txt");
		
		System.out.println(dFile.getAbsolutePath() + File.separator + "新建文档.txt");
		
		System.out.println("新建文档 (若已经存在,则返回false) : " + cFile.createNewFile());
		System.out.println("删除当前新建文档 : " + cFile.delete());
		
		File cdFile  = new File(dFile.getAbsolutePath() + File.separator + "新建文件夹");
		
		System.out.println("新建文件夹 : " + cdFile.mkdir());
		System.out.println("删除当前新建文件夹 : " + cdFile.delete());
		
		File cdmFile  = new File(dFile.getAbsolutePath() + File.separator + "水果" + File.separator + "红色水果" + File.separator);
		
		System.out.println("创建此文件夹的父级所有目录,包括当前文件夹 : " + cdmFile.mkdirs());
		
		System.out.println("在上面的目录下创建一个文件 : " + new File(cdmFile.getAbsolutePath() + File.separator + "苹果.txt").createNewFile());
		
		new File(dFile.getAbsolutePath() + File.separator + "水果" + File.separator + "干果" + File.separator + "花生" + File.separator + "瓜子").mkdirs();
		
		File sgFile = new File(dFile.getAbsolutePath() + File.separator + "水果");
		
		//树状打印文件名
		showTreeFileNames(sgFile , 0);
		
		//删除整个文件及子文件和目录
		deleteFolder(sgFile);
		
	}
	
	//树状打印file文件和子文件的所有名称
	public static void showTreeFileNames(File file , int size){
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0 ; i < size ; i ++){
			sb.append("-");
		}
		
		System.out.println(sb.toString() + file.getName());
		
		if(!file.isDirectory()) return;
		
		File[] fileArray = file.listFiles();
		
		for(int i = 0 ; i < fileArray.length ; i ++){
			showTreeFileNames(fileArray[i], size + 1);
		}
		
	}
	
   /**
	 *@function 删除整个文件及子文件和目录
	 */
   public static boolean deleteFolder(File file){  
	    
	    if(!file.exists()){  
	        return false;  
	    }
	    
	    if(file.isFile()){  
	        file.delete();  
	        return true;  
	    }
	    
	    File[] files=file.listFiles();  
        for(int i=0;i <files.length;i++){  
            deleteFolder(files[i]);  
        }
        
        file.delete();  
        
        return true;  
	}
	
}
