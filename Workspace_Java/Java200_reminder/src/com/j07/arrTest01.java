package com.j07;

public class arrTest01 {

	public static void main(String[] args) {
		
		/*
		 * 1 1 1 1 1 
		 * 2 2 2 2 2 
		 * 3 3 3 3 3
		 * 4 4 4 4 4
		 * 5 5 5 5 5
		 */
		
		int[] arr = new int[5];
		
		int count = 1;
		
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[j] = count;
				System.out.print(arr[j]);
			}
			System.out.println();
			count++;
		}
		
		for (int i = 0; i < arr.length; i++) {
			int cnt = 1;
			for (int j = 0; j < arr.length; j++) {
				arr[j] = cnt;
				cnt++;
				System.out.print(arr[j]);
			}
			System.out.println();
		}
		
		for (int i = 0; i < arr.length; i++) {
			int cnt2 = 1;
			for (int j = 0; j < i + 1; j++) {
				arr[j] = cnt2;
				cnt2++;
				System.out.print(arr[j]);
			}
			System.out.println();
		}
		for (int i = 5; i > 0; i--) {
			int cnt = 1;
			for (int j = 0; j < i; j++) {
				arr[j] = cnt;
				cnt++;
				System.out.print(arr[j]);
			}
			System.out.println();
		}
	}
}
