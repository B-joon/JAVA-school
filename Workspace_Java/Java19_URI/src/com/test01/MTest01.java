package com.test01;

import java.net.URI;
import java.net.URISyntaxException;

public class MTest01 {

	public static void main(String[] args) throws URISyntaxException {
		
		URI u = new URI("http://localhost:8787/Java19_URI_Web/res.jsp?name=%EC%B5%9C%EB%B4%89%EC%A4%80&addr=%EA%B2%BD%EA%B8%B0");
		
		System.out.println(u.getScheme());
		System.out.println(u.getHost());
		System.out.println(u.getPort());
		System.out.println(u.getPath());
		System.out.println(u.getQuery());
	}
	
}
