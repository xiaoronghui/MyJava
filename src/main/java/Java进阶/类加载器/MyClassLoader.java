package Java进阶.类加载器;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class MyClassLoader extends ClassLoader {
	
	private String classDir;

	//覆盖这个方法
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		try {
			String filePath=classDir+File.separator+name+".class";
			File file=new File(filePath);
			FileInputStream fis=new FileInputStream(file);
			byte[] buff=new byte[(int) file.length()];
			fis.read(buff);
			fis.close();
			return defineClass(buff, 0, buff.length);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.findClass(name);
	}
	
	public MyClassLoader(){
		
	}
	public MyClassLoader(String classDir){
		this.classDir=classDir;
	}
}
