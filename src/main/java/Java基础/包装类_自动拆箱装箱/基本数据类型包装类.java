package Java基础.包装类_自动拆箱装箱;

public class 基本数据类型包装类 {
	public static void main(String[] args) {
		//Integer: int的包装类
		Integer i=new Integer(3);
		System.out.println("整型能表示的最大值:"+Integer.MAX_VALUE);
		System.out.println("整型能表示的最小值:"+Integer.MIN_VALUE);
		System.out.println(Integer.toHexString(10)); //转化为16进制
		System.out.println(Integer.parseInt("20")); //把字符串转化为整型数据
		//Character: char的包装类
		Character c=new Character('a');
		System.out.println(c.charValue()); //返回该字符
		System.out.println(c);
		System.out.println(Character.isLetter('$')); //查看传入的字符是否为字符
		//还有Long,Short,Float,Double,Byte,Boolean等.
		
		
	}
}	
