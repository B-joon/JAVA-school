package com.test02;

public class Dog extends Animal {

	public Dog() {
		
		System.out.println("멍멍이");
	}
	
	public void bark() {
		
		super.bark();
		System.out.println("멍멍");
	}
	
}
