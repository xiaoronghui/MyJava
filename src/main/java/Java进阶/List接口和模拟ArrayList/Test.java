package Java进阶.List接口和模拟ArrayList;

public class Test {
	public static void main(String[] args) {
		//hashCode是jdk根据对象的地址或者字符串或者数字算出来的int类型的数值
		/**
		 * 如果是字符串对象,则按照字符串来计算哈希吗
		 * 如果其他类型的对象,则按内存地址来计算哈希吗
		 * 如果是数字,则按数值来计算哈希码
		 */
		String a="abc";
		String b=new String("abc");
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
		Object c=new Object();
		Object d=new Object();
		System.out.println(c.hashCode());
		System.out.println(d.hashCode());
		System.out.println(a==b);
		System.out.println(a.equals(b));
		Integer e=3;
		Integer f=4345;
		Double g=3.23;
		System.out.println(e.hashCode());  //整型的hashcode就是自己本身
		System.out.println(f.hashCode());
		System.out.println(g.hashCode()); //浮点型哈希码算法不知道什么样子的
	}
}
