<%@page import="com.muldel.dto.MDBoardDto"%>
<%@page import="java.util.List"%>
<%@page import="com.muldel.biz.MDBoardBizImpl"%>
<%@page import="com.muldel.biz.MDBoardBiz"%>
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
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
	<script type="text/javascript">
		$(function() {
			$("#muldelform").submit(function() {
				if($("#muldelform").length == 0) {
					alert("하나이상 선택해 주세요");
					
					return false;
				}
			});
		});
	</script>
</head>
<%
	MDBoardBiz biz = new MDBoardBizImpl();
	List<MDBoardDto> list = biz.selectList();
%>
<body>

	<%@ include file="./form/header.jsp" %>
	
	<h1>목록</h1>
	
	<form action="./muldel.jsp" method="post" id="muldelform">
		<table border="1">
			<col width="25px">
			<col width="50px">
			<col width="100px">
			<col width="300px">
			<col width="100px">
			<tr>
				<th><input type="checkbox" name="all" onclick="allChk(this.checked);"></th>
				<th>번호</th>
				<th>작성자</th>
				<th>내용</th>
				<th>날짜</th>
			</tr>
<%
	if (list.size() == 0) {
%>
			<tr>
				<td colspan="5">-------------작성된 글이 없습니다---------------</td>
			</tr>
<%
	} else {
		for (MDBoardDto dto : list) {
%>
			<tr>
				<td><input type="checkbox" name="chk" value="<%=dto.getSeq() %>"></td>
				<td><%=dto.getSeq() %></td>
				<td><%=dto.getWriter() %></td>
				<td><a href="./boardselect.jsp?seq=<%=dto.getSeq() %>"><%=dto.getTitle() %></a></td>
				<td><%=dto.getDate() %></td>
			</tr>
<%
		}
	}
%>
			<tr>
				<td colspan="5" align="right">
					<input type="submit" value="선택삭제">
					<input type="button" value="글작성" onclick="location.href='./boardinsert.jsp'">
				</td>
			</tr>
		</table>
	</form>
	
	<%@ include file="./form/footer.jsp" %>

</body>
</html>