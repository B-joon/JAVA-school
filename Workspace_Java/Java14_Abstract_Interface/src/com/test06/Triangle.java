package com.test06;

import java.util.Scanner;

public class Triangle extends AreaImpl {

	private int down;
	private int up;
	private double area;
	
	@Override
	public void make() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("밑변을 입력해 주세요 : ");
		down = sc.nextInt();
		System.out.println("높이를 입력해 주세여 : ");
		up = sc.nextInt();
		
		area = (double)(down * up) / 2;
		
		sc.close();
	}

	public void print() {
		
		System.out.println("삼각형 " + Area.PRINT + area);
		
		
	}
}
