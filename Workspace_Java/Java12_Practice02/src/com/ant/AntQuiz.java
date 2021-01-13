package com.ant;

import java.util.Scanner;


/*
 * 1
 * 1 1
 * 1 2
 * 1 1 2 1
 * 1 2 2 1 1 1
 * 1 1 2 2 1 3
 * 1 2 2 2 1 1 3 1 
 * 1 1 2 3 1 2 3 1 1 1
 * 1 2 2 1 3 1 1 1 2 1 3 1 1 3
 */

public class AntQuiz {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Line : ");
		int line = sc.nextInt();

		String start = "1";
		String next = "";
		
		for (int i = 0; i < line; i++) {
			System.out.println(start);
			next = nextLine(start);
			start = next;
			
		}
		sc.close();
		
	}
	
	public static String nextLine (String line) { // 출력

		
		String next = "";
		
		for (int i = 0; i < line.length(); i++) {
			if (i > 0) {
				if (line.charAt(i - 1) == line.charAt(i)) {
					continue;
				}
			}
			next += numberCut(line, i);
		}
		
		
		return next;
	}
	
	public static String numberCut (String nLine, int index) { // 계산
		
		char str = nLine.charAt(index);
		int count = 0;
		for (int i = index; i < nLine.length(); i++) {
			if (str == nLine.charAt(i)) {
				count++;
			} else {
				break;
			}
		}
		
		return str + Integer.toString(count);
	}
	
}
