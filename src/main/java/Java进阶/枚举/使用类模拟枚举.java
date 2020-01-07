package Java进阶.枚举;

public class 使用类模拟枚举 {
	public static void main(String[] args) {
		/*
		 * 枚举:
		 *   限定某个类型的实例只能取指定范围的数据
		 * 用类模拟:
		 *    让该类的实例只能是指定范围内的实例
		 */
		WeekDay mon=WeekDay.MON; 
		System.out.println(mon.nextDay());
		
	}
}

abstract class WeekDay{
	private WeekDay(){}; //构造方法私有化
	//星期日
	/*
	 * 这种写法很有意思,WeekDay是一个抽象类,它不能实例化,只有实现了它的子类才可以实例化
	 * 实例化一个匿名的子类,代码逻辑直接写在里面.格式如下
	 * new 父类名称(){
	 * 		//子类方法和属性
	 * }
	 */
	public final static WeekDay SUN=new WeekDay(){
		  public WeekDay nextDay(){
			return MON;
		}
	};
	//星期一
	public final static WeekDay MON=new WeekDay(){
		public WeekDay nextDay(){
			return SUN;
		}
	};
	//抽象方法,让子类去实现
	public abstract WeekDay nextDay();
	
	public String toString() {
		return (this==SUN)?"SUN":"MON";
	}
	
	
}