package Java基础.时间类;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class tts {

	public static void main(String[] args) {
		DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		Calendar c=Calendar.getInstance();
		Date d=c.getTime();
		System.out.println(dateFormat.format(d)+"---"+c.getActualMaximum(Calendar.DATE));
		c.set(Calendar.DATE, c.getActualMaximum(Calendar.DATE));
		d=c.getTime();
		System.out.println(dateFormat.format(d));
	}
}
