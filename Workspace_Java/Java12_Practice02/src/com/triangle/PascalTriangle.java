package com.triangle;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 			1
 * 		  1   1
 * 		1   2   1
 *    1   3   3   1
 *  1   4   6   4   1
 */

public class PascalTriangle {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("level : ");
		int n = sc.nextInt();
		
		int[][] arr = new int[n][];
		
		arr[0] = new int[] {1};
		// 작은 배열의 길이를 설정
		for (int i = 1; i < arr.length; i++) {
			arr[i] = new int[i + 1];
//			System.out.println(Arrays.deepToString(arr));
			// 배열에 값을 저장
			for (int j = 0; j < arr[i].length; j++) {
				// j가 0번째 인덱스거나 j가 마지막 인덱스 이면 1을 넣어라 
				if (j == 0 || j == arr[i].length - 1) {
					
					arr[i][j] = 1;
					
				} else {
//					 
					arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
//					System.out.print(arr[i][j]);
					
				}
			}
		}
		System.out.println();
		prn(arr);
		sc.close();
	}
	
	private static void prn(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = arr.length; j > i; j--) {
				System.out.print("  ");
			}
			
			for (int j = 0; j < arr[i].length; j++) {
				System.out.printf("%4d", arr[i][j]);
			}
			System.out.println();
		}
	}
}
