package Java基础.关键字;

public class transient关键字 {
	
	public static transient int count = 0;  //这个变量将不会被序列化
	
	/*我们都知道一个对象只要实现了Serilizable接口，这个对象就可以被序列化，java的这种序列化模式为开发者提供了很多便利，
	
	我们可以不必关系具体序列化的过程，只要这个类实现了Serilizable接口，这个类的所有属性和方法都会自动序列化。

	然而在实际开发过程中，我们常常会遇到这样的问题，这个类的有些属性需要序列化，而其他属性不需要被序列化，
	
	打个比方，如果一个用户有一些敏感信息（如密码，银行卡号等），为了安全起见，
	
	不希望在网络操作（主要涉及到序列化操作，本地序列化缓存也适用）中被传输，这些信息对应的变量就可以加上transient关键字。
	
	换句话说，这个字段的生命周期仅存于调用者的内存中而不会写到磁盘里持久化。*/
	
	public static void main(String[] args) {
		System.out.println(transient关键字.count);
	}
	
}
