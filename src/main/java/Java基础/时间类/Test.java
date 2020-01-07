package Java基础.时间类;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Test {
	public static void main(String[] args) {
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,E");
		Calendar c=Calendar.getInstance();
		c.set(2014, Calendar.JANUARY, 12, 20, 32,12); //设置年月日时分秒,"2014-1-12 20:32:12"
		System.out.println(df.format(c.getTime()));
		c.set(Calendar.DATE, 13);
		System.out.println(df.format(c.getTime()));
		System.out.println(c.get(Calendar.DAY_OF_WEEK)); //
		/*
		 	1.2014-1-12 20:32:12 
		 	2.我打印星期日到星期六
		 	3.我可以知道当月有多少天.除了2月份需要判断之外.
		 	4.我不知道1号是星期几.我不知道这天放到哪个星期下面.
		 	5.我设置日历类,可以得知今天是星期几.根据是星期几而确定换几个空格,然后按顺序打印.
		 */
	
		int curDays=c.getActualMaximum(Calendar.DATE);
		c.set(Calendar.DATE, 1);
		int week=c.get(Calendar.DAY_OF_WEEK); //1号是星期几
		System.out.println(week);
		StringBuilder sb=new StringBuilder();
		sb.append("日\t一\t二\t三\t四\t五\t六\n");
		int count=0;
		for(int k=1;k<week;k++){
			count++;
			sb.append("  \t");
		}
		for(int i=1;i<=curDays;i++){
		   count++;
		   if(count%7==0){
			   sb.append(i+"\t\n");
		   }else{
			   sb.append(i+"\t");
		   }
		   
		}
		System.out.println(sb);
	}
	/*
	  不满意的地方:
	 	1.我为了获得1号是星期几,我把日期重新设置了一下.这样我还得记住原来的日期,然后再设置回去;
	 	  老是会怎么得到这个日期?
	 	2.数字没有在星期的正下方.好难看.
	 	   老师会怎么打印哪些数字?我感觉自己的做法好蠢..
	  总结: 
	      我的做法比老师的巧妙多了.老师太蠢了
	 */
}
