package 设计模式.行为型设计模式.访问者模式;

public class Test {
	
	public static void main(String[] args) {
		
		//元素A
		Element a = new ElementA("张飞", 24);
		Element a1 = new ElementA("关羽", 27);
		
		//元素B
		Element b = new ElementB("长矛", "红色");
		Element b1 = new ElementB("大刀", "白色");
		
		//对象结构类
		ObjectStruct objectStruct = new ObjectStruct();
		objectStruct.add(a);
		objectStruct.add(a1);
		objectStruct.add(b);
		objectStruct.add(b1);
		
		//访问者A和B
		Visitor visitorA = new VisitorA();  //只访问年龄和名字
		Visitor visitorB = new VisitorB();  //只访问名字和颜色
		
		//访问所有元素
		System.out.println("==访问者A正在访问==");
		objectStruct.view(visitorA);
		
		System.out.println("==访问者B正在访问==");
		objectStruct.view(visitorB);
		
	}
	
}
