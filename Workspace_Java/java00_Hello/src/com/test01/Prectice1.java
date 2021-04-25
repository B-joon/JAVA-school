package com.test01;

import java.util.Random;
import java.util.Scanner;

/*
 * 1 ~ 100 사이의 난수를 발생시켜서 우리가 입력한 크기의
 * 배열 각각에 값을 넣어두고, 배열에 담긴 난수의 총합을 구하자.
 * 
 * 만일, 0보다 작은 크기를 넣으면
 * "배열의 크기는 양수로 입력해야 합니다."
 * 
 * 0이상의 크기를 넣으면
 * "배열의 크기 입력: " 5
 * sum = ????
 */

public class Prectice1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] iarr = null;
		int sum = 0;
		
		System.out.println("배열의 크기 입력 : ");
		int size = sc.nextInt();
		
		if (size >= 0) {
			iarr = new int[size];
		} else {
			System.out.println("배열의 크기는 양수로 입력해야 합니다.");
		}
		
		for (int i = 0; i < iarr.length; i++) {
			iarr[i] = new Random().nextInt(100);
			
			// 중복 제거
			for (int j = 0; j < i; j++) {
				if (iarr[i] == iarr[j]) {
					i--;
					break;
				}
			}
		}
		
		for (int i = size; i < iarr.length; i++) {
			sum += iarr[i];
		}
		System.out.println("sum = " + sum);
	}

}