package com.test04;

public class Student {

	public static int getSum(int kor, int eng, int math) {
		int result = kor + eng + math;
		

		return result;
	}

	public static double getAvg(double sum) {
		double result = sum / 3;

		return result;
	}

	public static void main(String[] args) {
		
		/*
		 * 1. 과목 파라미터 세게를 넣어주면 총점을 리턴하는 getSum 
		 * 이라는 이름의 메서드를 만들자. 2. 총 합 파라미터 한개를 가진
		 * getAvg라는 이름의 메서드를 만드는데, 리턴은 평균을 리턴한다. 
		 * 3. main 메서드에서 위의 메서드들을 호출하여 각각 sum 변수와
		 * avg변수에 리턴되는 값을 담고, 해당 변수들을 출력하자.
		 * 
		 * +평균은 소수점 둘째짜리까지만 호출
		 */
		
		int kor, eng, math;
		kor = eng = math = 0;

		kor = 100;
		eng = 40;
		math = 79;

		int sum = 0;
		double avg = 0;

		sum = getSum(kor, eng, math);
		System.out.println(sum);
		
		avg = getAvg(sum);
		System.out.printf("%2.2f",avg);


	}

}
