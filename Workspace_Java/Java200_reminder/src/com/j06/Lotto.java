package com.j06;

import java.util.Arrays;
import java.util.Random;

public class Lotto {

	public static void main(String[] args) {
		
		int[] lotto = new int[6];
		// index = 0~5
		// length = 1~6
		// (int)(Math.random());
		for (int i = 0; i < lotto.length; i++) { // 0 ,1 ,2 ,3 ,4 ,5
			lotto[i] = (int)(Math.random()*45) + 1;
			for (int j = 0; j < i; j++) {
				if (lotto[i] == lotto[j]) {
					i--;
				}
			}
			System.out.print(lotto[i] + " ");
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		Random rd = new Random();
//
//		int[] lotto = new int[6];
//
//		for (int i = 0; i < lotto.length; i++) {
//			lotto[i] = rd.nextInt(45) + 1;
//			for (int j = 0; j < i; j++) {
//				if (lotto[i] == lotto[j]) {
//					i--;
//				}
//			}
//		}
//		int tmp = 0;
//
//		for (int i = 0; i < lotto.length; i++) {
//			for (int j = 0; j < lotto.length; j++) {
//				if (lotto[i] < lotto[j]) {
//					tmp = lotto[i];
//					lotto[i] = lotto[j];
//					lotto[j] = tmp;
//				}
//			}
//		}
//		System.out.println(Arrays.toString(lotto));
	}
}
