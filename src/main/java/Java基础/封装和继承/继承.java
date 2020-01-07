package Java基础.封装和继承;

public class 继承 {
	class animal{
		String eyes;
		public void move(){
			System.out.println("会动的生物!");
		}
	}
	//不使用继承
	class bird0{
		String eyes;
		public void move(){
			System.out.println("会动的生物!");
		}
		public void fly(){
			System.out.println("鸟会飞..");
		}
	}
	/*
	 * 通过对比可以得知,继承提高了代码的复用性. 
	 */
	class bird1 extends animal {
		public void fly(){
			this.move();//调用父类的方法
			System.out.println("鸟会飞..");
		}
		//重写父类的方法--> 好处:不仅继承了父类的方法,还可对继承来方法进行扩充和改进功能;
		public void move(){
			System.out.println("会飞的生物!");
		}
	}
}
