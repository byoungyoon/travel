package travel.commons;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DayUtil {
	public String getToday() {
		Calendar today = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		String day = formater.format(today.getTime());
		
		return day;
	}
}
