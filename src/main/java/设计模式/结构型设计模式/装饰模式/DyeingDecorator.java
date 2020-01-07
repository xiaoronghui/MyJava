package 设计模式.结构型设计模式.装饰模式;


//给动物染色
public class DyeingDecorator extends AnimalDecorator{

	public DyeingDecorator(Animal animal) {
		super(animal);
	}

	@Override
	public void name() {
		super.name();
		dyeRed();
	}
	
	public void dyeRed(){
		System.out.println("被染成了红色");
	}
	
	

}
