package 设计模式.创建型设计模式.建造者模式;

public class Test {
	public static void main(String[] args) {
		
		Role dog = RoleDirector.constructRole(new DogBuilder());
		System.out.println(dog.getHead());
		
		Role man = RoleDirector.constructRole(new ManBuilder());
		System.out.println(man.getHead());
		
	}
}
