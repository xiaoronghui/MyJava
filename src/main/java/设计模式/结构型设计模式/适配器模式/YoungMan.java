package 设计模式.结构型设计模式.适配器模式;

public class YoungMan implements Speak{

	@Override
	public void speak(String word) {
		System.out.println(word);
	}

}
