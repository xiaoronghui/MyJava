package 设计模式.行为型设计模式.观察者模式;

public class Test {

	public static void main(String[] args) {
		
		//被观察者
		Author author = new Author();
		
		ReaderA a = new ReaderA();
		ReaderB b = new ReaderB();
		
		//观察者
		author.addObserver(a);
		author.addObserver(b);
		
		//状态改变
		author.pushlishNewBook("神雕侠侣");
		author.pushlishNewBook("笑傲江湖");
		
	}
	
}
