package 设计模式.行为型设计模式.中介者模式;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//抽象中介者
public abstract class AbstractMediator {
	
	//中介者维护的设备
	protected List<Device> devices = new ArrayList<>();
	
	public AbstractMediator() {
		
	}

	public AbstractMediator(Device... abstractDevices) {
		devices = Arrays.asList(abstractDevices);
	}
	
	public void addDevice(Device abstractDevice){
		devices.add(abstractDevice);
	}
	
	//如果每个设备启动的之后之后想要关联的设备都不一样的话话,里面的业务逻辑也不一样的话
	//则下面的给每个设备启动定义一个方法,在每个方法里面来写不同的业务逻辑.而现在是所有的都一样,所以只写一个方法即可.
	
	//设备已经启动
	abstract void deviceOpened(Device device);
	
}
