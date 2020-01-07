package 设计模式.行为型设计模式.命令模式;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

//产品经理
public class ProductManager {
	
	//待处理的命令
	private List<Command> commands = new ArrayList<>();
	
	//好多个程序员
	private List<Programmer> programmers;
	
	public ProductManager(Programmer... programmer) {
		programmers = Arrays.asList(programmer);
	}

	//添加命令
	public void addCommand(Command command){
		commands.add(command);
	}
	
	//分派命令给程序员
	public void assignCommand(){
		
		//执行所有命令
		for(Command command : commands){
			command.execute();
		}
		
	}
	
	//撤销请求
	public void cancelCommand(int index){
		
		if(index >= commands.size()){
			System.out.println("无法撤销,命令不存在");
			return;
		}
		
		System.out.println("产品经理撤销了第" + (index + 1) + "个命令");
		commands.remove(index);
		System.out.println("剩余"+commands.size()+"个命令");
	}
	
	//随机指派一个程序员
	public Programmer randomProgrammer(){
		return programmers.get(new Random().nextInt(programmers.size()));
	}

	public List<Command> getCommands() {
		return commands;
	}

	public void setCommands(List<Command> commands) {
		this.commands = commands;
	}

	public List<Programmer> getProgrammers() {
		return programmers;
	}

	public void setProgrammers(List<Programmer> programmers) {
		this.programmers = programmers;
	}
	
}
