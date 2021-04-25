package com.test05;

public class MTest {
	
	// School class 에 만들어 놓은 1,2,3, 메소드를 호출하여 console. 에 출력하자

	public static void main(String[] args) {
		School.namePrn("최봉준");
		
		int age = School.getAge();
		System.out.println(age + "세");
		
		School school = new School();
		school.addrPrn("여주시");

	}

}
