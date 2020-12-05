package com.cal02;

import java.util.Scanner;

public class MTest {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("연도를 입력해 주세요 : ");
		int year = sc.nextInt();
		System.out.println("월을 입력해 주세요 : ");
		int month = sc.nextInt();
		
		CalendarUseApi.Cal(year, month);
		
		sc.close();
	}
}
