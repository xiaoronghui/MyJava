package 设计模式.结构型设计模式.适配器模式;

public class Test {
	
	public static void main(String[] args) {
		
		//我现在有一个speak接口指向的实例
		Speak speak = new YoungMan();
		
		//而Vallain希望得到的是fuck接口作为参数,所以要转化一下speak接口成fuck接口
		Vallain vallain = new Vallain(new SpeakFuckAdapter(speak));
		
		vallain.scold("尼玛的");
		
	}
	
}
