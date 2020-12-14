package com.test01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionCal {

	public int calculation() {

		int res = 0;
		
		while(true) {
			try {
				res = inputNum() / inputNum();
				break;
				
			} catch (InputMismatchException e) {
//				 e.printStackTrace(); // 
				System.out.println("잘봇 입력하셨습니다. 숫자만 입력해 주세요.");
				
			} catch (ArithmeticException e) {
				System.out.println("0으로 나누면 안됩니다. 다시 입력해 주세요.");
				
			}finally {
				System.out.println("계산 완료");
			}
			
//			System.out.println(res);
		}




		return res;
	}

	public int inputNum() {

		int n = 0;
		System.out.println("숫자만 입력하세요:");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		return n;
	}

}
