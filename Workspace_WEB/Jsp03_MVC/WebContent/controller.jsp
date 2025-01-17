<%@page import="com.mvc.dto.MVCBoardDto"%>
<%@page import="java.util.List"%>
<%@page import="com.mvc.biz.MVCBoardBizImpl"%>
<%@page import="com.mvc.biz.MVCBoardBiz"%>
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
	MVCBoardBiz biz = new MVCBoardBizImpl();
	
	if (command.equals("list")) {
		List<MVCBoardDto> list = biz.selectList();
		
		request.setAttribute("list", list);
		
		pageContext.forward("./list.jsp");
	} else if (command.equals("select")) {
		int seq = Integer.parseInt(request.getParameter("seq"));
		MVCBoardDto dto = biz.selectOne(seq);
		
		request.setAttribute("dto", dto);
		
		pageContext.forward("./select.jsp");
	} else if (command.equals("insert")) {
		pageContext.forward("./insert.jsp");
	} else if (command.equals("insertres")) {
		
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		MVCBoardDto dto = new MVCBoardDto();
		dto.setWriter(writer);
		dto.setTitle(title);
		dto.setContent(content);
		
		int res = biz.insert(dto);
		if (res > 0) {
%>
		<script type="text/javascript">
			alert("저장 완료");
			location.href="./controller.jsp?command=list";
		</script>
<%
		} else {
%>
		<script type="text/javascript">
			alert("저장 실패");
			location.href="./controller.jsp?command=insert";
		</script>
<%		
		}
		
	} else if (command.equals("update")) {
		int seq = Integer.parseInt(request.getParameter("seq"));
		MVCBoardDto dto = biz.selectOne(seq);
		
		request.setAttribute("dto", dto);
		
		pageContext.forward("./update.jsp");
	} else if (command.equals("updateres")) {
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		MVCBoardDto dto = new MVCBoardDto();
		dto.setSeq(seq);
		dto.setTitle(title);
		dto.setContent(content);
		
		int res = biz.update(dto);
		if (res > 0) {
%>
		<script type="text/javascript">
			alert("수정 성공");
			location.href="./controller.jsp?command=select&seq=<%=seq %>";
		</script>
<%
		} else {
%>
		<script type="text/javascript">
			alert("수정 실패");
			location.href="./controller.jsp?command=update&seq=<%=seq %>"
		</script>
<%
		}
	} else if (command.equals("delete")) {
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		int res = biz.delete(seq);
		if (res > 0) {
%>
		<script type="text/javascript">
			alert("삭제 성공");
			location.href="./controller.jsp?command=list";
		</script>
<%
		} else {
%>
		<script type="text/javascript">
			alert("삭제 실패");
			location.href="./controller.jsp?command=select&seq=<%=seq %>";
		</script>
<%
		}
	} else if (command.equals("muldel")) {
		String[] seqs = request.getParameterValues("chk");
		
		if (seqs.length == 0 || seqs == null) {
%>
		<script type="text/javascript">
			alert("삭제하려는 글을 한개 이상 선택해 주세요");
			location.href="./controller.jsp?command=list";
		</script>
<%
		} else {
			int res = biz.multiDelete(seqs);
			if (res > 0) {
%>
			<script type="text/javascript">
				alert("선택 삭제 성공");
				locstion.href="./controller.jsp?command=list";
			</script>
<%
			} else {
%>
			<script type="text/javascript">
				alert("선택 삭제 실패");
				location.href="./controller.jsp?command=list";
			</script>
<%
			}
		}
	}
%>
</body>
</html>