package com.test01;

class MyThread03 extends Thread {
	
	public MyThread03(String name) {
		
		super(name);
	}
	
	@Override
	public void run() {
		
		for (int i = 0; i < 1000; i++) {
			System.out.println(this.getName() + " : " + i);
		}
		System.out.println(this.getName() + "끝 !!!!!!!!!!!!!!");
	}
	
}

public class Thread03 {

	public static void main(String[] args) {
		
		MyThread03 dog = new MyThread03("멍멍");
		MyThread03 cat = new MyThread03("야옹");
		// 													시간 마다
		// java의 thread scheduling은 우선순위(priority)와 순환할당(round-robin) 방식을
		// 사용한다.
		
		// priority : 우선순위
		// 우선순위가 높다고 해서 먼저 끝나지 않는다.
		dog.setPriority(10);
		cat.setPriority(Thread.MIN_PRIORITY);
		
		dog.start();
		cat.start();
		
		
		
	}
	
}
