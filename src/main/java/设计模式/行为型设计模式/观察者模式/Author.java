package 设计模式.行为型设计模式.观察者模式;

import java.util.ArrayList;
import java.util.List;

public class Author{
	
	//观察者
	private List<Observer> observers = new ArrayList<Observer>(); 
	
	//新书
	private String newBookName;

	public void addObserver(Observer observer) {
		observers.add(observer);
	}
	
	public void pushlishNewBook(String newBookName){
		this.newBookName = newBookName;
		notifyObservers();
	}

	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}
	
	//通知观察者
	private void notifyObservers() {
		for(Observer item : observers){
			item.update(this);
		}
	}

	public String getNewBookName() {
		return newBookName;
	}
	
}
