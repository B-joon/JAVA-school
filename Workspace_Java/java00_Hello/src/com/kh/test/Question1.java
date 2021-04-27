package com.kh.test;

import java.util.Scanner;

public class Question1 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("가위 바위 보 게임을 시작합니다.");
		
		do {
			System.out.print("가위 바위 보 중 한 개를 입력하세요 : ");
			String input = sc.nextLine();
			
			System.out.println("당신은 " + input + "를 냈습니다.");
			
			int random = (int)(Math.random() * 3);
			String computer = "";
			
			switch (random) {
			case 0: computer = "가위"; break;
			case 1: computer = "바위"; break;
			case 2: computer = "보"; break;
			
			}
			
			System.out.println("컴퓨터는 " + computer + "를 냈습니다.");
			if (input == computer) {
				System.out.println("비겼습니다. 다시 시작합니다.");
				
			} else {
				
				if (computer.equals("가위")) {
					if (input.equals("바위")) {
						System.out.println("당신이 이겼습니다!");
					}
					
				} else if (computer.equals("바위")) {
					if (input.equals("보")) {
						System.out.println("당신이 이겼습니다!");
					}
				} else if (computer.equals("보")){
					if (input.equals("가위")) {
						System.out.println("당신이 이겼습니다!");
					}
				} else {
					System.out.println("당신이 졌습니다!");
				}
				
			}
			
		} while (false);
		
	}
	
}
