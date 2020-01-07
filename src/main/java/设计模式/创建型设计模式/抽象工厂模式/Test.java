package 设计模式.创建型设计模式.抽象工厂模式;

public class Test {
	
	public static void main(String[] args) {
		
		//人类和桌子的生产工厂
		AbstractFactory personAndTableFactory = new PersonAndTableFactory();
		
		//生产人类和桌子
		Animal person = personAndTableFactory.createAnimal();
		Furnitrue table = personAndTableFactory.createFurniture();
		
		//猫和床的生产工厂
		AbstractFactory catAndBedFactory = new CatAndBedFactory();
		
		//生产猫和床
		Animal cat = catAndBedFactory.createAnimal();
		Furnitrue bed = catAndBedFactory.createFurniture();
		
	}

}
