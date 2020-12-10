package com.test01;

import java.util.Vector;

public class MTest02 {

	public static void main(String[] args) {
		
		Vector<String> v = new Vector<String>();
		
		v.add("홍길동");
		v.add("이순신");
		v.add("김선달");
		v.add("강호동");
		v.add("유재석");
		v.add("신동엽");
		v.add("조세호");
		
		prn(v);
		transElement(v);
		
	}
	
	public static void prn(Vector<String> vector) {
		
		// 향상된 for문 (foreach)
		// for( 안에 있는 값을 받을 변수 : 반복 가능한 객체 )
		for(String s : vector) {
			System.out.print(s + " ");
		}
		System.out.println();
		
	}
	
	public static void transElement(Vector<String> vector) {
		
		// 1. 홍길동의 인덱스를 찾아서, 해당 인덱스의 값을 홍길순으로 바꾸자.
		vector.set(vector.indexOf("홍길동"), "홍길순");
		prn(vector);

		// 2. "~신"으로 끝나는 객체를 찾아서, 만일 있으면 "신"을 -> "자"로 바꾸자.
//		for (String s : vector) {
//			if (s.endsWith("신")) {
//				vector.set(vector.indexOf(s), s.replace("신", "자"));
//			}
//		}
//		prn(vector);
		for (int i = 0; i < vector.size(); i++) {
			if (vector.get(i).endsWith("신")) {
				vector.set(i, vector.get(i).replace("신", "자"));
			}
		}
		prn(vector);
		
		// 3. 마지막 글자가 "호"인 이름을 찾아서, 만일 있으면 삭제하자.
		for (int i = 0; i < vector.size(); i++) {
			if (vector.get(i).endsWith("호")) {
				vector.remove(vector.get(i));
			}
		}
		prn(vector);
//		for (String s : vector) {
//			if (s.endsWith("호")) {
//				vector.remove(s);
//				break;
//			}
//		}
//		prn(vector);
	}
	
}
