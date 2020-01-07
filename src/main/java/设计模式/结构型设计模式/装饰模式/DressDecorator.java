package 设计模式.结构型设计模式.装饰模式;

//穿衣装饰者
public class DressDecorator extends AnimalDecorator {

	public DressDecorator(Animal animal) {
		super(animal);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void name() {
		// TODO Auto-generated method stub
		super.name();
		dressSkirt();
	}
	
	public void dressSkirt(){
		System.out.println("被穿上了裙子");
	}
	
	
}
