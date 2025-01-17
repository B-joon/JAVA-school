package com.test02;

public class Gugudan {

	public static void main(String[] args) {
		
		// 1. 2단 부터 9단까지 전체 출력
		gugu01();
		
		// 2. 아규먼트로 들어온 값의 단만 출력
		gugu02(5);
		
		guguWhile01();
		
		guguWhile02(5);

	}
	
	public static void gugu01() {
		// 1번 for를 실행하면 중괄호 안에 있는 2번 for를 실행
		// 2번 for가 명령을 완료하면 처음으로 돌아와서 다시 1번이 실행 됨
		// 이 과정이 1번 for에 조건이 만족될때까지 반복됨
		for (int i = 2; i < 10; i++) { // 1번 for // 반복시작 <i단>을 출력하고 2번 for로 감
			System.out.printf("< %d 단 >\n", i);
			for (int j = 1; j < 10; j++) { // 2번 for // 1 ~ 9까지 출력을 하고 1번 for로 다시 감 (이 과정을 총 8번 반복)
				System.out.printf("%d * %d = %d\n", i, j, (i * j)); 
			}
			System.out.println();
		}
	}
	
	public static void gugu02(int dan) {
		
		for (int i = dan; i == dan; i++) {
			System.out.printf("< %d 단 >\n", dan);
			for (int j = 1; j < 10; j++) {
				System.out.printf("%d * %d = %d\n", dan, j, (dan * j));
			}
			System.out.println();
		}
	}
	public static void guguWhile01() {
		
		int i = 2;
		while (i < 10) {
			System.out.printf("< %d 단 >\n", i);
			
			int j = 1;
			while (j < 10) {
				System.out.printf("%d * %d = %d\n", i, j, (i * j));
				j++;
			}
			i++;
		}
		
	}
	
	public static void guguWhile02(int dan) {
		
		int i = dan;
		
		while (i == dan) {
			System.out.printf("< %d 단 >\n", dan);
			int j = 1;
			while (j < 10) {
				System.out.printf("%d * %d = %d\n", dan, j, (dan * j));
				j++;
			}
			i++;
		}
	}

}
