package Java进阶.类加载器;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
/**
 * 使用类加载器来读取文件流
 * 类加载器:
 *    就是把classpath路径下的文件加载进内存的类.
 *    在一个线程中,某个里被使用的时候,该类就会被加载到内存的中,这个加载就是类加载器完成的.
 * @author ronghui.xiao
 * @date 2015-5-3
 */
public class 类加载器读取文件 {
	public static void main(String[] args) {
		try {
			//比如我要获取文件1输入流,通常我是这么干的
			File file=new File("F:/workSpace/Java300/张孝祥java加强/类加载器/文件1.txt");
			//类加载器:就是加载class文件的类 ,Class的实例对象就可以得到类加载器
			ClassLoader classLoader=类加载器读取文件.class.getClassLoader();   //这种形式的只能从加载当前目录下的,前面不允许加斜杠"/"
			//类加载器既然能加载class,那么也可以加载其他的文件.这里是从编译目录去找的,当前工程的编译目录是Java300/bin
		   // InputStream is=classLoader.getResourceAsStream("类加载器/文件1.txt");
			//从class对象中直接getResourceAsStream是从当前目录中开始查找.
			//InputStream is=类加载器的理解.class.getResourceAsStream("文件1.txt");
		    //如果前面加了反斜杠"/"的话,反斜杠就代表编译目录,如果写了的话就必须把路径写全了
		   // InputStream is=类加载器的理解.class.getResourceAsStream("/类加载器/文件1.txt");
		    //读取下一级目录
		    //InputStream is=类加载器读取文件.class.getResourceAsStream("/类加载器/下一级/文件2.txt");  //这种形式的只能加载编译目录下的,必须加斜杠
		    InputStream is = classLoader.getResourceAsStream("类加载器/下一级/文件2.txt");  //这种形式的只能加载编译目录下的,必须加斜杠
			//注意: 类加载器只能加载classpath下的文件,classpath通常是编译输出目录
			//点击工程-->属性-->Java build path-->default output folder 就是classpath
			byte[] buff=new byte[1024];
			while(is.read(buff)!=-1){
				System.out.println(new  String(buff));
			}
			is.close();
			
			/**
			 * 类加载器仅仅对类的只加载一次,从而加载属性文件也是加载一次.除非main方法执行完,内存释放.才会重新读取
			 * 在某些时候(比如启动的游戏,比如web应用等等)
			 * main方法不会执行完,比如内存就一直不释放
			 * 如果我们在这个main方法中用类加载器加载了属性文件,那么只要这个main方法不执行完,无论你怎么改配置
			 * 文件也不会读取最新的文件信息.那该怎么办呢?
			 * 如下:
			 */
			String path = classLoader.getResource("类加载器/下一级/abc.txt").getPath(); //中文会乱码
			path = java.net.URLDecoder.decode(path,"utf-8");  //
			System.out.println(path);
			FileInputStream fis = new FileInputStream(new File(path));
			while(fis.read(buff)!=-1){
				System.out.println(new String(buff));
			}
			fis.close();
			/**
			 * 注:
			 *   ClassLoader的getResource方法使用了utf-8对路径信息进行了编码，当路径中存在中文和空格时，他会对这些字符进行转换，这样，得到的往往不是我们想要的真实路径，在此，调用了URLDecoder的decode方法进行解码，以便得到原始的中文及空格路径 ；
			            例如:结果是file:/C:/Documents and Settings/庄晓毅  
                 /Local Settings/Temp/temp0.jar!/db/dmozdata.mdb  
			           而我们期望是 C:/Documents andsettigsd sdfsdfsdf sdfsdf sdfsd 等等
			          这里我们只要在获取到的例如: String configPath = this.getClass().getClassLoader().getResource("allowPath.xml").getFile();
			         把返回前decode下就可以了. 用utf-8编码. 
			 * 
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
