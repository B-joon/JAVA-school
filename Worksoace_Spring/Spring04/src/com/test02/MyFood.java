package com.test02;

public class MyFood {

	private Food favoriteFood;
	private Food unFavoriteFood;

	public MyFood() {

	}

	public MyFood(Food favoriteFood, Food urFavoriteFood) {
		super();
		this.favoriteFood = favoriteFood;
		this.unFavoriteFood = urFavoriteFood;
	}

	public Food getFavoriteFood() {
		return favoriteFood;
	}

	public void setFavoriteFood(Food favoriteFood) {
		this.favoriteFood = favoriteFood;
	}

	public Food getUrFavoriteFood() {
		return unFavoriteFood;
	}

	public void setUrFavoriteFood(Food urFavoriteFood) {
		this.unFavoriteFood = urFavoriteFood;
	}

	@Override
	public String toString() {
		return "favorite : " + favoriteFood + "\nunfavorite : " + unFavoriteFood;
	}

}
