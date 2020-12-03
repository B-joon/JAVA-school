package com.test01;

public class MTest {
	// 지역변수 : 지역변수에서는 동일한 이름으로 선언 가능
	// 왠만하면 전역변수와 지역변수의 이름을 같이 쓰지 않든다.
	// 전역변수 : 클래스 안에서 어디서든 사용할 수 있음
	//          지역변수의 이름이 같으면 "지역 변수" 가 우선
	// public static int ten = 10;
	
	// 상수 : 변수 앞에 final
	// 상수는 왼만하면 변수 이름을 대문자로 사용하여 적는다. (스네이크 표기법)
	public static final int MY_TEN = 10;

	
	public static void main(String[] args) {

		int ten = 100;
		System.out.println(ten);
		System.out.println(op01(MY_TEN,3));
		
		System.out.println(op02());
		
		op03(MY_TEN,3);
		op04();
		op05();
		
		String five = ((op05()) ? "재밌다" : "즐겁다");
		System.out.println(five);
		
		op06();
		op07();
		
		//System.out.println(op04()); <- 리턴 값이 없기 때문에 실행 할 수 없다.
		
	}
	
	public static String op01(int a , int b) {
		// 1. 사칙연산
		System.out.printf("%d + %d  = %d \n",a,b,a+b);
		System.out.printf("%d - %d  = %d \n",a,b,a-b);
		System.out.printf("%d * %d  = %d \n",a,b,a*b);
		System.out.printf("%d / %d 의 몫 : %d  나머지 : %d\n",a,b,a/b,a%b);
		return "사칙연산 끝! \n";
	}
	
	public static String op02() {
		// 2. 대입연산
		int res = 0;
		System.out.println("res : " + res);
		res = res + 10;
		System.out.println("res : " + res);
		res = res - 5;
		System.out.println("res : " + res);
		
		res += 5; // res = res + 5;
		System.out.println(res);
		
		res *= 2; // res = res * 2;
		System.out.println(res);
				

		return null;
	}
	
	public static void op03(int a, int b) {
		// 3. 증감 연산자
		// ++ / -- 
		// 변수의 앞 위에 증가/ 증감 연산자를 붙이게 되면, 변수가 가지 값을 1 씩 증가 / 증감 하게 된다.
		// 전위 연산 : 연산자를 변수 앞에 붙여서 연산을 먼저 하게 된고, 값을 나중에 리턴한다.
		// 후위 연산 : 연산자를 변수 뒤에 붙여서 값을 먼저 리턴하고, 연산을 나중에 하게 된다.
		
		System.out.println(a);			//10
		System.out.println(++a);	//11
		System.out.println(a++);	//11(12)
		System.out.println(a);			//12
		// a = 12  b = 3
		
		int result =  a++ + --b + b++ + ++a;
		// result = 12(13) + 2(2) + 2(3) + 14(14)
		// 12 + 2 + 2 + 14
		// a = 14   b = 3
		System.out.println(result);
		System.out.println("a : " + a);
		System.out.println("b : " + b);
	}
	
	public static void op04() {
		// 4. 논리 연산 : &(and), | (or), && , ||
		
		System.out.println(true & true); 		// 참 그리고 참 = > 참
		System.out.println(true & false); 		// 참 그리고 거짓 => 거짓
		System.out.println(false & true); 		// 거짓 그리고 참 => 거짓
		System.out.println(false & false); 		// 거짓 그리고 거짓 => 거짓
		
		System.out.println(true | true); 			// 참 또는 참 = > 참
		System.out.println(true | false); 			// 참 또는 거짓 = > 참
		System.out.println(false | true); 			// 거짓 또는 참 = > 참
		System.out.println(false | false); 		// 거짓 또는 거짓 = > 거짓
		
		// && 연산자의 경우 앞이 거짓이면 무조건 거짓으로 조건을 검사 하지 않는다
		System.out.println(true && true); 		// 참 그리고 참 = > 참
		System.out.println(true && false); 		// 참 그리고 거짓 => 거짓
		System.out.println(false && true); 		// 거짓 그리고 참 => 거짓
		System.out.println(false && false); 	// 거짓 그리고 거짓 => 거짓
		
		// || 의 연산자의 경우 앞이 참이면 무조건 참으로 뒤에 조건을 검사하지 않는다.
		System.out.println(true || true); 			// 참 또는 참 = > 참
		System.out.println(true || false); 		// 참 또는 거짓 = > 참
		System.out.println(false || true); 		// 거짓 또는 참 = > 참
		System.out.println(false || false); 		// 거짓 또는 거짓 = > 거짓
		
		int a = 2;
		int b = 3;
		
		System.out.println( (a > b) && (b > a)  );

		
	}
	
	public static boolean op05() {
		// 5. 삼항 연산
		// (조건) ? 참일때 리턴 값 : 거짓일 때 리턴값
		int a = MY_TEN;
		int b = 7;
		int result = (a > b) ? a -b : b - a ;
		System.out.println(result);
		
		
		String res = (a> b) ? "a가 b 보다 크다 " : "a 와 b 는 같다";
		System.out.println(res);
		
		
		return false;
	}
	
	public static void op06() {
		// 6. 비교 연산 (>,<.>=,<=,==)
		
		// 같다
		System.out.println(true == false);
		
		//같지 않다
		System.out.println(MY_TEN != 3);
	}
	
	public static void op07() {
		// 7. 비트 연산 (& , |, ^ , ~ , << , >> , ... ) : 값을 0 , 1 비트 상태에서 연산한 결과를 리턴
		
		int a = 10; 
		int b = 2;
		
		System.out.println(a & b); //=> 2
		
		System.out.println(a | b); // => 10
		
		System.out.println(~a);
		
		System.out.println("--------------------------");
		
		int c = 25;
		
		System.out.println(c >> 2 );
		System.out.println(Integer.toBinaryString(c >> 2));
		System.out.println(Integer.toBinaryString(c << 4));
		
	}
}
