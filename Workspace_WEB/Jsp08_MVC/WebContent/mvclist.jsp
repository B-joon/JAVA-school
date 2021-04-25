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

	<h1>LIST</h1>
	
	<form action="mvc.do" method="post" id="muldelform">
		<input type="hidden" name="all" onclick="allCheck(this.checked);">
		<table border="1">
			<col width="25">
			<col width="50">
			<col width="100">
			<col width="300">
			<col width="100">
			<tr>
				<th></th>
		</table>
	</form>

</body>
</html>