<%@page import="com.mvc.dto.MVCBoardDto"%>
<%@page import="java.util.List"%>
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
	// 작은거에서 큰거는 묵시적 형변환, 큰거에서 작은거는 명시적 형변환
	List<MVCBoardDto> list = (List<MVCBoardDto>) request.getAttribute("list");
%>

	<h1>List</h1>

	<table border="1">
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>적성일</th>
		</tr>
		
<%
	for (MVCBoardDto dto : list) {
%>
		<tr>
			<td><%=dto.getSeq() %></td>
			<td><%=dto.getWriter() %></td>
			<td><a href="./mycontroller.jsp?command=myselect&seq=<%=dto.getSeq() %>"><%=dto.getTitle() %></a></td>
			<td><%=dto.getDate() %></td>
		</tr>
<%
	}
%>
		<tr>
			<td colspan="4" align="right">
				<input type="button" value="글작성" onclick="location.href='./mycontroller.jsp?command=insertform'">
			</td>
		</tr>
	</table>

</body>
</html>