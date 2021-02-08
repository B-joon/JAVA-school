package com.j05;

public class Animal {

	// int num = 1; // 선언한다, 초기화한다.
	private String kind;
	private int age;
	
	public Animal() { // 기본생성자
		
	}
	
	public Animal(String kind, int age) { // 생성자
		this.kind = kind;
		this.age = age;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void bark(String bark) {
		System.out.println(kind +" 울음소리 : " + bark);
	}
	
	@Override
	public String toString() {
		
		return "나이는 : " + age + "\n동물은 : " + kind;
	}
}
