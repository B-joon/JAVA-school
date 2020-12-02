package com.test03;

public class ArrCube01 {
	
	/*
	 * 1 4 7
	 * 2 5 8
	 * 3 6 9
	 * 
	 * 모양의 이차원 배열을 만들어서 출력하자
	 */

	public static void main(String[] args) {
		
		int[][] arr = new int[3][3];
		
		
		
		for (int i = 0; i < 3; i++) {
			int a = 1;
			for (int j = 0; j < 3; j++) {
				arr[i][j] = a + i;
				System.out.printf("%2d", arr[i][j]);
				a += 3;
			}
			
			
			System.out.println();
		}

	}

}
