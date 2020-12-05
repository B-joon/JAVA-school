package com.cal02;

import java.util.Calendar;
// 달력 만들기
// java.util.Calendar
public class CalendarUseApi {

	public static void Cal(int year, int month) {
		
		Calendar cal = Calendar.getInstance();
		
		cal.set(Calendar.YEAR, Integer.valueOf(year));
		cal.set(Calendar.MONTH, Integer.valueOf(month) - 1);
		
		
		int week = Calendar.DAY_OF_WEEK;
	}
}
