package 设计模式.行为型设计模式.备忘录模式;

import java.util.ArrayList;
import java.util.List;

//管理者(备忘录对象相当于备忘录的每一页,管理者相当于书)
public class Caretaker {
	
    //缓存的备忘录
	private List<MementoIF> mementos = new ArrayList<>();
	
	//添加备忘录
	public void addMemento(MementoIF mementoIF){
		mementos.add(mementoIF);
	}
	
	//获取备忘录
	public MementoIF getMemento(int index){
		return mementos.get(index);
	}
	
	//存档个数
	public int careSize(){
		return mementos.size();
	}
	
	//删除一个存档
	public void deleteMemento(int index){
		mementos.remove(index);
	}
	
}
