package 设计模式.行为型设计模式.命令模式;

//新需求处理命令
public class ProblemCommand implements Command {
	
	private Programmer programmer;

	public ProblemCommand(Programmer programmer) {
		super();
		this.programmer = programmer;
	}

	@Override
	public void execute() {
		programmer.handleProblem();
	}

}
