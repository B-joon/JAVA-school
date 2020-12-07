package com.cal01;

import java.util.Scanner;

public class MTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("연도를 입력하세요 :");
		int year = sc.nextInt();
		System.out.println("월을 입력하세요 : ");
		int month = sc.nextInt();
		
		DayOfCalendar.prn(year, month);
		
//		int week = DayOfCalendar.Week(year);
//		int lastDay = DayOfCalendar.LastDay(year, month);
//		DayOfCalendar.isLeapYear(year);
//		
//		System.out.println();
//		System.out.println(year + "년 " + month + "월 ");
//		System.out.println("===================================================");
//		System.out.println(" Sun\tMon\tTue\tWed\tThu\tFri\tSat");
//		System.out.println("---------------------------------------------------");
//
//		for (int i = 0; i < week; i++) {
//			System.out.print("\t");
//		}
//		
//		for (int j = 1; j <= lastDay; j++) {
//			if (week % 7 == 0) {
//				System.out.println();
//			}
//			week++;
//			System.out.printf("%2d\t", j);
//		}
//		System.out.println();
//		System.out.println("---------------------------------------------------");

		sc.close();
	}
	

}
