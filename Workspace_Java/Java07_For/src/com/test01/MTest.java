package com.test01;

public class MTest {

	public static void main(String[] args) {
		
		// prn01();
		// prn02();
		prn03();
		

	}
	
	public static void prn01() {
		
		// for (초기값; 조건식; 증감식) {명령}
		// 순서는 초기값 -> 조건식 -> 명령 -> 증감식
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}
	}
	public static void prn02() {
		
		// 초기값을 확인하고 조건을 확인한다음 i를 출력하고 증감한다.
		for (int i = 100; i > 0; i--) { 
			System.out.println(i);
		}
	}
	
	public static void prn03() {
		
		for (int i = 0; i < 10; i++) {
			
			for (int j = 0; j < 10; j++) {
				
				System.out.printf("%d, %d\n", i, j);
			}
			System.out.println();
		}
	}
	


}
