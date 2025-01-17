package com.test02;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class RandomCube {

	public static void main(String[] args) {
		/*
		 * 1 ~ 9 사이의 난수로 이루어진
		 * 5 * 5 형태의 숫자들을 출력하고,
		 * 전체 난수의 합,
		 * 전체 난수의 평균,
		 * x의 합을 구하자
		 */
		prnCube();

	}
	
	public static void prnCube() {
		
//		Random ran = new Random();
//		
//		int sum = 0;
//		int sumX = 0;
//		int count = 0;
//		
//		for (int i = 0; i < 5; i++) {
//			for (int j = 0; j < 5; j++) {
//				int r = ran.nextInt(10);
//				System.out.printf("%2d",r);
//				sum += r;
//				if (i == j || i + j == 4) {
//					sumX += r;
//					count++;
//				}
//			}
//			System.out.println();
//			
//		}
//		float avg = (float) sum / count;
//		System.out.printf("난수의 합 : %d\n",sum);
//		System.out.printf("난수의 평균 : %.2f\n", avg);
//		System.out.println("X의 합 : " + sumX);
		
		int ranSum = 0;
		int ranCount = 0;
		double ranAvg = 0;
		int xSum = 0;
		
		for (int i = 0; i < 5; i++) {
			
			for (int j = 0; j < 5; j++) {
				// 난수 발생
				// 1 ~ 9 : (int)(Math.random()*(9 - 1 + 1)) + 1
				int random = (int) (Math.random()*(9))+1;
				System.out.printf("%2d", random);
				// 전체 합
				ranSum += random;
				// 난수의 개수
				ranCount++;
				// x의 합
				if (i == j || i + j == 4) {
					// xSum = xSum + random;
					xSum += random;
				}
			}
			System.out.println();
		}
		ranAvg = (double) ranSum / ranCount;
		
		System.out.println("전체 난수의 합 : " + ranSum);
		System.out.println("전체 난수의 평균 : " + ranAvg);
		System.out.println("X의 합 : " + xSum);
		
	}

}
