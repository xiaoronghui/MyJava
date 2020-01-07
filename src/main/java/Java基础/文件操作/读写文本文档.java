package Java基础.文件操作;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;

public class 读写文本文档 {
	public static void main(String[] args)  throws Exception{
		读文本文档测试();
		//写文本文档测试();
	}
	
	public static void 写文本文档测试() throws Exception{
		/*
		 	一行一行的写文本文档该用什么写呢?
		 	BufferedWriter每次可以写入任意的字符串
		 */
		File file=new File("F:/workSpace/Java300/src/config/copy.txt");
		if(file.exists())file.createNewFile();
		Writer writer=new FileWriter(file);
		BufferedWriter bw=new BufferedWriter(writer);
		Reader reader=new FileReader("F:/workSpace/Java300/src/config/将夜.txt");
		BufferedReader br=new  BufferedReader(reader);
		String str;
		while((str=br.readLine())!=null){ //边读边写
			bw.write(str+"\n");
		}
		reader.close();
		bw.close();
	}
	
	public static void 读文本文档测试(){
		try {
				/*
			 	要求:
			 	   在当前工程的src目录下有一个名为config的包,包下有一个"将夜.txt"的文件,
			 	   要求读取出来,并打印;
			 	 分析:
			 	    1)　我如何得到当前工程下将夜所在的路径?  　
			 	    2)　啊，好难！我的文件和流的知识果然学的一塌糊涂!
			 	    3)　我先使用个绝对路径创建这个文件好了
			 	    4)　可是如何读取啊？
			 	    5)   读取这个文件得获取这个文件的输入流,然后才可以读取;
			 	          File file=new File("F:/workSpace/Java300/src/config/将夜.txt");
			 	    6)   如何获取这个文件的输入流?
			 	          FileInputStream fileInputStream=new FileInputStream(file);
			 	          也可以直接写成:
			 	          FileInputStream fileInputStream=new FileInputStream("F:/workSpace/Java300/src/config/将夜.txt");
			 	    7) 如何去读取文件呢?
			 	         fileInputStream.read(buf); //该方法每读一次会把所读取的字节放进字节数组buf中
			 	         我们可以把字节数组构建成一个字符串.
			 	         当读到末尾的时候返回-1
			 	         从而我们可以使用while来循环的读取,直到末尾
			 	     8) 读取一个文档有以下三种做法
			 */
			File file=new File("F:/workSpace/Java300/src/config/将夜.txt");
			System.out.println(file.length()); //文件所占用的字节数
			//方法1: 获取文件的输入流,其实我们还可以直接写成
			FileInputStream fileInputStream=new FileInputStream(file);
			byte[] buf2=new  byte[64]; //构建数组的时候,长度要求是整型
			byte[] buf=new  byte[(int)file.length()+buf2.length]; //构建数组的时候,长度要求是整型.防止最后一次拷贝数组的时候超出界限.多加一个长度
			//第一种做法:
			/*while(fileInputStream.read(buf2)!=-1){
				 System.out.println(new String(buf2));
			 }*/
			//第二种做法
			/*int index=buf2.length,count=0;
			System.out.println("buf.length:"+buf.length);
			while(fileInputStream.read(buf2)!=-1){
				System.arraycopy(buf2, 0, buf,index*count, buf2.length);
				count++;
			}
			System.out.println(new  String(buf));*/
			//fileInputStream.close();
			//第三种做法
			/*char[] charBuf=new char[20]; //每次读20个字;
			Reader reader=new FileReader(file);
			while(reader.read(charBuf)!=-1){
				System.out.println(new String(charBuf));
			}*/
			/*
			 * 1) 第一种做法不好,我的字节数组是64byte,没读一次创建一个字符串,很有可能64个字符中最后的那个字节是
			 *  半个字.这样打印出来就有错误的字了.如上面的"吐"字就错掉了
			 * 2) 我想用一个大大的数组把每一次读的东西先保存起来,然后再一次性转为字符串,最后打印出来
			 * 3) 第二种做法也不好.如果一个文本有几个G,你总不可能new几个G的字节数组.内存不够用啊.
			 *     那还有没有更好的做法呢?
			 *     能不能按字符数组读,这样最起码能保证不会读半个字.
			 *     FileReader就是按字符来读取文件的.该类无法一行一行的读取
			 *  
			 * 4) 第三种做法读文本文件的时候比用FileInputStream有优势,最起码不会读半个字,但是读取效率还是有点慢,而且读取出来的东西
			 *     不是一行一行的,能不能按行读取呢?
			 *     使用包装类BufferedReader.BufferedReader是reader的子类.
			 *     Reader reader=new FileReader(file);
					BufferedReader br=new  BufferedReader(reader); //这就是包装
			 *     br.readLine()读取一行的字符,这样效率又快,而且再也不会读到半个字了.
			 *  5) 如果有人就是不换行,10个G的文档都写成一行的话,那不是很耗内存吗?
			 *      查看下readLine的实现方式.
			 *      查看了一下,源码好多陌生的写法和关键字不懂.但还是看懂一点.
			 *      如果你非得不换行,那也没办法.的确是耗内存.但谁吃饱了撑着这么干.
			 */
			Reader reader=new FileReader(file);
			BufferedReader br=new  BufferedReader(reader);
			String str;
			while((str=br.readLine())!=null){
				System.out.println(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
