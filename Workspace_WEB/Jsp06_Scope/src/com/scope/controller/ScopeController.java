package com.scope.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ScopeController
 */
@WebServlet("/ScopeController")
public class ScopeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScopeController() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get방식으로 들어오던 post로 들어오던 get방식으로 할것이다.
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		// 1. 이거는 왜 null인지
		// 값을 담아두기만 해서 (getter, setter)
		String requestId = request.getAttribute("requestId") + "";
		HttpSession session = request.getSession();
		String SessionId = session.getAttribute("sessionId") + "";
		ServletContext application = getServletContext();
		String applicationId = application.getAttribute("applicationId") + "";
		
		System.out.println("requestId : " + requestId);
		System.out.println("sessionId : " + SessionId);
		System.out.println("applicationId : " + applicationId);
		// 4. 콘솔에는 뜨는데 왜 페이지에는 null인지
		// 값을 전달해주지 않아서
		String myRequest = request.getParameter("myRequest");
		System.out.println("myRequest : " + myRequest);
		
		// 2. 이거는 왜 null이 안나오는가
		// 이거는 그냥 값을 전달
		PrintWriter out = response.getWriter();
		String html = "<h1>응답</h1>"
				+ "<table border='1'>"
					+ "<tr>"
						+ "<th>request</th>"
//						+ "<td>" + requestId + "</td>"
						+ "<td>" + myRequest + "</td>"
					+ "</tr>"
					+ "<tr>"
						+ "<th>session</th>"
						+ "<td>" + SessionId + "</td>"
					+ "</tr>"
					+ "<tr>"
						+ "<th>application</th>"
						+ "<td>" + applicationId + "</td>"
					+ "</tr>"
				+ "</table>";
		out.println(html);
		
//		String test = request.getParameter("mytest");
//		System.out.println("test : " + test);
		
		request.setAttribute("myRequest", "servlet에서 보냄");
		// 3. 이것은 뭐하는 놈인가
		// request와 response를 전달
		RequestDispatcher dispatch = request.getRequestDispatcher("result.jsp");
		dispatch.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
