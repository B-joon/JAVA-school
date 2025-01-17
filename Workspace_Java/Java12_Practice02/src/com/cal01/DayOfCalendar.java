package com.cal01;

// 달력만들기
// 요일계산 -> year년 month월을 주면, year년 month월 1일의 요일 -> 요일만큼 공백 -> 7개씩 새로운 줄
public class DayOfCalendar {
	// 윤년 계산
	private static boolean isLeapYear(int year) {
		
		boolean leap = false;
		
		if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
			leap = true;
		}
		
		return leap;
	}
	// 일수 계산
	private static int getDate(int year, int month) {
		
		int tmp = 0;
		
		if (isLeapYear(year)) {
			switch (month) {
			case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				tmp = 31;
				break;
			case 4: case 6: case 9: case 11:
				tmp = 30;
				break;
			case 2:
				tmp = 29;
				break;
			}
			
		} else {
			if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
				tmp = 31;
			} else if (month == 4 || month == 6 || month == 9 || month == 11) {
				tmp = 30;
			} else if (month == 2) {
				tmp = 28;
			}
		}
		
		return tmp;
	}
	
	// 해당 월의 첫번째 요일 계산
	private static int getDayOfWeek(int year, int month) {
		
		int dayOfWeek = 0;
		int sum = 0;
		// 1.1.1 ~ year - 1.12.31
		for (int i = 1; i < year; i++) {
			for (int j = 1; j <= 12; j++) {
				sum += getDate(i, j);
			}
		}
		
		// year. 1. 1 ~ year.month-1.마지막(31, 30, 29, 28)
		for (int i = 1; i < month; i++) {
			sum += getDate(year, i);
		}
		
		// year.month.1일
		sum += 1;
		
		// 요일
		dayOfWeek = sum % 7;
		
		return dayOfWeek;
	}

	public static void prn(int year, int month) {
		// 달력 윗부분 출력
		System.out.printf("\t\t%d년 %d월\n", year,month);
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		
		
		
		// 시작요일
		int start = DayOfCalendar.getDayOfWeek(year, month);
		
		// 마지막 날짜
		int last = getDate(year, month);
		
		// 시작 요일만큼 빈공간
		for (int i = 0; i < start; i++) {
			System.out.print("\t");
		}
		
		// 달력 출력
		for (int i = 1; i <= last; i++) {
			System.out.printf("%d\t", i);
			start++;
			if (start % 7 == 0) {
				System.out.println();
			}
		}
		
	}
//	public static boolean isLeapYear(int year) {
//		
//		boolean isLeap = false;
//		
//		if ((year % 4 == 0) && (year % 100 == 0) || (year % 400 == 0)) {
//			isLeap = true;
//		} else {
//			
//		}
//		
//		return isLeap;
//	}
//	
//	public static int LastYear(int year) {
//		
//		int ly = year - 1;
//		int totalDay = (ly * 365) + (ly / 4) - (ly / 100) + (ly / 400);
//		
//		return totalDay;
//	}
//	
//	public static int LastDay(int year, int month) {
//		
//		int lastDay = 1;
//		
//		if (month == 4 || month == 6 || month == 9 || month == 11) {
//			lastDay = 30;
//		} else if (month == 2) {
//			lastDay = isLeapYear(year) ? 29 : 28;
//		} else {
//			lastDay = 31;
//		}
//		return lastDay;
//	}
//	
//	public static int Week(int year) {
//		
//		int w = LastYear(year) % 7;
//		
//		return w;
//	}
	
	
}
