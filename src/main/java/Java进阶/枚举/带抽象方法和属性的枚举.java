package Java进阶.枚举;

public class 带抽象方法和属性的枚举 {
	public static void main(String[] args) {
		for(TrafficLight t :TrafficLight.values()){
			System.out.println(t.nextLight());
		}
	}
}
/*
 *要求定义一个交通灯的枚举,可以显示下一盏灯和每个灯显示多长时间
 */
enum TrafficLight{
	RED(30){
		  TrafficLight nextLight(){
			System.out.println("当前是红灯,时间是"+30+"秒,下一盏是绿灯!");
			return GREEN;
		}
	},
	GREEN(10){
		 TrafficLight nextLight(){
			    System.out.println("当前是绿灯,时间是"+10+"秒,下一盏是黄灯!");
				return YELLOW;
			}
	},
	YELLOW(5){
		 TrafficLight nextLight(){
			 System.out.println("当前是红灯,时间是"+5+"秒,下一盏是红灯!");
				return RED;
			}
	};
	//抽象方法下一盏灯,枚举中的元素是枚举类的子类,所以枚举元素要实现这个抽象方法
	abstract TrafficLight nextLight();
    //定义一个属性,time,用来表示多长时间
	int time;
	private TrafficLight(int time){
		this.time=time;
	}
}