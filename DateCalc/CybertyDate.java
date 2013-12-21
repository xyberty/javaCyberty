

import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author pask
 */

public class CybertyDate {
	private Calendar cal;// = Calendar.getInstance();
	static SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
	int days;
	
	CybertyDate(String date) {
		if (date != null) {
			this.cal = Calendar.getInstance();
	        try {
				this.cal.setTime(this.dateFormat.parse(date));
	        } catch (ParseException ex) {
	            System.out.println(ex.getLocalizedMessage());
	        }
		}
	}
	
	// Получить дату
	public Calendar date() {
		return this.cal;
	}
	
	// Получить год из даты
	public int year() {
		return this.cal.get(Calendar.YEAR);
	}
	
	// Получить день года из даты
	public int dayOfYear() {
		return this.cal.get(Calendar.DAY_OF_YEAR);
	}
	
	// Количество дней в году
	public int days() {
		int retDays = 365;
		if (isLeapYear()) {
			retDays++;
		}
		return retDays;
	}
	
	// Является ли год високосным
    private boolean isLeapYear() {
        boolean retBool = false;
		int year = year();		
        
        if ((year % 4) == 0) {
            if (((year % 100) != 0) || ((year % 400) == 0)) {
                retBool = true;
            }
        }
		return retBool;
    }

}