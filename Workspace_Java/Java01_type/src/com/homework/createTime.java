package com.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class createTime {

	public static void main(String[] args) {
		
		String s = "강성필 강원기 김대진 김도한 김진현 김태린 김호수 노유섭 박성종 박은희 박정수 박찬종 박창희 소윤정 손승현 송혁중"
				+ " 이용준 이재희 이정은 임기원 장보옥 조가린 지연 차가람 최봉준 한우빈 한지연";
		
		StringTokenizer st = new StringTokenizer(s, " ");
		
		List<String> list = new ArrayList<String>();
		
		while (st.hasMoreTokens()) {
			list.add(st.nextToken());
		}
		int count = 1;
		
		Collections.shuffle(list);
		
		for (int i = 0; i < list.size(); i++) {
			if (i == 6 || i == 12) {
				System.out.println();
			} else if (i == 17 || i == 22 || i == 27) {
				System.out.println();
			}
			if (i == 0 || i == 6 || i == 12 || i == 17 || i == 22) {
				System.out.print(count + " 조 : " + list.get(i) + " ");
				count++;
			} else {
				System.out.print(list.get(i) + " ");
			}
		}
	}
}
