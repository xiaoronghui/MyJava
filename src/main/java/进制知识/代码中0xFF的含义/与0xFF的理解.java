package 进制知识.代码中0xFF的含义;

/**
 * 
 * 0xff的作用有两种
 * 1.一种是为了截取低8位
 * 2.一种是为了获取到无符号数
* @author 肖荣辉
* @date 2019年8月12日
*/
public class 与0xFF的理解 {
	
	public static void main(String[] args) {
		
		//=====================验证byte转int的时候高位会补一堆的1start==========================
		//整型转byte取低8位
		byte b = -127;
		
		//-127的补码是10000001 , 强转后高位补了一堆的1 , 11111111111111111111111110000001
		System.out.println(Integer.toBinaryString((int)b));
		
		byte b1 = -1;
		
		//-1的补码是11111111 , 高位补了一堆的1 , 11111111111111111111111111111111
		System.out.println(Integer.toBinaryString((int)b1));
		//=====================验证byte转int的时候高位会补一堆的1end==========================
		
	   //=====================0xFF用于截取低8位=========================
		int a =  -1;
		
		//由此可以看出,计算机中保存的二进制是补码形式
		System.out.println(Integer.toBinaryString(a));
		
		//int转字节数组
		byte[] bytes = int2bytes(a);
		
		//字节数组转回int
		System.out.println(byteArrayToInt(bytes));
		
		System.out.println(bytes2HexString(bytes));
		
		//===================用于转无符号数===========================
		System.out.println(bytes2UnsignedInt(bytes)); //32个1表示的无符号数就是4294967295
		
	}
	
	/**
	* @function 获取int类型的无符号数
	* 原理 : 
	* 	 无符号出现问题只有在最高位为1的时候，最高位在有符号数中表示正负号，直接转换会产生负数。如果使得原本的无符号数扩大，
	* 	 最高位不再表示正负标记符，问题也就迎刃而解了。
	* 
	*   "|" 是或运算
	* @param bytes
	* @author 肖荣辉
	* @date 2019年8月12日
	*/
	public static long bytes2UnsignedInt(byte[] bytes) {
       
		if (null == bytes || bytes.length == 0) return 0;
		
		//字节码向long类型转,则在前面加上32个0 , 原来的最高位符号位变为0了.
        return (long)(bytes[3] & 0x000000FF) << 24  | (bytes[2] & 0x000000FF) << 16  | (bytes[1] & 0x000000FF) << 8  | bytes[0] & 0x000000FF;
    }
	
	/**
	* @function 字节数组转十六进制字符串 (由于byte转int在高24位字节会自动补0,此处0xFF用来截取低8位)
	* @param  bytes
	* @author 肖荣辉
	* @date 2019年8月12日
	*/
	public static String bytes2HexString(byte[] bytes) {
		
		String ret = "";
		
		//遍历每一个字节,-1是32个1
		for (int i = 0; i < bytes.length; i++) {
			
			//Integer.toHexString的参数是一个int,byte字节会自动转化为int,高位会补24位的1,所以这里依然是起到截取作用
			String hex = Integer.toHexString(bytes[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			ret += hex.toUpperCase();
		}
		
		return ret;
	}
	
	/**
	* @function 整型转字节数组  (此处0xFF用来截取低8位)
	* @param a
	* @author 肖荣辉
	* @date 2019年8月12日
	*/
	public static byte[] int2bytes(int a){
		
		//整型占用4个字节
		byte[] bytes = new byte[4];
		
		//最高8位放到数组第一个元素中,把变量a的最高位移动到低8位,然后截取这8位,下面的以此类推
		bytes[0] = (byte)(a >> 24 & 0xFF) ;
		bytes[1] = (byte)(a >> 16 & 0xFF) ;
		bytes[2] = (byte)(a >> 8  & 0xFF) ;
		bytes[3] = (byte)(a  & 0xFF) ;
		
		return bytes;
		
	}
	
	/**
	* @function byte[]转int (此处也是截取后8位,然后左移回原来的位置)
	* @param bytes
	* @author 肖荣辉
	* @date 2019年8月12日
	*/
	public static int byteArrayToInt(byte[] bytes) {  
	 
		int value = 0;  
		
		//移动到最高位上去
		value += (bytes[0] & 0x000000FF) << 24;
		value += (bytes[1] & 0x000000FF) << 16;
		value += (bytes[2] & 0x000000FF) << 8;
		value += (bytes[3] & 0x000000FF);

	    return value;  
	}  

}
