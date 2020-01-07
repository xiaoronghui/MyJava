package Java基础.异常机制;

public class 自定义异常 {
	public static void main(String[] args) {
		/*
		 	有些时候我们想把业务上的某些不符合要求的做看成是一个异常,然而JDK中没有这种异常,
		 	所以我们可以自定义一个异常;该类继承Exception即可
		 	比如:
		 	 如果某个变量的值为"张飞",那我就认为是个异常;
		 */
		 String name="张飞";
		 System.out.println("执行一堆的代码块..");
		 if("张飞".equals(name)){
			 try {
				throw new MyException("变量的值不能为张飞!");
			} catch (MyException e) {
				e.printStackTrace();
			}
		 }
	}
	
}
class MyException extends Exception{
	MyException(){
		
	}
	MyException(String msg){
		super(msg); //调用父类的构造方法来构造
	}
}
