package 设计模式.行为型设计模式.备忘录模式;

//发起者
public class Originator {
	
	private String state;
	
	//创建当前状态的备忘录
	public MementoIF snapshot(){
		return new Memento(state);
	}
	
	//恢复到某个备忘录状态
	public void restoreMemento(MementoIF mementoIF){
		this.state = ((Memento)mementoIF).getState();
	}
	
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	//只有发起者Originator才可以对Memento进行操作
	private class Memento implements MementoIF{
		
		private String state;

		public Memento(String state) {
			this.state = state;
		}

		public String getState() {
			return state;
		}
		
	}
	
}
