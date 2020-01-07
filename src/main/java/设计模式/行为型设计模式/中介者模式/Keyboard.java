package 设计模式.行为型设计模式.中介者模式;

public class Keyboard implements Device{

	@Override
	public void openWithMediator(AbstractMediator abstractMediator) {
		open();
		abstractMediator.deviceOpened(this);
	}

	@Override
	public void open() {
		System.out.println("键盘已经启动");
	}

}
