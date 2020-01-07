package 设计模式.创建型设计模式.工厂方法模式;

//工厂方法模式
public class FactoryMethodPattern {
	
	//根据序号创建不同的动物
	public static Animal createAnimal(int index){
		
		if(index == 1)
			return new Person();
		
		if(index == 2)
			return new Cat();
		
		return null;
	}
	
	//根据序号创建不同的家具
	public static Furnitrue createFurniture(int index){
		
		if(index == 1)
			return new Bed();
		
		if(index == 2)
			return new Table();
		
		return null;
	}

}
