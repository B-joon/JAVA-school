package com.test02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MTest {

	public static void main(String[] args) {

		int a = 0;
		
		int result = 1 / a;

		try {
			System.out.println("숫자를 입력해 주세요.");
			Scanner sc = new Scanner(System.in);
			a = sc.nextInt();
			
			if (a == 100) {
				// throw : 예외를 발생시킴
				throw new MyException();
			}
			
			if (a == 66) {
				throw new InputMismatchException();
			}
			
		} catch (InputMismatchException e) {
//			e.printStackTrace();
			System.out.println("숫자만 입력해 주세요.");
			
		} catch (MyException e) {
			System.out.println("100을 입력하셨습니다.");
			
		// 예외중에 가장 큰 예외가 Exception 이라서 위 에러들이 없어도 동작한다.	
		} catch (Exception e) {
			System.out.println("예외가 발생했습니다.");
		}
		System.out.println(a);

	}

}
