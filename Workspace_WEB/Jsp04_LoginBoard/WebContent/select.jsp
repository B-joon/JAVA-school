<%@page import="com.login.dto.MYMemberDto"%>
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
	String command = request.getParameter("command");
%>

	<h1>회원 전체 조회(탈퇴한 회원 포함)</h1>
	
	<table border="1">
		<col width="50px">
		<col width="100px">
		<col width="100px">
		<col width="100px">
		<col width="500px">
		<col width="200px">
		<col width="200px">
		<col width="50px">
		<col width="100px">
		<tr>
			<th>번호</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>주소</th>
			<th>폰번호</th>
			<th>이메일</th>
			<th>가입여부</th>
			<th>등급</th>
		</tr>
<%
	if (command.equals("all")) {
		List<MYMemberDto> list = (List<MYMemberDto>) request.getAttribute("list");
		for (MYMemberDto dto : list) {
%>
		<tr>
			<td><%=dto.getMyno() %></td>
			<td><%=dto.getMyid() %></td>
			<td><%=dto.getMypw() %></td>
			<td><%=dto.getMyname() %></td>
			<td><%=dto.getMyaddr() %></td>
			<td><%=dto.getMyphone() %></td>
			<td><%=dto.getMyemail() %></td>
			<td><%=dto.getMyenable() %></td>
			<td><%=dto.getMyrole() %></td>
		</tr>
<%
		}
	} else if (command.equals("yes")) {
		List<MYMemberDto> list1 = (List<MYMemberDto>) request.getAttribute("yes");
		for (MYMemberDto dto : list1) {
%>
		<tr>
			<td><%=dto.getMyno() %></td>
			<td><%=dto.getMyid() %></td>
			<td><%=dto.getMypw() %></td>
			<td><%=dto.getMyname() %></td>
			<td><%=dto.getMyaddr() %></td>
			<td><%=dto.getMyphone() %></td>
			<td><%=dto.getMyemail() %></td>
			<td><%=dto.getMyenable() %></td>
			<td><%=dto.getMyrole() %></td>
		</tr>
<%
		}
	}
%>
	</table>

</body>
</html>