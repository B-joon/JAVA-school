<%@page import="java.util.List"%>
<%@page import="com.myboard.dao.MyBoardDao"%>
<%@page import="com.myboard.dto.MyBoardDto"%>
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
	MyBoardDao dao = new MyBoardDao();
	List<MyBoardDto> list = dao.selectList();
%>
	<h1>전체글</h1>
	
	<table border="1">
		<col width="50px"/>
		<col width="100px"/>
		<col width="300px"/>
		<col width="100px"/>
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>날짜</th>
		</tr>
<%
	for(int i = 0; i < list.size(); i++) {
%>
		<tr>
			<td><%=list.get(i).getSeq() %></td>
			<td><%=list.get(i).getWriter() %></td>
			<td><a href="./myselect.jsp?seq=<%=list.get(i).getSeq() %>"><%=list.get(i).getTitle() %></a></td>
			<td><%=list.get(i).getDate() %></td>
		</tr>
<%
	}
%>
		<tr>
			<td colspan="4" align="right">
				<input type="button" value="글쓰기" onclick="location.href='./myinsert.jsp'">
			</td>
		</tr>
	</table>
	
</body>
</html>