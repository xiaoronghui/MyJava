package 设计模式.结构型设计模式.适配器模式;

public class SpeakFuckAdapter implements Fuck{

	Speak speak;
	
	public SpeakFuckAdapter(Speak speak) {
		this.speak  = speak;
	}

	@Override
	public void say(String word) {
		speak.speak(word);
	}
	
}
