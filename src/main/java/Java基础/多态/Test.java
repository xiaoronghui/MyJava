package Java基础.多态;

public class Test {
	public static void testVoice(Animal animal){
		animal.voice();
		if(animal instanceof Cat)((Cat) animal).catchMouse();
		if(animal instanceof Dog)((Dog) animal).lookDoor();
	}
	/*
	    如果不使用多态,为了测试3种动物的叫声,我得写3种方法,若是Animal有成百上千个子类,我岂不是
	    要写成百上千个方法.
		public static void testVoice(Cat cat){
			cat.voice();
		}
		public static void testVoice(Dog dog){
			dog.voice();
		}
		public static void testVoice(Pig pig){
			pig.voice();
		}
	*/
	
	public static void main(String[] args) {
	/*
	 	多态的内存分析
	 	1) 运行到Animal cat=new Cat();的时候,先加载Animal类和Cat类,在栈中创建变量cat,然后创建Cat对象,首地址赋值
	 	    给cat;
	 	2) 运行到Cat cat2=((Cat)cat);的时候,在栈中创建cat2变量,强转后的cat依然是cat那块内存区域,把首地址赋值给cat2
	 	3) 运行到进入testVoice方法的时候,在栈中创建一个栈帧,animal是栈帧内的一个局部变量,animal的值是Cat对象的首
	 	    地址.
	 	4) animal.voice();就是从Cat对象的中寻找voice方法,然后调用就是
	 	5) 其实animal.catchMouse在执行中是可以使用的,但是为了让编译通过,从而我们得强转((Cat) animal).catchMouse()
	 	    之后才能调用
	 */
	//------------内存分析start--------------------
	Animal cat=new Cat();
	Cat cat2=((Cat)cat);
	cat2.catchMouse();
	testVoice(cat);  
	//------------内存分析end--------------------
		
		Animal dog=new Dog();
		Animal pig=new Pig();
		testVoice(dog);
		testVoice(pig);
		//编译报错,因为编译器此时认为cat是Animal类,然后发现Animal中并没有catchMouse方法,所以编译报错;
		//cat.catchMouse();
		//若是cat想调用catchMouse方法,必须强转为Cat类
		
	}
}
