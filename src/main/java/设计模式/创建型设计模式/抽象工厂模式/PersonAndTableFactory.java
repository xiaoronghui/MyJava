package 设计模式.创建型设计模式.抽象工厂模式;

//创建人类和桌子的工厂
public class PersonAndTableFactory implements AbstractFactory {

	@Override
	public Animal createAnimal() {
		return new Person();
	}

	@Override
	public Furnitrue createFurniture() {
		return new Table();
	}

}
