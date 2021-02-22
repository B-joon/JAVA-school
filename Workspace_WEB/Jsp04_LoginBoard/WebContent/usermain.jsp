<%@page import="com.login.dto.MYMemberDto"%>
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
	MYMemberDto dto = (MYMemberDto)session.getAttribute("dto");
%>
	<div>
		<span><%=dto.getMyid() %>님 환영합니다.</span>
		<a href="logincontroller.jsp?command=logout">logout</a>
	</div>
	
	<div>
		<div>
			<a href="logincontroller.jsp?command=select&myno=<%=dto.getMyno() %>">회원 정보 보기</a>
		</div>
		<div>
			<a href="logincontroller.jsp?command=delete&myno=<%=dto.getMyno() %>">회원 탈퇴</a>
		</div>
	</div>
	
</body>
</html>