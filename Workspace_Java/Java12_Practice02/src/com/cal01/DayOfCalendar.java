package com.cal01;

public class DayOfCalendar {

	public static boolean isLeapYear(int year) {
		
		boolean isLeap = false;
		
		if ((year % 4 == 0) && (year % 100 == 0) || (year % 400 == 0)) {
			isLeap = true;
		} else {
			
		}
		
		return isLeap;
	}
	
	public static int LastYear(int year) {
		
		int ly = year - 1;
		int totalDay = (ly * 365) + (ly / 4) - (ly / 100) + (ly / 400);
		
		return totalDay;
	}
	
	public static int LastDay(int year, int month) {
		
		int lastDay = 1;
		
		if (month == 4 || month == 6 || month == 9 || month == 11) {
			lastDay = 30;
		} else if (month == 2) {
			lastDay = isLeapYear(year) ? 29 : 28;
		} else {
			lastDay = 31;
		}
		return lastDay;
	}
	
	public static int Week(int year) {
		
		int w = LastYear(year) % 7;
		
		return w;
	}
	
	
}
