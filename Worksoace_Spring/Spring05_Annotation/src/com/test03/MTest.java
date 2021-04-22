package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		
		ApplicationContext fatory = new ClassPathXmlApplicationContext("com/test03/applicationContext.xml");
		
		TV samsong = fatory.getBean("samsong", TV.class);
		samsong.powerOn();
		samsong.volumeUp();
		samsong.volumeDown();
		samsong.powerOff();
		
		TV ig = (TV) fatory.getBean("igTV");
		ig.powerOn();
		ig.volumeUp();
		ig.volumeDown();
		ig.powerOff();
		
	}
}
