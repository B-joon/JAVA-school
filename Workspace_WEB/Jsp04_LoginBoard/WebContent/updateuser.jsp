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
	MYMemberDto dto = (MYMemberDto) request.getAttribute("dto");
%>
	
	<form action="./logincontroller.jsp">
		<input type="hidden" name="command" value="updateres">
		<input type="hidden" name="myno" value="<%=dto.getMyno() %>">
		<table border="1">
			<tr>
				<th>비밀번호</th>
				<td><input type="text" name="mypw" value="<%=dto.getMypw() %>"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="myname" value="<%=dto.getMyname() %>"></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="myaddr" value="<%=dto.getMyaddr() %>"></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="text" name="myphone" value="<%=dto.getMyphone() %>"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="myemail" value="<%=dto.getMyemail() %>"></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="수정">
					<input type="button" value="취소" onclick="location.href='./logincontroller.jsp?command=select&myno=<%=dto.getMyno() %>'">
				</td>
			</tr>
		</table>
	</form>
	
</body>
</html>