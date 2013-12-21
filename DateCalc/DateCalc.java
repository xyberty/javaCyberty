/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Calendar;

/**
 *
 * @author pask
 */

public class DateCalc {
    static final String NAME = "Date calculator (by Pantey)";
    static final String VERSION = "0.01";
    static final String BUILD = "20131126";
    
	private static String padRight(String str, int n) {
		 //return String.format("%1$-" + n + "s", s);
		return String.format("%" + n + "s", str).replace(' ', '-');
	}

	// Вывести на экран версию программы
	private static void getVersion() {
		final String version = NAME + " v" + VERSION + "-" + BUILD;

        System.out.println(padRight("", version.length()));
        System.out.println(version);
    }
    
	// Вычислить разницу между двумя датами
    public static long daysBetween(Calendar startDate, Calendar endDate) {
        Calendar date = (Calendar) startDate.clone();
        long daysBetween = 0;
        while (date.before(endDate)) {
            date.add(Calendar.DAY_OF_MONTH, 1);
            daysBetween++;
        }
        return daysBetween;
    }

	public static void main(String[] args) {
		CybertyDate date1 = new CybertyDate(args[0]);
		CybertyDate date2 = new CybertyDate(args[1]);
       
        getVersion();

		System.out.println("Difference between " + args[0] + " and " + args[1] + " is:");
		System.out.println(daysBetween(date2.date(), date1.date()) + " days");
    }
}
