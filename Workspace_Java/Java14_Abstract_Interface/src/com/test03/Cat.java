package com.test03;

// extends : class -> class 를 상속받을때
// implements : class -> interface를 상속 받을때
public class Cat implements Animal {

	@Override
	public void bark() {
		
		System.out.println("야옹");

	}

	@Override
	public void eat(String feed) {
		System.out.println("고양이가 " + feed + " 먹는다.");

	}

}
