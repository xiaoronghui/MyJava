package Java基础.IO包深入解析.字节流;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.imageio.ImageIO;

import Java基础.IO包深入解析.PathUtils;

public class ByteArrayInputStream和ByteArrayOutputStream的理解 {
	
	/**
	 * ByteArrayInputStream和ByteArrayOutputStream存在的意义是什么?

		  1) ByteArrayInputStream在使用过程中没有IO操作，它存在的意义是将内存中的一个byte数组，
		     让它可以通过InputStream的API来操作读取，主要是为了方便
		     这两个流的作用在于：用IO流的方式来完成对字节数组的读写。
		
		  2) 什么是内存虚拟文件或者内存映像文件？ 
		       他们是将一块内存虚拟成一个硬盘上的文件，原来该写到硬盘文件上的内容会被写到这个内存中，原来改从一个硬盘文件上读取内容可以改为从内存中直接读取。
		      （如果在程序运行过程中药产生过一些临时文件，就可以使用虚拟文件的方式来实现，不需要访问硬盘，而是直接访问内存）
		       常见的应用：比如，我们的程序需要将一台计算机的屏幕图像通过网络不断地传送到另外的计算机上，为了节省网络带宽，我们需要将一副屏幕图像进行压缩后，
		       在通过网络发送出去。如果没有内存虚拟文件，我们需要将一台计算机的屏幕图像的像素数据写入到硬盘上的临时文件，再以这个文件作为输入流对象去调用那个
		       压缩函数，接着又从压缩函数生成的压缩文件中读取压缩后的数据，在通过网络发送出去，最后删除压缩前后生成的两个临时文件。这个效率非常低。
		       ByteArrayInputStream和ByteArrayOutputStream两个类可以实现类似内存虚拟文件的功能，我们将图像所有的像素数据保存在一个数组中，
		       然后根据数组创建一个ByteArrayInputStream流对象，同时创建一个用于保存压缩结果的ByteArrayOutputyStream流对象，将这两个对象作为参数传递给压缩函数，最后从
		       ByteArrayOutPutStream流对象中返回包含有压缩结果的数组
	 * 
	 */
    public static void main(String[] args) throws IOException {  
        
        String imagePath = PathUtils.getClassFilePath(ByteArrayInputStream和ByteArrayOutputStream的理解.class) + File.separator + "投胎的兄弟.png";
        
        /**
         * 把压缩后的图片发送到别的服务器,这个时候我们没必要保存临时的那个压缩文件,所以我们把压缩好的图片先放到内存中
         * 这里就能体现ByteArrayInputStream和ByteArrayOutputStream的作用
         */
        byte[] byteArray = reduceImg(imagePath, 200, 200,null);  
        
        //发送图片
        send(new ByteArrayInputStream(byteArray));
        
        System.out.println("压缩图片完毕,并已经发送...");  
        
    }  
    
    /**
     *  根据输入流发送图片到桌面上 (模拟发送,其实可以发送到别的网络上)
     */
    public static void send(InputStream is) throws IOException{
    	
    	FileOutputStream fos = new FileOutputStream(new File(PathUtils.getDesktopPath() + File.separator+UUID.randomUUID().toString()+".jpg"));
    	BufferedOutputStream bos = new BufferedOutputStream(fos);
    	
    	BufferedInputStream bis = new BufferedInputStream(is);
    	
    	byte[] buff = new byte[1024];
    	
    	int len ; 
    	
    	while((len = bis.read(buff)) != -1){
    		bos.write(buff , 0 , len); 
    	}
    	
    	bis.close();
    	bos.close();
    	
    }
    
	
    /** 
     * 采用指定宽度、高度或压缩比例 的方式对图片进行压缩 
     * @param imgsrc 源图片地址 
     * @param imgdist 目标图片地址 
     * @param widthdist 压缩后图片宽度（当rate==null时，必传） 
     * @param heightdist 压缩后图片高度（当rate==null时，必传） 
     * @param rate 压缩比例  
     */  
    public static byte[] reduceImg(String imgsrc, int widthdist, int heightdist , Float rate) {  
            
        try {  
        	
            File srcfile = new File(imgsrc);  
            
            // 检查文件是否存在  
            if (!srcfile.exists()) {  
                return null;  
            }  
            // 如果rate不为空说明是按比例压缩  
            if (rate != null && rate > 0) {  
                // 获取文件高度和宽度  
                int[] results = getImgWidth(srcfile);  
                if (results == null || results[0] == 0 || results[1] == 0) {  
                    return null;  
                } else {  
                    widthdist = (int) (results[0] * rate);  
                    heightdist = (int) (results[1] * rate);  
                }  
            }  
            
            // 开始读取文件并进行压缩  
            Image src = javax.imageio.ImageIO.read(srcfile);  
            
            BufferedImage tag = new BufferedImage((int) widthdist , (int) heightdist, BufferedImage.TYPE_INT_RGB); 
  
            tag.getGraphics().drawImage(src.getScaledInstance(widthdist, heightdist,Image.SCALE_SMOOTH), 0, 0, null);
                      
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            
            ImageIO.write(tag , imgsrc.substring(imgsrc.lastIndexOf("." ) + 1) , byteArrayOutputStream);
            
           return  byteArrayOutputStream.toByteArray();
            
  
        } catch (IOException ex) {  
            ex.printStackTrace();  
        }  
        
        return null;
    }  
    
    /** 
     * 获取图片宽度 
     *  
     * @param file 
     *            图片文件 
     * @return 宽度 
     */  
    public static int[] getImgWidth(File file) {  
        InputStream is = null;  
        BufferedImage src = null;  
        int result[] = { 0, 0 };  
        try {  
            is = new FileInputStream(file);  
            src = javax.imageio.ImageIO.read(is);  
            result[0] = src.getWidth(null); // 得到源图宽  
            result[1] = src.getHeight(null); // 得到源图高  
            is.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return result;  
    }  
    
}
