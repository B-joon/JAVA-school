package com.test05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test05/applicationContext.xml");
		
		Student w = factory.getBean("woman", Student.class);
		Student m = (Student) factory.getBean("man");
		
		System.out.println("여학생 입장");
		w.classWork();
		System.out.println("-----");
		System.out.println("남학생 입장");
		m.classWork();
	}
}
