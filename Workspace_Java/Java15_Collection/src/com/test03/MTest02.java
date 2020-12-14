package com.test03;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.score.Score;

public class MTest02 {

	public static void main(String[] args) {
		// Score 객체 3개를 만들자.
		// 이름은 홍길동, 이순신, 김선달. 점수는 알아서.
		Score s1 = new Score();
		s1.setName("홍길동");
		s1.setKor(100);
		s1.setEng(56);
		s1.setMath(70);
		
		Score s2 = new Score("이순신", 57, 81, 100);
		Score s3 = new Score("김선달", 79, 100, 50);
		
		//Score 객체를 관리할 수 있는 set 객체를 만들자.
		//set type에, Hashset으로 만들자.
		Set<Score> set = new HashSet<Score>();
		
		set.add(s1);
		set.add(s2);
		set.add(s3);
		set.add(new Score("샤넬", 100, 100, 100));
		
//		printCollection(set);
		transElement(set, "홍길동", 10);
		
	}
	
	public static void transElement(Set<Score> set, String target, int kor) {
		// set에서 "홍길동"을 찾아서, 국어점수를 10점을 바꾸고, 전체 출력
		// 찾을 때 iterator를 사용하자.
		
		Iterator<Score> itr = set.iterator();
		
		while (itr.hasNext()) {
//			if (itr.next().getName() == target) {
//				itr.next().setKor(kor);
//			}
			
			Score temp = itr.next();
			if (temp.getName().equals(target)) {
				temp.setKor(kor);
			}
			
		}
		// 출력
		Iterator<Score> ir = set.iterator();
		while (ir.hasNext()) {
			System.out.println(ir.next());
		}
		
	}
	
	
	public static void printCollection(Set<Score> set) {
		
		// 1.
		for (Score sc : set) {
			System.out.println(sc);
		}
		// 2.
		System.out.println("======================");
		Object[] oArr = set.toArray();
		for (int i = 0; i < oArr.length; i++) {
//			System.out.println(oArr);
//			System.out.println(oArr[i].getName());	//Object type라서 않됨
			System.out.println(((Score)oArr[i]).getName() + "\t" + String.format("%.2f",((Score)oArr[i]).getAvg()));
			
		}
		System.out.println("=======================");
		// 3. Iterator : 컬렉션프레임워크에 저장 요소를 읽어오는 표준화된 방법
		// 커서를 가지고 있다.
		Iterator<Score> iterator = set.iterator();
		// 토크나이저
		while (iterator.hasNext()) {
			// 커서를 다음칸으로 움겨준다.
			System.out.println(iterator.next());
		}
		
	}
	
}
