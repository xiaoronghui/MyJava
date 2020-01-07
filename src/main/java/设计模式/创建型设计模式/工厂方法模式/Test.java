package 设计模式.创建型设计模式.工厂方法模式;


public class Test {
	
	public static void main(String[] args) {
		
		//根据不同的参数返回不同的实例,这就是工厂方法模式
		Animal person = FactoryMethodPattern.createAnimal(1);
		
		Animal cat = FactoryMethodPattern.createAnimal(2);
		
		Furnitrue bed = FactoryMethodPattern.createFurniture(1);
		
		Furnitrue table= FactoryMethodPattern.createFurniture(2);
		
		
	}
	
}
