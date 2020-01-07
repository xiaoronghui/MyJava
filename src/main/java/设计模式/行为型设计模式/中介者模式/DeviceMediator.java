package 设计模式.行为型设计模式.中介者模式;

//设备中介者
public class DeviceMediator  extends  AbstractMediator {
	
	@Override
	void deviceOpened(Device device) {
		
		//启动一个,打开其它的
		for(Device item : devices){
			if(item.equals(device)) continue;
			item.open();
		}
		
	}

}
