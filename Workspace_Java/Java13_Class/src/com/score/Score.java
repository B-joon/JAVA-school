package com.score;

public class Score {
	
	// field
	private String name;
	private int kor;
	private int eng;
	private int math;

	// constructor (습관적으로 만들자)
	public Score() {
		
	}
	// overload
	public Score(String name, int kor, int eng, int math) {
		
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	// getter & setter
	
	public String getName() {
		
		return name;
	}
	
	public String setName(String name) {
		
		return this.name = name;
	}
	
	public int getKor() {
		
		return kor;
	}
	
	public int setKor(int kor) {
		
		return this.kor = kor;
	}
	
	public int getEng() {
		
		return eng;
	}
	
	public int setEng(int eng) {
		
		return this.eng = eng;
	}
	
	public int getMath() {
		
		return math;
	}
	
	public int setMath(int math) {
		
		return this.math = math;
	}
	
	
	// getSum, getAvg, getGrade
	public int getSum() {
		
		return kor + eng + math;
	}
	
	public double getAvg() {
		
		return (double)(kor + eng + math) / 3;
	}
	
	public String getGrade() {
		String grade = null;
		// 100 ~ 90 : A, 80 ~ 89 : B, 70 ~ 79 : c, 60 ~ 69 : D, 0 ~ 59 : F
		
		switch((int)getAvg() / 10) {
		case 10: case 9:
			grade = "A";
			break;
		case 8:
			grade = "B";
			break;
		case 7:
			grade = "C";
			break;
		case 6:
			grade = "D";
			break;
		default :
			grade = "F";
		}
		
		return grade;
	}
	
	@Override // 재정의 완벽하게 똑같지 않으면 Override를 사용할 수 없다.
	public String toString() {
		
		return "이름 : " + name + " 국어 : " + kor + " 영어 : " + eng + " 수학 : " + math
				+ "\n총점 : " + getSum() + " 평균 : " + getAvg() + " 등급 : " + getGrade();
	}
	
}
