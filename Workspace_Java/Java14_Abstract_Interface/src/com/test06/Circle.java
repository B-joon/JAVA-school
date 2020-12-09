package com.test06;

import java.util.Scanner;

public class Circle extends AreaImpl {

	private double radius;
	private double area;
	
	@Override
	public void make() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("반지름을 입력해 주세요 : ");
		radius = sc.nextInt();

		area = radius * radius * Math.PI;
		
		sc.close();
		
	}

	public void print() {
		
		System.out.println("원의 " + Area.PRINT + area);
		
	}
}
