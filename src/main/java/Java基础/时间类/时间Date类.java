package Java基础.时间类;
import java.util.Date;

public class 时间Date类 {
	public static void main(String[] args) {
		Date date=new Date(2014,10,12); //date表示某一个时刻,精确到了毫秒
		Date date2=new Date(2014,10,13); //date表示某一个时刻,精确到了毫秒
		date.getTime(); //时间的毫秒数
		System.out.println(date.getYear());
		//比较两个时间
		System.out.println(date.before(date2)); //比较date是否在date2之前,返回boolean类型
		long lon=Date.parse("Mon 6 Jan 1997 13:3:00"); //把一个字符串转化为一个long类型的整数
		System.out.println(lon);
		Date date3=new Date("Mon 6 Jan 1997 13:3:00"); //通过字符串来构建时间
		System.out.println(date3.getYear());
		//我们发现要通过字符串构建一个时间有点麻烦,从而Date的很多方法都废弃了,现在都用SimpleDateFormat类
	}
}
