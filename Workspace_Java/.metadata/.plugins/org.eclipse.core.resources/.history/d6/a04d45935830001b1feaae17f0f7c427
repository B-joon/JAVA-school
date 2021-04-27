package com.test02;

/*
 * A B C D E
 * F G H I J
 * K L M N O
 * P Q R S T
 * U V W X Y
 * Z
 */

public class BreakTest {

	public static void main(String[] args) {
		prn();

	}
	
	public static void prn() {
		
		int count = 0;
		char c = 'A';
		boolean stop = false;
		
		// 조건문 앞에 !를 붙이면 값이 반대가 된다.
		while (!stop) { // 1번 while  // !stop은 true 값이 되서 반복문을 실행한다.
			while (true) { // 2번 while // 반복문 실행
				System.out.print(c + " "); // 알파벳을 출력
				c++; // A에 해당되는 숫자를 증가시킴 (ASKII 코드 참조)
				count++; // count를 증가시킴
				
				if (count % 5 == 0) { // count가 5의 배수때마다 2번 while문을 종료함
					break;            // break; 이 실행되서 1번 while문으로 돌아가서 다시 반복
				}
				if (count == 26) { 
					stop = true; // count가 26이 되면 boolean stop = false;<< false가 ture로 바뀜
					break; // while (!stop) true의 반대이므로 1번 반복문이 종료됨
				}
			}
			System.out.println(); // while (true) 이 종료되었을때 줄바꿈
			
			
		}
	}

}
