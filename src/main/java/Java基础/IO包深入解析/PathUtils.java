package Java基础.IO包深入解析;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.charset.Charset;

import javax.swing.filechooser.FileSystemView;

/**
 *  路径工具类
 */
public class PathUtils {
	
	/**
	 * 路径名中可能有中文,需要解码,不然会有问题
	 * @param path
	 * @return 解码后的路径
	 */
	private static String decodePath(String path){
		try {
			return path == null ? null : java.net.URLDecoder.decode( path ,Charset.defaultCharset().name());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @param filePath  若最前面带有"/",则从工程根目录开始获取路径,若是没有,则表示获取同级目录
	 * @return 文件绝对路径
	 * @throws UnsupportedEncodingException 
	 */
	public static String getCurrentProjectFilePath(String filePath)  {
	
		URL url = Object.class.getResource(filePath);
		
		if(url == null){
			return null;
		}
		
		return url == null ? null : decodePath(url.getPath());
		
	}
	
	/**
	 * 获取class文件所在的文件路径
	 */
	public static String getClassFilePath(Class<?> clazz){
		
		URL url = clazz.getResource("");
		
		return url == null ? null : decodePath(url.getPath());
	}
	
	/**
	 *  获取桌面路径
	 */
	public static String getDesktopPath(){
		return FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath();
	}
	
}
