package com.test03;

public class MyCalc {

	// 접근제한자 메모리영역 리턴타입 메소드명 (파라미터)

	// 더하기
	public static int sum(int i, int j) {
		System.out.print("i : " + i + "\t j : " + j + "\t result : ");
		int result = i + j;

		return result;
	}
	// 빼기
	public static void sub(int i, int j) {
		int result = i - j;
		System.out.printf("%d - %d = %d\n", i, j, result);
	}
	// 곱하기
	public static double mul(double d1, double d2) {

		double result = d1 * d2;

		return result;
	}
	// 나누기
	public void div(int i, int j) {
		// '/' : 나눈 값
		int div01 = i / j;
		
		// '%' : 나머지
		int div02 = i % j;
		
		System.out.printf("%d / %d = %d\n", i, j, div01);
		System.out.printf("%d %% %d = %d\n", i, j, div02);
	}

	public static void main(String[] args) {

		// 접근제한자 메모리영역 리턴타입 메소드명 (파라미터)
		// 더하기
		// 빼기
		// 곱하기
		// 나누기

	}

}
