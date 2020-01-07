package Java基础.时间类;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class 时间Calendar类 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		Calendar cal = Calendar.getInstance();
		Date now = cal.getTime();
		System.out.println(now	);
		
		/*直接设置年月日,时分秒*/
		cal.set(2018, Calendar.FEBRUARY, 25, 10, 24, 36);
		System.out.println(String.format("%1$tF %1$tT", cal));
		
		/*星期日~星期六 1 ~ 7*/
		int  weekDay = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println("今天星期:"+weekDay);
		
		int  c= weekDay - Calendar.MONDAY;
		System.out.println("距离星期一是 : "+ c  );
		cal.add(Calendar.DATE, -(c +7 ));
		
		System.out.println(cal.getTime());
		
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,E");
		/*
		 	Calendar日历抽象类,GregorianCalendar是子类,是公历的意思
		 	Calendar c=new GregorianCalendar();
		 	我们可以通过Calendar.getInstance()返回一个GregorianCalendar的实例.
		 	内部的源码就是这么实现的
		 */
		Calendar c1=Calendar.getInstance();
		c1.set(2014, Calendar.JANUARY, 12, 20, 32,12); //设置年月日时分秒,"2014-1-12 20:32:12"
		System.out.println(df.format(c1.getTime()));
		
		//日期计算  add方法中第一个参数表示需要计算时间的哪部分,第二个参数是加数
		c1.add(Calendar.YEAR, 1);  
		c1.add(Calendar.MONTH, 1);
		c1.add(Calendar.DATE, 1);
		c1.add(Calendar.HOUR, 1); //HOUR_OF_DAY 表示24小时制
		c1.add(Calendar.MINUTE, 1);
		c1.add(Calendar.SECOND, 1);
		System.out.println(df.format(c1.getTime()));
		//同理,我们可以根据类型得到时间各部分的值
		System.out.println(c1.get(Calendar.YEAR));  
		System.out.println(c1.get(Calendar.MONTH));
		System.out.println(c1.get(Calendar.DATE));
		System.out.println(c1.get(Calendar.HOUR));
		System.out.println(c1.get(Calendar.MINUTE));
		System.out.println(c1.get(Calendar.SECOND));
		System.out.println(c1.get(Calendar.DAY_OF_WEEK)); //星期几(从1-7,星期日到星期六)
		System.out.println(c1.getActualMaximum(Calendar.DATE)); //获取当月有几天
		
		System.out.println(c1.getGreatestMinimum(Calendar.DATE)); //获取当月最小的是几号
		System.out.println(c1.getLeastMaximum(Calendar.DATE)); //获取当月最大的是几号
		
	}
}
