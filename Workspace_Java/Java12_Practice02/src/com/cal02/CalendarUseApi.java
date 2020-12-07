package com.cal02;

import java.util.Calendar;
// 달력 만들기
// java.util.Calendar
public class CalendarUseApi {

	public void prn(int year, int month) {
		
		// Calendar 객체 생성
		// Calendar cal = new Calendar(); X -> singlenton
		Calendar cal = Calendar.getInstance();
		
		// 달력 윗부분
		System.out.printf("\t\t%d년 %d월", year, month);
		System.out.println("\n일\t월\t화\t수\t목\t금\t토");
		
		cal.set(year, month - 1, 1);
		int start = cal.get(Calendar.DAY_OF_WEEK);
		
		for (int i = 1; i < start; i++) {
			System.out.print("\t");
		}
		
		for (int i = 1; i < cal.getActualMaximum(Calendar.DATE); i++) {
			System.out.printf("%2d\t", i);
			if (start % 7 == 0) {
				System.out.println();
			}
			start++;
		}
		
	}
}
