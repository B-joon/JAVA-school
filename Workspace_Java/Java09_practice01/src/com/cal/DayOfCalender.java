package com.cal;

import java.util.Scanner;

// 달력 만들어 주세요. -> 연 월 일 받으면 해당 연 월 일의 요일을 출력
// java.util.Calender
public class DayOfCalender {
	
	public static boolean isLeepYear(int year) {
		
		boolean isLeep = false;
		
		if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
			isLeep = true;
		}
		
		return isLeep;
	}
	
	public static int getDates(int year, int month) {
		
		int result = 0;
		
		if (isLeepYear(year)) {
			switch (month) {//윤년
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				result = 31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				result = 30;
				break;
			case 2:
				result = 29;
				break;
			}
		} else {// 평년
			if (month == 1 || month  == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
				result = 31;
			} else if (month == 4 || month == 6 || month == 9 || month == 11) {
				result = 30;
			} else if (month == 2) {
				result = 28;
			}
		}
		
		return result;
	}
	
	public static String dayCharacter(int day) {
		
		switch (day) { // 일주일
		case 0:
			return "일요일";
		case 1:
			return "월요일";
		case 2:
			return "화요일";
		case 3:
			return "수요일";
		case 4:
			return "목요일";
		case 5:
			return "금요일";
		case 6:
			return "토요일";
		}
		
		return null;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("연도 입력 : ");
		int year = sc.nextInt();
		System.out.println("월 입력 : ");
		int month = sc.nextInt();
		System.out.println("일 입력 : ");
		int day = sc.nextInt();
		
		int sum = 0;
		// 전 연도까지
		for (int i = 1; i < year; i++) {
			for (int j = 1; j <= 12; j++) {
				sum += getDates(i, j);
				System.out.println(sum);
			}
		}
		// 어제까지
		for (int k = 1; k < month; k++) {
			sum += getDates(year, k);
//			System.out.println(sum);
		}
//																						일주일
		System.out.printf("%d 년 %d 월 %d 일은 %s 입니다.", year, month, day, dayCharacter((sum + day) % 7));
//
//		Scanner sc = new Scanner(System.in);
//
//		System.out.print("년 : ");
//		int year = sc.nextInt();
//		System.out.print("\n월 : (ex/1 ~ 12)");
//		int month = sc.nextInt();
//
//		System.out.println();
//		System.out.println(year + "년 " + month + "월 ");
//		System.out.println("===================================================");
//		System.out.println(" Sun\tMon\tTue\tWed\tThu\tFri\tSat");
//		System.out.println("---------------------------------------------------");
//
//		int lastYear = year - 1;
//		int totalDay = (lastYear * 365) + (lastYear / 4) - (lastYear / 100) + (lastYear / 400);
//		int week = totalDay % 7;
//
//		if (month > 12) {
//			System.out.println("월을 다시 입력해주세요.");
//			month = sc.nextInt();
//		}
//		
//		for (int i = 0; i < week; i++) {
//			System.out.print("\t");
//		}
//		
//		int lastDay = 1;
//
//		if (month == 4 || month == 6 || month == 9 || month == 11) {
//			lastDay = 30;
//			
//		} else if (month == 2) {
//			lastDay = LeapYear.isLeapYear(year) ? 29 : 28;
//			
//		} else {
//			lastDay = 31;
//		}
//
//		for (int j = 1; j <= lastDay; j++) {
//			
//			if (week % 7 == 0) {
//				System.out.println();
//			}
//			week++;
//			System.out.printf("%d\t", j);
//		}
//		System.out.println();
//		System.out.println("===================================================");
//
		sc.close();
	}


}
