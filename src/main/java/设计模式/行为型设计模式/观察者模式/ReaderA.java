package 设计模式.行为型设计模式.观察者模式;


public class ReaderA implements Observer{

	@Override
	public void update(Author author) {
		System.out.println("Hi ReaderA , 你该看新书了 : <"+author.getNewBookName()+">");
	}

}
