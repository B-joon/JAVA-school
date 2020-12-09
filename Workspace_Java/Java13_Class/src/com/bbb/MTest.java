package com.bbb;

import com.aaa.AAA;

public class MTest {
	// main method는 프로젝트에 하나만 있어야 한다.
	public static void main(String[] args) {
		
		// type 변수 = 값;
		// type 변수 = new 생성자();
		// class를 객체로 만드는것 -> new 생성자(); (instans 화)
		AAA myA = new AAA();
		myA.prn();
		// paramA = AAA class의 this.abc 이다.
		AAA paramA = new AAA(10);
		paramA.prn();
		
		System.out.println("abc : " + paramA.getAbc());
		paramA.setAbc(100);
		System.out.println("abc : " + paramA.getAbc());
		
		System.out.println("============================");
		
		BBB b1 = new BBB();
		// 자식생성자는 부모생성자를 맘대로 가져올 수 있다.
		b1.setAbc(10);
		b1.setBcd(20);
		System.out.println(b1.getSum());
		
		BBB b2 = new BBB(15);
		System.out.println(b2.getSum());
		
		BBB b3 = new BBB(20, 50);
		System.out.println(b3.getSum());
		System.out.println("=====================");
		
		AAA a1 = new AAA();
		// 부모생성자가 자식생성자보다 크기 때문에 자식을 불러올 수 있다.
		// type = super() 값 = this()
		AAA a2 = new BBB();
		a1.prn();
		a2.prn(); // 부모의 메소드를 통해 자식의 메소드가 호출된다.
		a2.getAbc();
//		a2.getBcd();            // AAA type이라서 사용 불가능
		((BBB)a2).getBcd();
		
	}
	
}
