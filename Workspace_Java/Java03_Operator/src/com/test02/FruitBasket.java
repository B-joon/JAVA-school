package com.test02;

public class FruitBasket {

	//class 변수
	static int basketSize = 30;
	//instance 변수
	int count = 10;
	String fruitName;

	public static void main(String[] args) {
		

	}
	public void basketSetting(String name, int fruit) {
		fruitName = name;
		count += fruit;
		
		basketPrn();
	}
	public void basketPrn() {
		
		System.out.println("바구니 안의 과일 : " + fruitName);
		
		
		String res = (basketSize >= count) ? fruitName + "의 갯수는 " + count + "입니다." : "바구니가 넘쳤습니다.";
		System.out.println(res);
		
	}

}
