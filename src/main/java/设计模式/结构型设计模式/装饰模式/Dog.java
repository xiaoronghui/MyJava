package 设计模式.结构型设计模式.装饰模式;

//被装饰者
public class Dog implements Animal{

	@Override
	public void name() {
		System.out.println("我是一只狗");
	}

}
