package com.test06;

import org.springframework.stereotype.Component;

@Component
public class Woman implements Student {

	@Override
	public void classWork() {
		System.out.println("컴퓨터 켜서 주식본다.");
	}

}
