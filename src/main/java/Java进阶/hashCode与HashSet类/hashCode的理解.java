package Java进阶.hashCode与HashSet类;

import java.util.Collection;
import java.util.HashSet;

import Java进阶.反射.MyPoint;

public class hashCode的理解 {
	/*
	 *  如果想查找一个集合中是否包含有某个对象,大概程序的代码怎样写呢?
	 *  你通常是逐一取出每个元素与要查找的对象进行比较,当发现某个元素与要查找的对象
	 *  进行equals方法比较的结果相等时,则停止继续查找并返回肯定的信息,否则,返回否定的信息.
	 *  如果一个集合中有很多个元素,譬如有一万个元素,并且没有包含要查找的对象时,则意味着你的程序需要从该集合中
	 *  取出一万个元素进行逐一比较才能得到结论.有人发明了一种哈希算法来提高从集合中查找元素的效率,这种方式
	 *  将集合分成若干个存储区域,每个对象可以计算出一个哈希码,可以将哈希码分组,每组分别对应某个存储区域.根据一个对象
	 *  的哈希吗就可以确定该对象应该存储在哪个区域.
	 *  
	 *  HashSet就是采用哈希算法存取对象的集合,它内部采用了对某个数字n进行取余的方式对哈希码进行分组和划分
	 *  对象的存储区域.Object类中定义了一个hashCode()方法来返回每个Java对象的哈希码,当从HashSet集合中查找
	 *  某个对象时,Java系统首先调用对象的hashCode()方法获得该对象的哈希码,然后根据哈希码找到相应的存储区域,
	 *  最后取出该存储区域内的每个元素与该对象进行equals方法比较,这样不用遍历集合中的所有元素就可以得到结论.
	 *  可见,HashSet集合具有很好的对象检索性能.
	 * 
	 */
	public static void main(String[] args) {
		Collection collection=new HashSet();
		MyPoint point1=new MyPoint(3,3);
		MyPoint point2=new MyPoint(4,4);
		MyPoint point3=new MyPoint(5,6);
		MyPoint point4=new MyPoint(3,3);
		collection.add(point1);
		collection.add(point2);
		collection.add(point3);
		collection.add(point4);
		System.out.println(collection.size());
		//HashSet是按照对象的hashCode进行存储的
		//我认为point1和point4是相等的,从而我们要重写hashcode方法和equal方法
		//重写之后,长度为3
		System.out.println(collection.size());
		//注意,计算hashCode的时候会根据属性的值进行计算,如果属性的值改变,hashcode的值也会改变\
		//从而放进hashSet中的值不要随便的改变属性值,否出会造成内存溢出,如下
		point1.setX(100); //point1的属性x被改变,hashcode值也是变化的
		collection.remove(point1);
		/*
		 *从而移除point1之后,长度依然为3,为什么呢?
		 *移除的时候,先是计算point1的hashCode,因为point1的hashCode值已经改变,从而找不到
		 *这个hashCode值所对应的存储区域了,从而长度依然为3.
		 *如果这个程序反复的被调用,你又认为该对象已经被移除,那么这个对象就会一直被存在内存中,
		 *最后内存溢出.
		 */
		System.out.println(collection.size());
		/*
		 * 总结:
		 *  1)  通常来说,一个类的两个实例对象用equals()方法比较的结果相等时,他们的哈希码也必须相等,但反之则
		 *    不成立,及equals方法比较结果不相等的对象可以有相同的哈希码,或者说哈希码相同的两个对象equals方法
		 *    比较的结果可以不等,例如,字符串"BB"和"Aa"的equals方法比较结果肯定不相等,但他们的hashCode方法返回值却相等.
		 *   2) 当一个对象被存储进HashSet集合中以后,就不能修改这个对象中的那些参与计算哈希值的字段了,否则,对象
		 *   修改后的哈希值与最初存储进HashSet集合中时的哈希值就不相同了,在这种情况下,即使在contains方法使用该对象的当前
		 *   引用作为的参数去HashSet集合中检索对象,也将返回找不到对象的结果,这也会导致无法从HashSet集合中单独删除当前
		 *   对象,从而造成内存泄露.
		 */
	}
}

//
