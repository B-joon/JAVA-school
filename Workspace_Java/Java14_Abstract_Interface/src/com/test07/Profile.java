package com.test07;

public class Profile {

	private String name;
	private String phone;
	
	public Profile(String name, String phone) {
		
		this.name = name;
		this.phone = phone;
	}
	
	public void print() {
		
		System.out.println("이름 : " + name);
		System.out.println("번호 : " + phone);
	}
	
}
