package 设计模式.结构型设计模式.桥接模式;

public class AbstractMessage {
	
	MessageImplementor messageImplementor;

	public AbstractMessage(MessageImplementor messageImplementor) {
		this.messageImplementor = messageImplementor;
	}
	
	public void send(String msg){
		messageImplementor.send(msg);
	}
	
}
