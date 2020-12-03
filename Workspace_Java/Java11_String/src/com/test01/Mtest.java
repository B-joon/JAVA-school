package com.test01;

import java.util.Arrays;

public class Mtest {
	
	private static String str = "     The String class represents character strings.     ";

	public static void main(String[] args) {
		// immutable : 변하지 않는다.
		
		// String을 기본타입으로 쓰면 String pool이 생성되서
		// 기본타입끼라 같이 쓴다.
		
		// String을 new 참조타입으로 사용하면 새로운 객체를
		// 생성해서 사용한다.
		
		// equals는 주소값이 아닌 값을 비교한다.
//		String s = "Hello";
//		System.out.println(s + 1 + 2);  // Hello12
//		System.out.println(1 + 2 + s);  // 3Hello
//		System.out.println(s); // Hello
//		
////		s = 1 + 2 + s;
////		System.out.println(s);
////		
////		String h = "Hello";
////		System.out.println(h);
////		
////		String newS = new String("Hello");
////		System.out.println(newS);
//		
//		String h = "Hello";
//		System.out.println(h);
//		
//		System.out.println(s == h);
//		
//		String newS = new String("Hello");
//		System.out.println(newS);
//		
//		System.out.println(s == newS);
//		
//		System.out.println("----------------------------");
		
		// 1. str의 길이
		test01();
		
		// 2. str 전체 대문자
		test02();
		
		// 3. str 전체 소문자
		test03();
		// 4. str에서 첫번째 나오는 c의 위치(인덱스)
		test04();
		// 5. class 단어를 찾아서 java 로 바꿔서
		test05();
		// 6. character 단어를 찾아서 대문자로 변환 후, 전체 출력
		test06();
		// 7. str을 char[]로 출력하되, 'c' 만 출력하자.
		// 그리고, c의 갯수를 출력
		test07();
		// 8. str을 char[]로 출력하괴 대문자만 출력하자
		// 그리고, 대문자의 갯수를 출력
		test08();
		// 9. str 사이의 공백 제거 후 출력
		test09();
		// 10. 전체를 역순으로 출력.
		test10();
	}

	private static void test10() {
		
		int arrIndex = 0;
		
		char[] ch = new char[str.length()];
		
		for (int i = str.length() - 1; i > 0; i--) {
			ch[i] = str.charAt(arrIndex);
			arrIndex++;
			
		}
		System.out.println(ch);
//		String[] a = str.split("");
//		System.out.print("10. 역순으로 출력 : ");
//		for (int i = a.length - 1; i >= 0; i--) {
//			System.out.print(a[i]);
//		}
//		System.out.println();
//		System.out.println();
	}

	private static void test09() {
		
//		System.out.println(str.trim()); // 문장의 앞과 뒤의 공백을 지운다.
//		System.out.println(str.replace(" ", ""));
		String[] a = str.split(" ");
		System.out.print("9. 공백 제거 : ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
		System.out.println();
		System.out.println();
	}

	private static void test08() {
		
		char[] ch = str.toCharArray();
		int count = 0;
		System.out.print("8. 대문자만 출력 : ");
		for (int i = 0; i < ch.length; i++) {
			// ch[i] -> "char" -> isUpperCase();
			if (Character.isUpperCase(ch[i])) {
				System.out.printf("%c", ch[i]);
				count++;
			}
		}
		System.out.println("\n   대문자의 갯수 : " + count);
//		char[] c = new char[26];
//		
//		for (int j = 0; j < c.length; j++) {
//			c[j] = (char)('A' + j);
//			System.out.print(c[j]);
//		}
//		for (int i = 0; i < ch.length; i++) {
//			
//		}
		
		

		System.out.println();
	}

	private static void test07() {

		char[] ch = str.toCharArray();
		int cnt = 0;
		System.out.print("7. c만 출력하세요 :");
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == 'c' || ch[i] == 'C') {
				System.out.print(ch[i] + " ");
				cnt++;
			}
		}
		System.out.println("\n   c의 갯수는 :" + cnt);
		System.out.println();
		
	}

	private static void test06() {
		
		String target = "character";
		int start = str.indexOf(target);
		int end = start + target.length();
		String upper = str.substring(start, end);
		
		// 대문자 변환
		upper = upper.toUpperCase();
		
		//출력
		System.out.println(str.replace(target, upper));
		
		//------------------------------------
		String a = str.replace("character", "CHARACTER");
		System.out.println("6. character을 대문자로 변경 : " +a);
		
		
		
//		String[] a = str.split(" ");
//		System.out.print("6. character을 대문자로 변경 : ");
//		for (int i = 0; i < a.length; i++) {
//			if (a[i].equals("character")) {
//				System.out.print(a[i].toUpperCase() + " ");
//			} else {
//				System.out.print(a[i] + " ");
//			}
//
//		}
//		System.out.println();
	}

	private static void test05() {
		
		System.out.println("5. java 를 class 로 변경 : " + str.replace("class", "java"));
		System.out.println();
	}

	private static void test04() {
		
		System.out.println("4. c의 위치" + str.indexOf("c"));
		System.out.println();
	}

	private static void test03() {
		
		System.out.println("3. 소문자 : " + str.toLowerCase());
		System.out.println();
	}

	private static void test02() {
		
		System.out.println("2. 대문자 : " + str.toUpperCase());
		System.out.println();
	}

	private static void test01() {
		
		System.out.println("1. 길이 : " + str.length());
		System.out.println();
	}

}
