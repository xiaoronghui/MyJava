package 设计模式.结构型设计模式.桥接模式;

public class EmailMessageImpement implements MessageImplementor{

	@Override
	public void send(String msg) {
		System.out.println("发送邮件消息 : {" + msg + "}");
	}

}
