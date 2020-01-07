package Java基础.时间类;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class 时间DateFormat类 {
	public static void main(String[] args) {
		/*
		 	DateFormat是抽象类,它的子类有SimpleDateFormat,它只有这个子类
		 */
		DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS 当年的第w周");
		Date date=new Date(2134123412L);
		System.out.println(dateFormat.format(date));
		try {
			Date date2=new  SimpleDateFormat("yyyy-MM-dd").parse("2014-2-28");
			System.out.println(date2.toLocaleString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
