package Java基础.访问修饰符1;

public class Bear {
	/*
	 	Bear_animal是一个内部类,内部类相当于外部类的一个属性
	 	既然是属性,当然只有自己和子类才能访问
	 */
	protected class Bear_animal{
		public Bear_animal() {
		}
	};
}


