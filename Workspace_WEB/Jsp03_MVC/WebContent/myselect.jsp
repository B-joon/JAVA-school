<%@page import="com.mvc.dto.MVCBoardDto"%>
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
	MVCBoardDto dto = (MVCBoardDto) request.getAttribute("one");
%>
	
	<h1>SELECT</h1>
	
	<table border="1">
		<tr>
			<th>작성자</th>
			<td><%=dto.getWriter() %></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><%=dto.getTitle() %></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="10" cols="60" readonly="readonly"><%=dto.getContent() %></textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="button" value="수정" onclick="location.href='./mycontroller.jsp?command=update&seq=<%=dto.getSeq() %>'">
				<input type="button" value="삭제" onclick="location.href='./mycontroller.jsp?command=delete&seq=<%=dto.getSeq() %>'">
				<input type="button" value="목록" onclick="location.href='./mycontroller.jsp?command=list'">
			</td>
		</tr>
	</table>
	
</body>
</html>