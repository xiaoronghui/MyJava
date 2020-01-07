package 设计模式.行为型设计模式.中介者模式;

//设备
public  interface Device {
		
		//启动之后,想关联的设备完全交给中介者去完成
		void openWithMediator(AbstractMediator abstractMediator);
		
		void open();
}
