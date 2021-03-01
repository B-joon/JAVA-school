package com.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.biz.MVCBoardBiz;
import com.mvc.biz.MVCBoardBizImpl;
import com.mvc.dto.MVCBoardDto;

/**
 * Servlet implementation class MVCController
 */
@WebServlet("/MVCController")
public class MVCController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MVCController() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		MVCBoardBiz biz = new MVCBoardBizImpl();
		String command = request.getParameter("command");
		
		if (command.equals("list")) {
			List<MVCBoardDto> list = biz.selectList();
			
			request.setAttribute("list", list);
			
			dispatch(request, response, "mvclist.jsp");
		} else if (command.equals("select")) {
			
			int seq = Integer.parseInt(request.getParameter("seq"));
			
			MVCBoardDto dto = biz.selectOne(seq);
			
			request.setAttribute("dto", dto);
			
			dispatch(request, response, "mvcselect.jsp");
		} else if (command.equals("update")) {
			 
			int seq = Integer.parseInt(request.getParameter("seq"));
			
			MVCBoardDto dto = biz.selectOne(seq);
			
			request.setAttribute("dto", dto);
			
			dispatch(request, response, "mvcupdate.jsp");
		} else if (command.equals("updateres")) {
			
			int seq = Integer.parseInt(request.getParameter("seq"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			MVCBoardDto dto = new MVCBoardDto(seq, null, title, content, null);
			
			PrintWriter out = response.getWriter();
			
			int res = biz.update(dto);
			if (res > 0) {
				String str = "<script type='text/javascript'>"
						+ "alert('수정 성공');"
						+ "location.href='mvc.do?command=select&seq="+ seq +"'"
						+ "</script>";
				out.print(str);
			} else {
				String str = "<script type='text/javascript'>"
						+ "alert('수정 실패');"
						+ "location.href='mvc.do?command=select&seq="+ seq +"'"
						+ "</script>";
				out.print(str);
			}
			
		} else if (command.equals("insert")) {
			dispatch(request, response, "mvcinsert.jsp");
		} else if (command.equals("insertres")) {
			String writer = request.getParameter("writer");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			MVCBoardDto dto = new MVCBoardDto();
			dto.setWriter(writer);
			dto.setTitle(title);
			dto.setContent(content);
			
			PrintWriter out = response.getWriter();
			
			int res = biz.insert(dto);
			if (res > 0) {
				String str = "<script type='text/javascript'>"
						+ "alert('저장 성공');"
						+ "location.href='mvc.do?command=list'"
						+ "</script>";
				out.print(str);
			} else {
				String str = "<script type='text/javascript'>"
						+ "alert('저장 실패');"
						+ "location.href='mvc.do?command=insert'"
						+ "</script>";
				out.print(str);
			}
		} else if (command.equals("delete")) {
			int seq = Integer.parseInt(request.getParameter("seq"));
			PrintWriter out = response.getWriter();
			int res = biz.delete(seq);
			if (res > 0) {
				String str = "<script type='text/javascript'>"
						+ "alert('삭제 성공');"
						+ "location.href='mvc.do?command=list'"
						+ "</script>";
				out.print(str);
			} else {
				String str = "<script type='text/javascript'>"
						+ "alert('삭제 성공');"
						+ "location.href='mvc.do?command=select&seq="+seq+"'"
						+ "</script>";
				out.print(str);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void dispatch(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

}
