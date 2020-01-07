package Java基础.关键字;
	//super关键字指的是子类中包含的那个父类对象
	public class super关键字 {
		public static void main(String[] args) {
			/*
			  java继承内存分析:
			      构建一个子类实例的时候,先不断的往上追溯,构建父类对象,然后在构建子类对象.
			      父类对象被包含在子类对象中.
			      当要调用方法的时候是去类的方法区中找到该方法, 然后把this和super传入进去执行一下;
			   	 如果自己类中找不到,那向父类追溯,一直找到该方法为止,把this和super传入进去执行.
			 */
			Brid a=new Brid();
			/*
			 	动物中fuck方法的this.eyes会指向谁呢? 
			 	  我们发现指向的是Animal中国的eyes,由此可见,上面的内存分析是正确的.
			*/
			a.fuck(); 
		}
	}
	//动物类
	class Animal{
		String eyes="眼睛1";
		String mouth;
		public Animal(){
			super(); //隐式的调用父类Object的构造方法,会构造一个Object的实例被Animal实例包围
		}
		public void run(){
			System.out.println("我会跑的..");
		}
		public void fuck(){
			System.out.println(this.eyes); //打个断点可以看到this中含有两个eyes,"眼睛1"排在第一个,从而取第一个;
			System.out.println("this的类型:"+this.getClass());//这里证明了谁调用fuck,那么this就指向谁
			/*
			   当要调用方法的时候是去类的方法区中找到该方法, 然后把this和super传入进去执行一下;
			   如果自己类中找不到,那向父类追溯,一直找到该方法为止,把this和super传入进去执行.
			*/
			this.run();
		}
	}
	//鸟类
	class Brid extends Animal{
		String eyes="眼睛2";
		String wing="翅膀"; //翅膀
		public Brid(){
			super(); //隐式的调用父类Animal的构造方法,会构造一个Animal的实例被Brid实例包围
		}
		//重写
		public void run(){
			super.run(); //通过super关键字调用被重写的方法
			System.out.println("我是会飞的..");
		}
	}
