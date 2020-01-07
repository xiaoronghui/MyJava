package Java进阶.枚举;

public class 枚举里面写方法 {

	public static void main(String[] args) {
		
	}
	

	
/**
 * 枚举元素和父类是一模一样的,所以我们在枚举元素中可以写和父类一模一样的方法,
 * ,只是实现不一样.TimeUnit点设计思路就是这个样子的.
 *
 */
static enum TestEnum {

	ABC{
		public void fuck(){
			System.out.println("哈罗");
		}
	},
	DEF{
		public void fuck(){
			System.out.println("你好");
		}
	};
	
	public void fuck() {
		throw new AbstractMethodError();
	}
	
}

}



