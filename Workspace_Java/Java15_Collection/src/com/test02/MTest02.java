package com.test02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MTest02 {

	public static void main(String[] args) {
		// 사전식 : 문자열 정렬
		List<String> list = new ArrayList<String>();
		
		for (int i = 11; i > 0; i--) {
			list.add(i + "");
		}
		
		System.out.println(list);
		Collections.sort(list, new MySort());
		System.out.println(list);
	}
	
}

// 2번째 class는 public을 쓸 수 없다
class MySort implements Comparator<String> {

	/*
	 * 1이면 앞의 인자가 더 큰값
	 * 0이면 같은 값
	 * -1이면 뒤의 인자가 더 큰값
	 */
	
	
	@Override
	public int compare(String o1, String o2) {
		
		int tmp1 = Integer.parseInt(o1);
		int tmp2 = Integer.parseInt(o2);
		
		// 작은순 부터 큰순으로 정렬
		if (tmp1 > tmp2) {
			return 1;
		} else if (tmp1 < tmp2) {
			return -1;
		}
		return 0;
	}
}