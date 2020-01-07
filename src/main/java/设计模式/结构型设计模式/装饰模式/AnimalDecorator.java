package 设计模式.结构型设计模式.装饰模式;

//装饰者
public class AnimalDecorator implements Animal{
	
	Animal animal;

	public AnimalDecorator(Animal animal) {
		super();
		this.animal = animal;
	}

	@Override
	public void name() {
		animal.name();
	}
	
}
