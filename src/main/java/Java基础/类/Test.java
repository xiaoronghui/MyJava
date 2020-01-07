package Java基础.类;

/**
 * 
＊内存分析测试
 */
public class Test {
	public static void main(String[] args) {
		/*
		 *  ----最先加载的是Test类
		 	1) 加载Person进方法区,栈中创建c变量,创建Cat的实例,把首地址赋值给p;
		 	2) p.name,p.age被赋值,"张飞"被放入方法区的常量池中,数字1直接赋值给age
	        3) 从方法区中找到say方法,开辟栈帧,执行say方法
	        4) 同理,然后就是dog的创建.当执行到d.name的时候,会先去其它类的常量池中寻找有没有叫"大黄"的常量,
	            有则共享,"大黄"被放入Test类的常量池中;
	        5) 当运行到p.dog的时候,把d变量的地址赋值给p.dow
	        6) 当运行到p.dog.say()的时候,先从p的dog属性中找到d的地址,然后调用say方法
		    
		 */
		Person p=new Person();
		p.name="张飞";
		p.age=1;
		p.say();
		Dog d=new Dog();
		d.name="大黄";
		d.age=3;
		d.say();
		p.dog=d;
		p.dog.say();
		String s="大黄";
		System.out.println(d.name==s);  //---->从这里可以看出他们字符串常量是共享的
		String s2="张飞";
		System.out.println(p.name==s2);
		String s3=new String("张飞");
		System.out.println(p.name==s3); //如果是new一个String,那就不是共享了.
	}
}
