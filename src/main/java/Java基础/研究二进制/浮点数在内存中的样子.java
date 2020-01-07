package Java基础.研究二进制;

public class 浮点数在内存中的样子 {

	public static void main(String[] args) {
		
		System.out.println(BinaryConverter.convertDecimalToBinaryString(6.75, 7));
		System.out.println(BinaryConverter.convertDecimalToBinaryString(0.3125, 7));
        System.out.println(BinaryConverter.convertFloatToBinaryString(1.5f));
	}
	
	
	
}
