package 设计模式.创建型设计模式.单例模式;

//简单单例模式
public class SimpleSingleton {
	
	private static SimpleSingleton singleton = new  SimpleSingleton();
	
	private SimpleSingleton(){};
		
	public static SimpleSingleton getInstance(){
		return singleton;
	}
	
}
