package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	//proxy:타겟인척 하는 애, 신호를 대신받아줌, 프록시가 인터셉트 해서 강탈해와서 응답해준다.
	//pointcut : 프록시객체가 어떤 조인포인트에서 신호를 강탈할 것인지 알려주는애
	//advice: target 전, 후에 공통 관심사 ccc 붙여주는 애
	//advisor(aspect):pointcut+advice
	//wening:프로그램이 묶여서 잘 실행되게 하는 것

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		
		Student m = factory.getBean("man",Student.class);
		Student w = (Student) factory.getBean("woman");
		
		System.out.println("남학생 입장");
		m.classWork();
		System.out.println("-----");
		System.out.println("여학생 입장");
		w.classWork();
		
	}
}
