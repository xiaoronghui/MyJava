package 设计模式.结构型设计模式.桥接模式;

public class Test {
	
	public static void main(String[] args) {
		
		//本来一个实现类就可以搞定的东西,现在拆成了两份new UrgencyMessage是抽象部分,new EmailMessageImpement()是实现部分,他们的组合结构就是桥接模式
		AbstractMessage message = new UrgencyMessage(new EmailMessageImpement());
		
		message.send("你好呀");
		
		message = new CommonMessage(new MobileMessageImpement());
		
		message.send("你在干嘛");
		
	}
}
