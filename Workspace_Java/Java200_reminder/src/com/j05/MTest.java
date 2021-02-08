package com.j05;

public class MTest {

	public static void main(String[] args) {
		
		// 비버, 독수리 객체 만들어서
		// 비버 울음소리 : ??
		// 독수리 울음소리 : ??
		
		Animal be = new Beaver();
		be.bark("아악!!!!!");
		be.setKind("비버");
		be.setAge(20);
						// getKind, getAge
		System.out.println(be);
								//(setKind, setAge)
		Animal eagle = new Eagle("독수리", 20);
		eagle.bark("끼룩끼룩");
		
	}
}
