package Java基础.文件操作;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.Enumeration;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.Set;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

public class 读取属性文件 {
	
	public static void main(String[] args) {
		/*
		 	目的:读取config目录下的application.properties文件
		 	properties.load(reader);读取一个文件需要一个输入流
		 */
		/*String projectPath=System.getProperty("user.dir");//工程所在路径
	    String filePath=projectPath+File.separator+"src"+File.separator+"config"+File.separator+"application.properties";
	    System.out.println("-----正常的读取方式----"); 
	    loadPropertiesFile(filePath); //
	    System.out.println("-----spring的读取方式----"); 
	    springLoadPropertiesFile("config/application.properties");
	    System.out.println("-----修改属性文件----"); 
	    updatePropertiesFile(filePath);
	    loadPropertiesFile(filePath); */
		readPropertiesFile();
	    
	}
	
	//正常的读属性文件的方式
	public static void loadPropertiesFile(String path){
		try {
			Reader reader=new FileReader(path); //任何一个输入流都可以
		    Properties properties=new Properties();
			properties.load(reader); //已经读取了属性文件
			//遍历该属性文件并打印
			Set<Entry<Object,Object>> sets=properties.entrySet();
			//Entry是Map接口内的内部接口.HashMap中每一个元素都继承了这个接口.从而Entry指向的是Map中的每一个元素
			for(Entry<Object,Object> e :sets){
				System.out.println(e.getKey()+"="+e.getValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//spring中读属性文件的方式
	public static void springLoadPropertiesFile(String path){
		try {
		    Properties properties=PropertiesLoaderUtils.loadProperties(new ClassPathResource(path));
			//遍历该属性文件并打印
			Set<Entry<Object,Object>> sets=properties.entrySet();
			//Entry是Map接口内的内部接口.HashMap中每一个元素都继承了这个接口.从而Entry指向的是Map中的每一个元素
			for(Entry<Object,Object> e :sets){
				System.out.println(e.getKey()+"="+e.getValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//修改属性文件
	public static void updatePropertiesFile(String path){
		try {
			Reader reader=new FileReader(path); //任何一个输入流都可以
		    Properties properties=new Properties();
			properties.load(reader); //已经读取了属性文件
			reader.close();
			//Entry是Map接口内的内部接口.HashMap中每一个元素都继承了这个接口.从而Entry指向的是Map中的每一个元素
			properties.setProperty("username", "fuckyouwc");  //先在对象中修改
			Set<Entry<Object,Object>> sets=properties.entrySet();
			FileWriter fw=new FileWriter(path);
			for(Entry<Object,Object> e :sets){
				 fw.write("\r\n"+e.getKey()+"="+e.getValue()); //逐个键值对重新写回到文件中去
			}
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//使用JDK的工具类获取属性值
	public static void readPropertiesFile(){
		
		ResourceBundle resourceBundle = PropertyResourceBundle.getBundle("config/application");
		
		Enumeration<String> enumeration = resourceBundle.getKeys();
		
		while(enumeration.hasMoreElements()){
			String key = enumeration.nextElement();
			System.out.println(key + " = " + resourceBundle.getString(key));
		}
		
	}
	
	
}
