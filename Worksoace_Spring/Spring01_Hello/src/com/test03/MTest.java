package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		
		// 기존 방식
		// 1.
		// Resource res = new FileSystemResource("src/com/test03/beans.xml");
		
		// 2. 
		// Resource res = new ClassPathResource("com/test03/beans.xml");
		// BeanFactory factory = new XmlBeanFactory(res);
		
		// 3.
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/beans.xml");
		
		MessageBean korean = (MessageBean) factory.getBean("Korean");
		MessageBean english = (MessageBean) factory.getBean("English");
		
		korean.sayHello("스프링");
		english.sayHello("Spring");
		
	}
}

/*
 * ApplicationContext / ClassPathXmlApplicationContext
 * 
 * BeanFactory <- ApplicationContext <- ClassPathXmlApplicationContext
 * 
 * 스프링의 ApplicationContext 객체는 스프링 컨테이너의 인스턴스이다.
 * 스프링은 ApplicationContext의 몇가지 기본 구현을 제곡한다
 * 그 중 ClassPathApplicationContext는 XML 형식의 독립형 어플리케이션에 적합하다.
 * (지정된 classpath에서 xml 파일을 읽어서 스프링 컨테이너 객체 생성)
 * 
 * ------------
 * 
 * content : 기능
 * context : 가능을 구현하기위한 정보
 * container : 담는 그릇
 * 
 */