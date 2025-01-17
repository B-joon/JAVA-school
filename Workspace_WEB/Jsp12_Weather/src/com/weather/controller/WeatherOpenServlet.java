package com.weather.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/weatherOpen")
public class WeatherOpenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String code = request.getParameter("code");
		request.setAttribute("code",code);
		RequestDispatcher rd = request.getRequestDispatcher("weatherInfo.jsp");
		rd.forward(request, response);
		
	}
	// jstl : Jsp Standard Tag Library -> 표준 태그 모음집
	// c:~ -> core library
	// x:~ -> xml library => apach xalan.jar.com
}
