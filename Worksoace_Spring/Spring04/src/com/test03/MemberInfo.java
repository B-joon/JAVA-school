package com.test03;

import java.util.Locale;

/*
 * MessageSourceAware는 번들이 지정된 properties 파일을 setMessageSource()로 전달한다.
 *  -> 메세지 국제화를 위해 사용
 *  
 *  ResourceBundleMessageSource 의 setBeanName()을 통해 전달받은 파일을,
 *  setMessageSource()를 자동으로 호출하여 매핑하는 역할을 한다.
 *  
 *  ResouceBundleMessageSource와 MessageSourceAware는 쌍으로 사용한다.
 */

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;

public class MemberInfo implements MessageSourceAware {
	
	private MessageSource message;

	@Override
	public void setMessageSource(MessageSource messageSource) {
		
		System.out.println("컨테이너가 메세지 설정을 수행중...");
		this.message = messageSource;
		
	}
	
	public void display(Locale locale) {
		String name = message.getMessage("member.name", null, locale);
		String birthplace = message.getMessage("member.birthplace", null, locale);
		String hobby = message.getMessage("member.hobby", null, locale);
		String age = message.getMessage("member.age", new Object[] {"13"}, locale);
		
		System.out.println(locale);
		System.out.println(name);
		System.out.println(birthplace);
		System.out.println(hobby);
		System.out.println(age);
	}

}
