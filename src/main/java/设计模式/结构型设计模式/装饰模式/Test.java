package 设计模式.结构型设计模式.装饰模式;

public class Test {
	
	public static void main(String[] args) {
		
		//被装饰者
		Animal cat = new Cat();
		Animal dog = new Dog();
		
		//染色
		Animal dyeingCat = new DyeingDecorator(cat);
		dyeingCat.name();
		
		Animal dyeingDog = new DyeingDecorator(dog);
		dyeingDog.name();
		
		System.out.println("==============================");
		
		//裙子
		Animal dressCat = new DressDecorator(dyeingCat);
		dressCat.name();
		
		Animal dressDog = new DressDecorator(dyeingDog);
		dressDog.name();
		
		
	}
}
