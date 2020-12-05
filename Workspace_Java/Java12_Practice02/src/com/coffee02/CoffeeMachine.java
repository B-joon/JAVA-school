package com.coffee02;

import java.util.Scanner;

public class CoffeeMachine {

	public void intputMoney() {
		
		System.out.println("돈을 넣어 주세요");
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		
		System.out.println("몇 잔을 만들까요? ( 정수만 입력 )");
		int coffee = sc.nextInt();
		
		coffeeMake(money, coffee);
		sc.close();
	}
	
	private void coffeeMake(int money, int coffee) {
		
		int change = money - (coffee * 300);
		
		if (change >= 0) {
			System.out.printf("커피 %d 잔 나왔습니다. \n잔돈은 %d 원 입니다.\n", coffee, change);
		} else {
			System.out.printf("금액이 부족합니다. \n 잔돈은 %d 원 입니다.\n", money);
		}
	}
}
