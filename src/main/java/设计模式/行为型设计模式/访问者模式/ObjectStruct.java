package 设计模式.行为型设计模式.访问者模式;

import java.util.ArrayList;
import java.util.List;

//对象结构
public class ObjectStruct {

	private List<Element> list = new ArrayList<>();
	
	public void add(Element element){
		list.add(element);
	}
	
	public void view(Visitor visitor){
		
		for(Element element : list){
			element.accept(visitor);
		}
		
	}
	
	
}
