package com.mvc.upgrade.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {
	
	private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("[Interceptor] : preHandle");
		
		// spring 3.2 이상부터는 servlet-context.xml에서 <exclude-mapping-path>를 사용하여 설정 가능
		if (request.getRequestURI().contains("/loginform.do") || 
			request.getRequestURI().contains("/ajaxlogin.do") || 
			request.getRequestURI().contains("/test.do")) {
			return true;
		}
		if (request.getSession().getAttribute("login") != null) {
			return true;
		} else if (request.getSession().getAttribute("login") == null) {
			return false;
		}
		
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("[Interceptor] : postHandle");
		
		if (modelAndView != null) {
			// 어떤 뷰가 응답하는지 볼 수 있다.
			logger.info("[interseptor] : " + modelAndView.getViewName());
		}
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("[Interceptor] : afterCompletion");
	}

}
