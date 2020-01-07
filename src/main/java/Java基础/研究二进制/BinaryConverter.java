package Java基础.研究二进制;

/**
* @function 进制转化器
* @author 肖荣辉
* @date 2019年3月8日
*/
public class BinaryConverter {
	
	public static void main(String[] args) {
		System.out.println(BinaryConverter.convertIntegerToBinaryString(-2));
		System.out.println(BinaryConverter.convertIntegerToBinaryString(100));
		System.out.println(BinaryConverter.convertDecimalToBinaryString(6.75, 7));
		System.out.println(BinaryConverter.convertDecimalToBinaryString(0.3125, 7));
        System.out.println(BinaryConverter.convertFloatToBinaryString(1.5f));
        System.out.println(BinaryConverter.convertDoubleToBinaryString(1.5));
	}
	
	/**
	* @function 把整数转化为指定位数的二进制
	* @param integer 整数
	* @param digit 位数
	* @author 肖荣辉
	* @date 2019年3月8日
	*/
	public static String convertIntegerToBinaryString(long lon){
		return prefixZeroMakeUpBitcount(Long.toBinaryString(lon));
	}
	
	/**
	* @function 转化10进制小数为二进制小数字符串
	* @param d 十进制小数
	* @param exactDigit 精确位数
	* @author 肖荣辉
	* @date 2019年3月8日
	*/
	public static String convertDecimalToBinaryString(double d , int exactDigit){
		
		//整数部分
		int integer = (int) d;
		
		//小数部分
		double decimal = d - integer;
		
		// 保存小数部分的计算结果
		StringBuilder resultDecimal = new StringBuilder(decimal > 0 ? "." : ".0");
		
		//精确到几位就循环几次
		for(int i = 0 ; decimal > 0 && i < exactDigit ; i ++){
			
			decimal = decimal * 2 ;
			
			boolean flag = decimal >= 1;
			
			resultDecimal.append(flag ? "1" : "0");
			
			decimal = flag ? decimal - 1 : decimal;
			
		}
		
		
		return Integer.toBinaryString(integer) + resultDecimal.toString() ;
	}
	
	/**
	* @function 把单精度浮点数转化为二进制所表示的编码字符串
	* @param f 单精度浮点数
	* @author 肖荣辉
	* @date 2019年3月8日
	*/
	public static String convertFloatToBinaryString(float f){
		//Float.floatToIntBits(f) : 返回单精度浮点数在内存中二进制的表示的编码对应的整数值
		return prefixZeroMakeUpBitcount(Integer.toBinaryString(Float.floatToIntBits(f)));
	}
	
	/**
	* @function 把 双精度浮点数转化为二进制所表示的编码字符串
	* @param d 双精度浮点数
	* @author 肖荣辉
	* @date 2019年3月8日
	*/
	public static String convertDoubleToBinaryString(double d){
		//Double.doubleToLongBits(d) : 返回双精度浮点数在内存中二进制的表示的编码对应的整数值
		return prefixZeroMakeUpBitcount(Long.toBinaryString(Double.doubleToLongBits(d)));
	}
	
	/**
	* @function 前面追加0以补足位数,保证位数总是8的倍数
	* @param binaryString 二进制编码字符串
	* @author 肖荣辉
	* @date 2019年3月8日
	*/
	public static String prefixZeroMakeUpBitcount(String binaryString){
		
		while(binaryString.length()%8 != 0){
			binaryString = "0" + binaryString;
		}
		
		return binaryString;
	}
	
}
