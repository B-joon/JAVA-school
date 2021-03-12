<%@page import="com.muldel.biz.MDBoardBizImpl"%>
<%@page import="com.muldel.biz.MDBoardBiz"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String[] seqs = request.getParameterValues("chk");
	if (seqs == null || seqs.length == 0) {
%>
	<script type="text/javascript">
		alert("삭제할 글을 선택하여 주세요");
		location.href="boardlist.jsp";
	</script>
<%
	} else {
		MDBoardBiz biz = new MDBoardBizImpl();
		int res = biz.multiDelete(seqs);
		if(res > 0) {
%>
		<script type="text/javascript">
			alert("선택한 글 삭제를 성공하였습니다.");
			location.href="boardlist.jsp";
		</script>
<%
		} else {
%>
		<script type="text/javascript">
			alert("선택한 글 삭제를 실패하였습니다.");
			location.href="boardlist.jsp";
		</script>
<%
		}
	}
%>
</body>
</html>