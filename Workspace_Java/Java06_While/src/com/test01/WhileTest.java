package com.test01;

public class WhileTest {
	
	// 반복문을 사용할때는 항상 탈출할 수 있는 조건을 만들어 두자!!

	public static void main(String[] args) {
		// 1. 1 ~ 100 까지의 숫자를 역순으로 출력하자
		test01();
		// 2. 1 ~ 100 까지의 숫자 중, 2의 배수만 출력하자. hint! while () { if () {} }
		test02();
		// 3. 1 ~ 100 까지의 숫자 중 7의 배수의 갯수와, 7의 배수의 총 합을 출력하자.
		// int count = 0;
		// int sum = 0;
		
		
		test03();

	}
	
	public static void test01() {
		
		// 초기값
		int i = 100;
		
		// 조건식
		while (i > 0) {
			System.out.println(i);
			//증감식
			i--;
		}
		
//		int i = 100;   //  if를 사용했을때
//		
//		while (true) {
//			System.out.println(i);
//		
//			if (i > 0) {  // 계속 반복이 되지만 i 가 0보다 클때만 반복해라
//				break;    // break; 로 인해서 반복문 탈출
//			}
//		i--;
//		}
	}
	
	public static void test02() {
		
		// 초기값
		int i = 1;
		
		// 조건식
		//while (i < 101)
		while (i <= 100) {
			
			if (i % 2 == 0) { // 2의 배수
				System.out.println(i);
				
			}
			//증감식
			i++;
		}
	}
	
	public static void test03() {
		
		// 초기값
		int i = 1;
		int count = 0; // 배수의 갯수
		int sum = 0; // 배수의 합
		
		// 조건식
		// while (i <= 100)
		while (i < 101) {
			
			if (i % 7 == 0) { // 7의 배수
				sum += i; // 7의 배수의 합 (sum = sum + i)
				count ++; // 7의 배수의 갯수
				
			}
			// 증감식
			i ++;
			
		}
		System.out.println("7의 배수의 합은 : " + sum);
		System.out.println("7의 배수의 갯수는 : " + count);
	}

}
