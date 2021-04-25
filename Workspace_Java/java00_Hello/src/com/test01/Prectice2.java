package com.test01;

import java.util.Date;

public class Prectice2 {
	
	public static void main(String[] args) {
		
		Object[] array = new Object[5];
		
		array[0] = null;
		array[1] = new Date();
		array[2] = "apple";
		array[3] = "banana";
		array[4] = new Integer(1);
		
		for (int i = 0; i < array.length; i++) {
			Object tmp = array[i];
			char c = ((String)tmp).charAt(0);
			System.out.println(c);
			
		}
		
	}

}
