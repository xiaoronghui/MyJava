package Java基础.接口;

public class 利用接口的多态模拟钩子函数 {
	
}

class PaintFrame{
	public static void drawFrame(PaintInf paintInf){
		System.out.println("启动线程");
		System.out.println("增加循环");
		System.out.println(".....");
		/*
		 	我只负责启动线程之类的代码,画图的工作有其它程序员来写,所以我定义一个接口,要求其它程序员
		 	实现接口的paint方法,你传什么我就按你的要求画一个;
		 	所谓钩子函数,就是说我paintInf.paint();这个代码写在这里,你挂到paint的实现代码是什么我就执行什么;
		 	这样有利于分工和扩展,以后要是遇到类似的问题的话,可以采用这种方式.
		 	说白了就是java的多态特性带来的好处;
		 */
		paintInf.paint(); //
	}
}

interface PaintInf{
	void paint();
}

class GameFrame01 implements PaintInf{
	public void paint() {
		System.out.println("画剑仙城的图..");
	}
}

class GameFrame02 implements PaintInf{
	public void paint() {
		System.out.println("画祖龙城的图..");
	}
}
