<%@page import="com.myboard.dto.MyBoardDto"%>
<%@page import="com.myboard.dao.MyBoardDao"%>
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
<% 
	// request.getParameter(key) : queryString으로 넘어온 key=value 의 형태에서, 넣어준 key에 맞는 valye return
	int myno = Integer.parseInt(request.getParameter("myno"));
	MyBoardDao dao = new MyBoardDao();
	MyBoardDto dto = dao.selectOne(myno);

%>
<body>

	<h1>글 수정하기</h1>
	
	
	<!-- 글 작성할 때 post인 이유 : queryString이 허용범위 이상으로 길어지면, request 불가!! -->
	<form action="myupdate_res.jsp" method="post">
		<table border="1">
			<tr>
				<th>작성자</th>
				<td><input type="text" name="myname" value="<%=dto.getMyname() %>"/></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="mytitle" value="<%=dto.getMytitle() %>"/></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="60" name="mycontent"><%=dto.getMycontent() %></textarea></td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="수정"/>
					<input type="button" value="취소" onclick="location.href='./myselect.jsp'"/>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>