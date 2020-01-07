package Java基础.多态;

public class Animal {
	public void voice(){
		System.out.println("动物的叫声");
	}
}

class Cat extends Animal{
	public void voice(){
		System.out.println("喵喵喵");
	}
	public void catchMouse(){
		System.out.println("我正在抓老鼠..");
	}
}

class Dog extends Animal{
	public void voice(){
		System.out.println("汪汪汪");
	}
	public void lookDoor(){
		System.out.println("我正在看门..");
	}
}

class Pig extends Animal{
	public void voice(){
		System.out.println("哼哼哼");
	}
}