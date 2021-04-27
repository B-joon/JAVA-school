package com.homework;

public class Test {

	public static void main(String[] args) {

		String a = "abc";
		String b = "abc";
		String c = new String("abc");

		System.out.println(a == b);			// true
		System.out.println(a == c);			// false
		System.out.println(a.equals(b));	// true
		System.out.println(a.equals(c));	// true
	}
}

// 야구게임 숫자 3개로 10번
// 지뢰찾기 
// n 을 입력하면
// n * n 의 맵이 만들어지고, n개의 지뢰가 만들어짐
// 가로, 세로 입력해주면 해당 위치에
// 개미 수열
// java ? ~ 베운 범위까지 다 정리해서 이면지에 손으로 써서 카메라로 찍어서 제출 9시 전까지