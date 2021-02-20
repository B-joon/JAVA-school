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
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	function allChk(bool) {
		var chk = document.getElementsByName("chk");
		for (var i = 0; i < chk.length; i++) {
			chk[i].checked = bool;
		}
	}
	$(function() {
		$("#muldelform").submit(function() {
			if($("#muldelform input:checked").length == 0) {
				alert("하나 이상 선택하여 주세요.");
				
				return false;
			}
		});
	});
</script>
</head>
<body>
<%
	List<MVCBoardDto> list = (List<MVCBoardDto>) request.getAttribute("list");
%>
	<h1>목록</h1>
	<form action="controller.jsp" method="post" id="muldelform">
	<input type="hidden" name="command" value="muldel">
		<table border="1">
			<col width="25px">
			<col width="50px">
			<col width="100px">
			<col width="200px">
			<col width="100px">
			<tr>
				<th><input type="checkbox" name="all" onclick="allChk(this.checked);"></th>
				<th>번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>작성일</th>
			</tr>
<%
	if (list.size() == 0) {
%>
			<tr>
				<td colspan="5">===========작성된 글이 없습니다===========</td>
			</tr>
<%
	} else {
		for(MVCBoardDto dto : list) {
%>
			<tr>
				<td><input type="checkbox" name="chk" value="<%=dto.getSeq() %>"></td>
				<td><%=dto.getSeq() %></td>
				<td><%=dto.getWriter() %></td>
				<td><a href="./controller.jsp?command=select&seq=<%=dto.getSeq() %>"><%=dto.getTitle() %></a></td>
				<td><%=dto.getDate() %></td>
			</tr>
<%
		}
	}
%>
			<tr>
				<td colspan="5" align="right">
					<input type="submit" value="선택삭제">
					<input type="button" value="글작성" onclick="location.href='./controller.jsp?command=insert'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>