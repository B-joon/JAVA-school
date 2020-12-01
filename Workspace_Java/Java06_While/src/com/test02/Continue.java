package com.test02;

public class Continue {

	public static void main(String[] args) {
		prn();

	}
	public static void prn() {
		
		int i = 0;
		
		while (i < 10) {
			i++;
			if (i % 2 == 0) {
				continue; // 조건을 무시하고 넘어가라
			}
			System.out.println(i);
		}
	}

}
