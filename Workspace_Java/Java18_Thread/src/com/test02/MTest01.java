package com.test02;

class MyCalc extends Thread {
	
	int start;
	int end;
	int sum;
	
	public MyCalc(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public void run() {
		
		sum = 0;
		for (int i = start; i <= end; i++) {
			sum += i;
			System.out.println("current Thread : " + currentThread().getName());
		}
		
	}
	
}


public class MTest01 {
	
	public static void main(String[] args) {
		
		MyCalc thread01 = new MyCalc(1, 5);
		MyCalc thread02 = new MyCalc(6, 10);
		
		thread01.start();
		thread02.start();
		
		try {
			thread01.join();
			thread02.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("thread01 sum : " + thread01.sum);
		System.out.println("thread02 sum : " + thread02.sum);
		System.out.println("Total sum : " + (thread01.sum + thread02.sum));
		
	}
	
}
