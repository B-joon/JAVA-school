package com.test01;

import java.util.Arrays;

public class MTest03 {
	/*
	 * 1)
	 * a b c d e f
	 * g h i j k l
	 * m n o p q r
	 * s t u v w x
	 * y z
	 * 출력
	 * 
	 * 단, 일차원 배열(char[])에, 반복문을 사용하여 알파벳을 저장한 후에 출력하자.
	 * 
	 * char[] ar = {'a', 'b', 'c', ...} 금지
	 * 
	 */

	public static void main(String[] args) {
		
		char[] ch = new char[26];
		int count = 0;
		
		for (int i = 0; i < ch.length; i++) {
			ch[i] = (char)('a' + i);
		}
		System.out.println(Arrays.toString(ch));
		
		for (int i = 1; i <= ch.length; i++) {
			System.out.print(ch[i-1] + " ");
			if (i % 6 == 0) {
				System.out.println();
			}
		}
		System.out.println();
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.printf("%s ",ch[count]);
				count++;
				if (count == ch.length) {
					break;
				}
			}
			System.out.println();
		}
		System.out.println();
		
		
		// 2) 1번에서 만든 배열을 거꾸로 출력하자.
		int tmp = 1;
		
		for (int i = ch.length; i > 0; i--) {
			System.out.print(ch[i-1] + " ");
			if (tmp % 6 == 0) {
				System.out.println();
			}
			tmp++;
		}
		System.out.println();
		System.out.println();
		
		count = ch.length - 1;
		
		for (int i = 5; i > 0 ; i--) {
			for (int j = 6; j > 0; j--) {
				System.out.print(ch[count] + " ");
				count--;
				if (count < 0) {
					break;
				}
			}
			System.out.println();
		}
		System.out.println();
		
		// 3) 1번에서 만든 배열을 대문자로 바꾸어 출력
		
		int cnt = 1;
		for (int i = 0; i < ch.length; i++) {
//			ch[i] = Character.toUpperCase(ch[i]);
//			System.out.printf("%s ", ch[i]);
			System.out.print((char)(ch[i] - 32));
			
			if (cnt % 6 == 0) {
				System.out.println();
			}
			cnt++;
		}
		System.out.println();
		System.out.println();
		for (int i = 0; i < ch.length; i++) {
			ch[i] = (char) ('A' + i);
			System.out.print(ch[i] + " ");
		}
		
		
		

	}

}
