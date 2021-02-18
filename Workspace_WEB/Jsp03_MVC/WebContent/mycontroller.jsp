<%@page import="com.mvc.dto.MVCBoardDto"%>
<%@page import="java.util.List"%>
<%@page import="com.mvc.biz.MVCBoardBizImpl"%>
<%@page import="com.mvc.biz.MVCBoardBiz"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

	String command = request.getParameter("command");
	System.out.printf("[%s]\n", command);
	
	MVCBoardBiz biz = new MVCBoardBizImpl();
	// 요청한 명령을 확인한다.	
	if (command.equals("list")) {
		// 1. 보내준 값이 있으면, 받는다.
		// 2. db에 전달할 값이 있으면 전달하고,
		//		없으면 없는대로 호출해서 리턴받는다.
		List<MVCBoardDto> list = biz.selectList();
		
		// 3. 화면에 전달할 값이 있으면, request 객체에 담아준다.
		request.setAttribute("list", list);
		
		// 4. 보낸다.
		pageContext.forward("mylist.jsp");
	} else if (command.equals("insertform")) {
		// 1. 
		// 2. 
		// 3. 
		
		// 4. 
		response.sendRedirect("myinsert.jsp");
		/*
			pageContext.forward() : 페이지 위임(request, response 객체가 그대로 전달)
			response.sendRedirect() : 페이지 이동 (새로운 request, response 객체)
		*/
	} else if (command.equals("insertres")) {
		
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		MVCBoardDto dto = new MVCBoardDto();
		
		dto.setWriter(writer);
		dto.setTitle(title);
		dto.setContent(content);
		
		int res = biz.insert(dto);
		
		if(res > 0) {
%>
		<script type="text/javascript">
			alert("작성 완료");
			location.href="mycontroller.jsp?command=list"
		</script>
<%
		} else {
%>		
		<script type="text/javascript">
			alert("적성 실패");
			loaction.href="mycontroller.jsp?command=insertform";
		</script>
<%
		}
	} else if (command.equals("myselect")) {
		int seq = Integer.parseInt(request.getParameter("seq"));
		MVCBoardDto dto = biz.selectOne(seq);
		
		request.setAttribute("one", dto);
		
		pageContext.forward("myselect.jsp");
	} else if (command.equals("update")) {
		int seq = Integer.parseInt(request.getParameter("seq"));
		MVCBoardDto dto = biz.selectOne(seq);
		
		request.setAttribute("one", dto);
		
		pageContext.forward("myupdate.jsp");
	} else if (command.equals("updateres")) {
		
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		MVCBoardDto dto = new MVCBoardDto();
		dto.setWriter(writer);
		dto.setTitle(title);
		dto.setContent(content);
		
		int res = biz.update(dto);
		if (res > 0) {
%>
		<script type="text/javascript">
			alert("수정 완료");
			location.href="./mycontrollrt.jsp?command=myselect&seq=<%=dto.getSeq() %>"
		</script>
<%
		} else {
%>
		<script type="text/javascript">
			alert("수정 실패");
			location.href="";
		</script>
<%
		}
	}
%>
</body>
</html>