package 设计模式.结构型设计模式.桥接模式;

public class CommonMessage extends AbstractMessage{

	public CommonMessage(MessageImplementor messageImplementor) {
		super(messageImplementor);
	}

	@Override
	public void send(String msg) {
		System.out.println("正在发送普通消息");
		super.send(msg);
	}

}
