package com.test02;

public class MTest {

	public static void main(String[] args) {
		
		FruitBasket bananaBasket = new FruitBasket();
		bananaBasket.basketSetting("바나나", 10);
		System.out.println(bananaBasket.fruitName);
		
		bananaBasket.basketSize = 15;
		System.out.println(bananaBasket.basketSize);
		
		
		FruitBasket appBasket = new FruitBasket();
		appBasket.basketSetting("사과", 21);
		System.out.println(appBasket.basketSize);
		System.out.println(appBasket.fruitName);

	}

}
