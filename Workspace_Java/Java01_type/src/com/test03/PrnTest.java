package com.test03;

public class PrnTest {
	
	/*
	 * System.out.print(); 줄바꿈 없음
	 * System.out.println(): 줄바꿈 포함
	 * 
	 * System.out.printf(String format, object, object, ... args)
	 * java.utill.Formatter
	 * 
	 */

	public static void main(String[] args) {
		
		int i = 100;
		
		System.out.print("1. i : \\" + i + "\n");
		System.out.println("2. i: \t" + i);
		System.out.printf("3. i : %d", i);
		System.out.println("----------------");
		
		// 시험 점수 결과는 100(su)점 이고, 학점은 'A(ch)'가 나왔다.
		// 나의 오늘 감정지수는 90.50(d)% 이다.
		
		int su = 100;         // 10자리
		char ch = 'A';        // 5자리
		double d = 90.50d;    // 5자리
		
		System.out.printf("시험 점수 결과는%10d 점 이고, 학점은 %5c 가 나왔다.\n", su, ch);
		System.out.printf("나의 오늘 감정지수는%10.2f%%이다\n", d);
		
		int age = 27;
		int m = 11;
		int day = 24;
		String name = "최봉준";
		
		System.out.printf("오늘은 %d\\%d입니다. 제 나이는 %d입니다. 제 이름은 %s입니다.", m, day, age, name);

	}

}
