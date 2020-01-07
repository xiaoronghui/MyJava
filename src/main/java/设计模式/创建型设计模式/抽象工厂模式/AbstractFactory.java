package 设计模式.创建型设计模式.抽象工厂模式;

//抽象工厂,避免if...lse
public interface AbstractFactory {
	
	//创建动物
	Animal createAnimal();
	
	//创建家具
	Furnitrue createFurniture();
	
}
