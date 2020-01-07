package 设计模式.行为型设计模式.中介者模式;

public class Computer implements Device{

	@Override
	public void openWithMediator(AbstractMediator abstractMediator) {
		open();
		abstractMediator.deviceOpened(this);
	}

	@Override
	public void open() {
		System.out.println("电脑已经启动");
	}

}
