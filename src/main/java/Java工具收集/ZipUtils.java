package Java工具收集;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;

/**
* @function zip压缩和解压工具类
* @author 肖荣辉
* @date 2018年4月17日
*/
public class ZipUtils {
	
	private static  Base64 base64 = new Base64();
	
	/**

	* 使用gzip进行压缩
	*/
	public static String gzip(String primStr) throws IOException {
		
		if (primStr == null || primStr.length() == 0)
			return primStr;

		ByteArrayOutputStream out = new ByteArrayOutputStream();
	
		GZIPOutputStream gzip=null;
		
		try {
			gzip = new GZIPOutputStream(out);
			gzip.write(primStr.getBytes("utf-8"));
		} finally {
			if (gzip != null) gzip.close();
		}
		
		return  base64.encodeToString(out.toByteArray());
	}

	/**
	*
	* <p>Description:使用gzip进行解压缩</p>
	* @param compressedStr
	* @return
	 * @throws IOException 
	*/
	public static String ungzip(String compressedStr) throws IOException{
		
		if(StringUtils.isBlank(compressedStr)){
			return compressedStr;
		}

		ByteArrayOutputStream out= new ByteArrayOutputStream();
		ByteArrayInputStream in=null;
		GZIPInputStream ginzip=null;
		byte[] compressed=null;
		
		try {
			
			compressed = base64.decode(compressedStr);
			in = new ByteArrayInputStream(compressed);
			ginzip = new GZIPInputStream(in);
			byte[] buffer = new byte[1024];
			int offset = -1;
			while ((offset = ginzip.read(buffer)) != -1) {
				out.write(buffer, 0, offset);
			}
			
		} finally {
			if (ginzip != null) ginzip.close();
			if (in != null) in.close();
		}
		return  out.toString();
	}

	/**
	* 使用zip进行压缩
	* @param str 压缩前的文本
	* @return 返回压缩后的文本
	 * @throws IOException 
	*/
	public static final String zip(String str) throws IOException {
		
		if (str == null)
			return null;
		
		byte[] compressed;
		
		ByteArrayOutputStream out = null;
		ZipOutputStream zout = null;
		String compressedStr = null;
		
		try {
			out = new ByteArrayOutputStream();
			zout = new ZipOutputStream(out);
			zout.putNextEntry(new ZipEntry("0"));
			zout.write(str.getBytes("utf-8"));
			zout.closeEntry();
			compressed = out.toByteArray();
			compressedStr = base64.encodeToString(compressed);
		} finally {
			if (zout != null) zout.close();
		}
		
		return compressedStr;
	}

	/**
	* 使用zip进行解压缩
	* @param compressed 压缩后的文本
	* @return 解压后的字符串
	 * @throws IOException 
	*/
	public static final String unzip(String compressedStr) throws IOException {
		
		if (StringUtils.isBlank(compressedStr)) {
			return compressedStr;
		}
	
		ByteArrayOutputStream out = null;
		ByteArrayInputStream in = null;
		ZipInputStream zin = null;
		String decompressed = null;
		
		try {
			
			byte[] compressed = base64.decode(compressedStr);
			out = new ByteArrayOutputStream();
			in = new ByteArrayInputStream(compressed);
			zin = new ZipInputStream(in);
			zin.getNextEntry();
			byte[] buffer = new byte[1024];
			int offset = -1;
			
			while ((offset = zin.read(buffer)) != -1) {
				out.write(buffer, 0, offset);
			}
			
			decompressed = out.toString();
			
		}finally {
			if (zin != null) zin.close();
		}
		
		return decompressed;
		
	}
	
}
