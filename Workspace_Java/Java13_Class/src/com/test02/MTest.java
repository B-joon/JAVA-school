package com.test02;

public class MTest {
	
	public static void main(String[] args) {
		
//		Cat cat = new Cat();
//		Dog dog = new Dog();
//		
//		cat.bark();
//		dog.bark();
		
		// super type에 this 객체를 넣어서 호출
		Animal animal = new Dog();
		animal.bark();
		
		animal = new Cat();
		animal.bark();
		
		// instanceof : 해당 타입의 객체인지 아닌지 판별
		// 왼쪽의 객체가 오른쪽 클레스 타입이 맞는지 아닌지 확인
		if (animal instanceof Dog) {
			System.out.println("멍멍이다!");
			
		} else if (animal instanceof Cat) {
			System.out.println("야옹이다!");
		}
		
		/*
		 * 다형성
		 * 1. 부모의 타입으로 자식 생성
		 * Parent p  = new Child();
		 * 
		 * 2. 부모의 이름으로 자식 대입
		 * Child c = new Child();
		 * Parent p = c;
		 * 
		 * 3. 부모의 메서드를 통해 자식의 메서드 호출
		 * 
		 * 같은 부모를 상속받은 자식 클래스는, 컴파일시 형변환이 가능한 것처험 작성되지만,
		 * 실행시(runtime)시 ClassCastException을 발생시킴.
		 */
		
	}

}
