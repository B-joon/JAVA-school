package com.mvc.upgrade.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogFilter implements Filter {
	
	private Logger logger = LoggerFactory.getLogger(LogFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request; 
		
		String remoteAddr = req.getRemoteAddr();
		String uri = req.getRequestURI();
		String url = req.getRequestURL().toString();
		String queryString = req.getQueryString();
		
		String referer = req.getHeader("referer");
		String agent = req.getHeader("Uwer-Agent");
		
		StringBuffer sb = new StringBuffer();
		sb.append("\n remoteAddr : " + remoteAddr) // ip주소
		  .append("\n uri" + uri) // 경로		http요청 url중에 쿼리스트링 까지 반환.(context path)
		  .append("\n url" + url) // 주소		protocol + servername + portnumber + serverpath
		  .append("\n queryString" + queryString) // 쿼리스트링
		  .append("\n referer" + referer) // 이전페이지(보내는 페이지) url (getHeader : 지정한 요청 헤더값을 문자열로 반환)
		  .append("\n agent" + agent) // 사용자 정보 (browser version, os등)
		  .append("\n");
		
		logger.info("\nLOG Filter" + sb);
		
		chain.doFilter(req, response);
		// 다음 필터가 존재하면 그 필터가 실행될 수 있도록 / request에 있는 정보를 읽어서 log.info
	}

	@Override
	public void destroy() {
		
	}

}
