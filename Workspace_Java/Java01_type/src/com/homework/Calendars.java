package com.homework;

import java.util.Calendar;

public class Calendars {

	public static void main(String[] args) {

		Calendar cal = Calendar.getInstance();
		int year = 2020;
		int month = 11;

		int today = cal.get(Calendar.DATE); //오늘
		cal.set(Calendar.YEAR, Integer.valueOf(year));
		cal.set(Calendar.MONTH, Integer.valueOf(month) - 1);// 시작일이 1이 아닌 0부터 시작이라서
		cal.set(Calendar.DAY_OF_MONTH, 1); //처음 시작 요일 설정
		int lastDay = cal.getActualMaximum(Calendar.DATE); // 당월의 마지막 날짜까지
		int week = cal.get(Calendar.DAY_OF_WEEK); //현재 요일

		System.out.println();
		System.out.println(year + "년 " + month + "월 " + today + "일");
		System.out.println("===================================================");
		System.out.println(" Sun\tMon\tTue\tWed\tThu\tFri\tSat");
		System.out.println("---------------------------------------------------");

		int i = 0;
		for (; i < week - 1; i++) {
			System.out.print("\t"); // 달력 빈공간 공백
		}

		for (int j = 1; j <= lastDay; j++, i++) { 
			if (i % 7 == 0) { //7의 배수
				System.out.println();// 달력에서 탈출하지 않게 줄바꿈
			} else if (j == today) {
				System.out.print("★"); // 오늘이 몇일인지 달력에 표시
			}
			System.out.print(j + "\t");// 1일~마지막 날까지 반복
		}
		System.out.println();
		System.out.println("===================================================");
	}

}

