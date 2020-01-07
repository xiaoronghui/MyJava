package 设计模式.结构型设计模式.桥接模式;

public class UrgencyMessage extends AbstractMessage{

	public UrgencyMessage(MessageImplementor messageImplementor) {
		super(messageImplementor);
	}

	@Override
	public void send(String msg) {
		System.out.println("正在发送加急消息");
		super.send(msg);
		watch();
	}
	
	public void watch(){
		System.out.println("正在监控加急消息");
	}
	
	

}
