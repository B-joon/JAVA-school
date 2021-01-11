package com.test02;

import java.util.Scanner;

public class MTest {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("매뉴 선택");
		int select = sc.nextInt();

		switch (select) {
		case 1:
			selectList();
			break;
		case 2:
			selectOne();
			break;
		case 3:
			insert();
			break;
		case 4:
			update();
			break;
		case 5:
			delete();
			break;
		default:
			System.out.println("종료");
		}

	}
	
	public static void selectList() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void selectOne() {
		
	}
	
	public static void insert() {
		
	}
	
	public static void update() {
		
	}
	
	public static void delete() {
		
	}
}
