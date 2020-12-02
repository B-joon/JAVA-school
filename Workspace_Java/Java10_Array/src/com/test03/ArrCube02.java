package com.test03;


public class ArrCube02 {
	/*
	 * 1  2  3  4  5
	 * 10 9  8  7  6
	 * 11 12 13 14 15
	 * 20 19 18 17 16
	 * 21 22 23 24 25
	 * 
	 * 모양의 이차원 배열을 만들어서 출력하자
	 */
	public static void main(String[] args) {
		
		int[][] arr = new int[5][5];
		int up = 0;
		int down = 0;
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				up++;
				if (i == 1 || i == 3) {
					down = up + 4;
					arr[i][j] = down;
					System.out.printf("%3d", arr[i][j]);
					down--;
				} else {
					arr[i][j] = up;
					System.out.printf("%3d", arr[i][j]);
				}
			}
			System.out.println();
		}
	}
}
