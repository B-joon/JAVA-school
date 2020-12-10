package com.test07;
//              자식              부모                   스승
public class MyProfile extends Profile implements Job, Display {

	private String loc;
	
	// 생성자 profile 을 상속 받아서 name와 phone를 가져와!
	public MyProfile(String name, String phone) {
		// 부모클래스로 보낸다.
		super(name, phone);
		
	}

	// Display에서 display를 상속받아서 재정의 해!
	@Override
	public void display() {
		// 부모클래스 호출
		super.print();
		System.out.println("주소 : " + loc);
		System.out.println("직종 : " + JOB_ID);

	}

	// setter랑 비슷하다.
	// Job에서 jobLoc을 상속받아서 재정의 해!
	@Override
	public void jobLoc(String loc) {
		// 값 초기화
		this.loc = loc;

	}

}
