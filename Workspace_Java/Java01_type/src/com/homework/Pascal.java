package com.homework;

import java.util.Scanner;

public class Pascal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("단계를 입력하세요 : ");
		int n = sc.nextInt();

		int[] a = new int[n];

		a[0] = 1;

		for(int line = 0; line < n; line++) {
			for(int z = line; z > 0; z--) {
				//System.out.print(j);
				
				a[z] = a[z] + a[z-1];
				System.out.print(a[z]);
				

			}

			for(int j = 0; j < a.length; j++) {

				//System.out.print(" " + a[j]);

			}

			System.out.println();

		}sc.close();

	}

}
