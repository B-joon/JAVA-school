package com.homework;

import java.util.Calendar;
import java.util.Scanner;

public class Calendars1 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Calendar cal = Calendar.getInstance();

		System.out.print("년도를 입력해 주세요 :");
		int year = scan.nextInt(); // 년도 입력
		System.out.print("월을 입력해 주세요 :");
		int month = scan.nextInt(); // 월 입력
		scan.close();

		cal.set(Calendar.YEAR, Integer.valueOf(year)); // 입력한 값을 input 받아서 저장
		cal.set(Calendar.MONTH, Integer.valueOf(month) - 1);// 시작일이 1이 아닌 0부터 시작이라서 , 입력한 값을 input 받아서 저장
		cal.set(Calendar.DAY_OF_MONTH, 1); // 처음 시작요일 설정
		int week = cal.get(Calendar.DAY_OF_WEEK); 
		int lastDay = cal.getActualMaximum(Calendar.DATE);// 월의 마지막 날짜


		System.out.println();
		System.out.println(year + "년 " + month + "월 ");
		System.out.println("===================================================");
		System.out.println(" Sun\tMon\tTue\tWed\tThu\tFri\tSat");
		System.out.println("---------------------------------------------------");

		int i = 0;

		for (; i < week - 1; i++) {
			System.out.print("\t"); // 달력 공백

		}

		for(int j = 1; j <= lastDay; j++,i++){ // 1일 ~ 마지막날까지 반복
			if(i % 7 ==0){ // 7의 배수
				System.out.println(); //줄바꿈

			}
			System.out.print(j + "\t"); 
		}
		System.out.println();
		System.out.println("===================================================");

		
	}
	
}
