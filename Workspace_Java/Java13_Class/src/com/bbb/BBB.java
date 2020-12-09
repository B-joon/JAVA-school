package com.bbb;

import com.aaa.AAA;

// super : 부모 (상속 extends)
public class BBB extends AAA {
	
	public int bcd;
	
	public BBB() { // AAA먼저 호출 후 BBB 호출 ( 부모생성자를 먼저 호출 후 자식 생성자를 호풀 )
		// super();
		System.out.println("BBB 생성");
	}
	
	public BBB(int abc) {
		// 부모생성자(param) 호출
		super(abc);
		bcd = 10;
		System.out.println("BBB생성 -> abc : " + abc);
	}
	
	public BBB(int abc, int bcd) {
		super(abc);
		this.bcd = bcd;
		System.out.printf("BBB 생성 -> abc : %d, bcd : %d\n", abc, bcd);
		
	}
	
	public int getBcd() {
		
		return bcd;
	}
	
	public void setBcd(int bcd) {
		
		this.bcd = bcd;
	}
	
	public int getSum() {
		
//		int sum = super.getAbc() + this.getBcd();
		int sum = getAbc() + getBcd();
		return sum;
	}
	
	@Override // 재정의 (부모와 완전 똑같이)
	public void prn() {
		System.out.println("BBB.prn()");
	}
	
}
