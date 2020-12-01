package com.test01;

public class MethodTest02 {

	public static void main(String[] args) {
		// method 호출 방법
		// 1. static method : class.method();
		MethodTest01.publicMethod();
		MethodTest01.protectedMethod();
		MethodTest01.defaultMethod();
//		MethodTest01.privateMethod();     // private method 해당 class 내에서만 (not visible)
//		MethodTest01.abc();               // abc는 없다 (undefined)
		
		// 2. non-static method
		// class(참조타임) 변수 = new class();
		// 변수.method();
		//   타입       변수     =        값
		MethodTest01 method01 = new MethodTest01();
		method01.nonStaticMethod();
		
		// objectaid
		// UML : Unified Modeling Language
	}

}
