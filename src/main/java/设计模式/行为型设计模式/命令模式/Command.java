package 设计模式.行为型设计模式.命令模式;

//抽象命令类(行为实现者每有一个行为,就新增一个命令实现类)
public interface Command {
	void execute();
}
