package com.edu.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
public class MyAspect {
	
	@Before("execution(public * *(..))")
	public void before() {
		System.out.println("도형의 넓이를 구한다.");
	}
//	@After("execution(public * viewSize())")
	@After("execution(public * *(..))")
	public void after() {
		System.out.println("도형의 넓이를 출력한다.");
	}
}
