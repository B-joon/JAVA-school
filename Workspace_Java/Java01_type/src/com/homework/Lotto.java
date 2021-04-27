package com.homework;

import java.util.Arrays;

public class Lotto {

	public static void main(String[] args) {
		
		int[] Lotto = new int[6];
		
		for (int i = 0; i < Lotto.length; i++) {
			Lotto[i] = (int)(Math.random()*45) + 1;
			//로또 번호 생성 및 저장
			
			for (int j = 0; j < i; j++) {
				if (Lotto[i] == Lotto[j]) {
					i--;
					// 중복제거
				}
			}
		}
		
		for (int i = 0; i < Lotto.length; i++) {
			Arrays.sort(Lotto); //정렬
			System.out.print(Lotto[i] + " ");
			//로또번호 출력
		}
		
		
	}
}
