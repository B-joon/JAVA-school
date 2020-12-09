package com.test01;

public class MTest {
	
	public static void main(String[] args) {
		
		AA a = new AA();
		Super s = a; 		// Super s에 a가 가진 new AA()한 "instance"의 주소값 대입
		// 자식 생성자에서 부모 생성자로 형변환은 가능하지만 
		// 자식생성자에서 자식생성자로 형변환은 불가능 하다. 부모생성자에서 자식생성자으로도 불가능하다
		BB b = (BB) s;		// s에 담긴 AA instance를 BB로 형변환
		
		System.out.println(a.hashCode());
		System.out.println(s.hashCode());
	}

}
