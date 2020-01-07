package Java进阶.枚举;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/*
 * 目的:用类模拟枚举
 * 分析:
 *    1.枚举元素可以用类名直接调用,说明枚举元素是静态的属性
 *    2.枚举类不可以new 实例对象,说明枚举类的构造方法是私有的
 *    3.枚举类 变量名=枚举类.枚举元素,说明了枚举元素是枚举类的子类或者枚举类本身的实例
 *    4.打印枚举元素,得到是枚举元素的名称,说明枚举类重写了toString()方法
 *    5.枚举有个values方法,可以得到每个枚举元素
 *    6.枚举有个ordinal方法,如何得到枚举元素所在的位置
 *    
 *    疑问:
 *    枚举元素是final的吗?
 *    我发现给一个枚举元素赋值另外一个枚举元素回报The final field 枚举的定义和入门.WeekDay2.MON cannot be assigned的错误
 *    证明枚举元素是final,这样能保证每个枚举元素的唯一性
 *    
 *    遗留问题:
 *    7.我每次values都要反射机制一次,这样很繁琐.而且取ordinal()还要遍历,更繁琐,有没有好的办法?
 */
public abstract class ImitateEnum {
	
	public static void main(String[] args) {
		for(ImitateEnum temp :ImitateEnum.values()){
			System.out.println(temp.name()+"==>"+temp.ordinal());
		}
	}
	//构造方法需要私有化
	private ImitateEnum(){
		
	}
	//星期1,创建抽象类必须实现它的方法.
	public  static ImitateEnum MON=new ImitateEnum(){
		List<ImitateEnum> list=new ArrayList<ImitateEnum>();
		public String toString() {
			return "MON";
		}
		public ImitateEnum nextDay() {
			return TUE;
		}
		public String name() {
			return this.toString();
		}
		public int ordinal() {
			List<ImitateEnum> list=ImitateEnum.values();
			int k=-1;
			for(int i=0;i<list.size();i++){
				if(this.equals(list.get(i))){
					k=i;
					break;
				}
			}
			return k;
		}
	};
	//星期2
	public  static ImitateEnum TUE=new ImitateEnum(){
		public String toString() {
			return "TUE";
		}
		public ImitateEnum nextDay() {
			return WED;
		}
		public String name() {
			return toString();
		}
		@Override
		public int ordinal() {
			List<ImitateEnum> list=ImitateEnum.values();
			int k=-1;
			for(int i=0;i<list.size();i++){
				if(this.equals(list.get(i))){
					k=i;
					break;
				}
			}
			return k;
		}
	};
	//星期3
	public  static ImitateEnum WED=new ImitateEnum(){
		public String toString() {
			return "WED";
		}
		public ImitateEnum nextDay() {
			return THU;
		}
		public String name() {
			return toString();
		}
		@Override
		public int ordinal() {
			List<ImitateEnum> list=ImitateEnum.values();
			int k=-1;
			for(int i=0;i<list.size();i++){
				if(this.equals(list.get(i))){
					k=i;
					break;
				}
			}
			return k;
		}
	};
	//星期4
	public  static ImitateEnum THU=new ImitateEnum(){
		public String toString() {
			return "THU";
		}
		public ImitateEnum nextDay() {
			return FRI;
		}
		public String name() {
			return toString();
		}
		@Override
		public int ordinal() {
			List<ImitateEnum> list=ImitateEnum.values();
			int k=-1;
			for(int i=0;i<list.size();i++){
				if(this.equals(list.get(i))){
					k=i;
					break;
				}
			}
			return k;
		}
	};
	//星期5
	public  static ImitateEnum FRI=new ImitateEnum(){
		public String toString() {
			return "FRI";
		}

		public ImitateEnum nextDay() {
			return SAT;
		}

		public String name() {
			return toString();
		}

		@Override
		public int ordinal() {
			List<ImitateEnum> list=ImitateEnum.values();
			int k=-1;
			for(int i=0;i<list.size();i++){
				if(this.equals(list.get(i))){
					k=i;
					break;
				}
			}
			return k;
		}
	};
	//星期6
	public  static ImitateEnum SAT=new ImitateEnum(){
		public String toString() {
			return "SAT";
		}
		public ImitateEnum nextDay() {
			return SUN;
		}
		public String name() {
			return toString();
		}
		@Override
		public int ordinal() {
			List<ImitateEnum> list=ImitateEnum.values();
			int k=-1;
			for(int i=0;i<list.size();i++){
				if(this.equals(list.get(i))){
					k=i;
					break;
				}
			}
			return k;
		}
	};
	//星期7
	public  static ImitateEnum SUN=new ImitateEnum(){
		public String toString() {
			return "SUN";
		}
		public ImitateEnum nextDay() {
			return MON;
		}
		public String name() {
			return toString();
		}
		public int ordinal() {
			List<ImitateEnum> list=ImitateEnum.values();
			int k=-1;
			for(int i=0;i<list.size();i++){
				if(this.equals(list.get(i))){
					k=i;
					break;
				}
			}
			return k;
		}
	};
	//重写toString方法
	public String toString() {
		return super.toString();
	}
	
	//枚举元素私有的属性,在数组所在的位置
	private int ordinal=0;
	//定义一个抽象方法,下一天
	public abstract ImitateEnum nextDay();
	//枚举元素都有name方法
	public abstract String name();
	public abstract int ordinal();
	//返回枚举元素的数组,使用反射机制获得每一个属性
	public static List<ImitateEnum> values(){
		 List<ImitateEnum> list=new ArrayList<ImitateEnum>();
		 Field[]  fields=ImitateEnum.class.getFields();
		 for(Field field :fields){
			 try {
				 ImitateEnum temp=(ImitateEnum) field.get(null);
				 list.add(temp);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		 }
		 //得到枚举类的每一个属性
		return list;
	}
	
	
}
