package Java基础.文件操作;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.charset.Charset;

public class 获取文件路径的一些方式 {
	
	public static void main(String[] args) {
	    
	    //获取本项目内文件的路径
	   String filePath = getCurrentProjectFilePath("/config/将夜.txt");
	   
	   System.out.println(filePath);
	    
	    /*
	     方式2:
	     	当上传图片的时候,我想在Tomcat的根目录下创建一个临时文件夹,把图片传到这个临时文件夹里面去,
	     	然后一个临时文件夹进行操作,把文件再传到文件服务器中去.
	     	从而,我们得想办法拿到Tomcat的根路径
	     	String workPath = request.getSession().getServletContext().getRealPath("/");// 服务器的路径
            String storeTempDirPath = new StringBuilder(workPath).append("temp").append(File.separator).toString();// 保存图片的临时路径
	     */
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
		
		//路径名中可能有中文,需要解码,不然会有问题
		String path = null;
		try {
			path = url == null ? null : java.net.URLDecoder.decode( url.getPath() ,Charset.defaultCharset().name());
		} catch (UnsupportedEncodingException e) {
			System.out.println(Charset.defaultCharset().name() + "编码未知!");
		}
		
		return path;
		
	}
	
	
	
}
