package 设计模式.结构型设计模式.适配器模式;

public class Vallain {
	
	Fuck fuck;

	public Vallain(Fuck fuck) {
		this.fuck = fuck;
	}
	
	public void scold(String word){
		fuck.say("scold : " + word);
	}
	
}
