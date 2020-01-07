package Java基础.字符串;
import java.util.Arrays;

public class StringBuilder和StringBuffer {
	public static void main(String[] args) {
		/*
		 	StringBuilder(线程不安全,效率高),StringBuffer(线程安全,效率低)
		 	(查看源码)
		 	StringBuilder:
		 	     1) 继承AbstractStringBuilder抽象类,属性char[] value是可以修改的字符数组
		 */ 
		StringBuilder sb=new StringBuilder(); //默认长度为16的字符数组-->查看源码可以得知
		//长度为"abcd".length()+16=20的字符数组,value={"a","b","c","d","\u0000","\u0000",.....}
		StringBuilder sb1=new StringBuilder("abcd");
		for(int i=0;i<20;i++){
			sb1.append(1);
		}
		System.out.println(sb1);
		/*
		 	疑问:
		 	 StringBuilder sb1=new StringBuilder("abcd");构建之后value的长度是20,经过循环append之后,
		 	 长度早就超过了20,为什么不会报错呢?
		 	 解析:
		 	 1)  当超过当前容量的时候,会有这么一个机制  int newCapacity = value.length * 2 + 2; -->新数组的长度,
		 	 value = Arrays.copyOf(value, newCapacity); -->然后以这个长度创建一个新数组,把老数组的值拷贝进新数组,
		 	 然后把新数组的索引赋值给value;
		 	 2)只要超过容量就扩容两倍，产生的对象教少.而字符串用＂＋＂号拼接每次都会产生新字符串对象,
		 	       所以StringBuilder比字符串拼接省空间,也更效率;
		 */
		StringBuilder sb2=new StringBuilder("abcdefghijklmnopqrstuvwxyz");
		sb2.delete(3, 5).delete(3, 5); //从第3个索引开始删除字符一直删到第5个,第5个不善.然后还可以继续删除..
		System.out.println(sb2);
		System.out.println(sb2.reverse()); //反序
	}
}
