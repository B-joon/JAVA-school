package com.test06;

import java.util.Scanner;

public class Square extends AreaImpl {

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
		
		area = (double)(down * up);
		
		setResult(area + "");
		
		sc.close();
		
	}

	public void print() {
		
//		System.out.println("사각형 " + Area.PRINT + area);
		
		System.out.print("사각형의 ");
		super.print();
		
	}
}
