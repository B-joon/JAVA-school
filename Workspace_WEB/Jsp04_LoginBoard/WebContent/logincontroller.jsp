<%@page import="java.util.List"%>
<%@page import="com.login.dto.MYMemberDto"%>
<%@page import="com.login.biz.MYMemberBiz"%>
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
	System.out.println("[" + command + "]");
	
	MYMemberBiz biz = new MYMemberBiz();
	if (command.equals("login")) {
		String myid = request.getParameter("myid");
		String mypw = request.getParameter("mypw");
		
		MYMemberDto dto = biz.login(myid, mypw);
		
		if (dto != null) {
			// session scope에 객체 담기
			// session을 사용하면 send 했을때 값을 줄수 있다.
			session.setAttribute("dto", dto);
			// 만료되는 시간 설정 (default: 30분)
			session.setMaxInactiveInterval(10 * 60);
			
			if(dto.getMyrole().equals("ADMIN")) {
				response.sendRedirect("adminmain.jsp");
			} else if (dto.getMyrole().equals("USER")) {
				response.sendRedirect("usermain.jsp");
			}
		} else {
%>
		<script type="text/javascript">
			alert("로그인 실패");
			location.href="index.html";
		</script>
<%
		}
	} else if (command.equals("listall")) {
		List<MYMemberDto> list = biz.selectAllUser();
		
		request.setAttribute("list", list);
		
		pageContext.forward("userlistall.jsp");
		
	} else if (command.equals("listen")) {
		List<MYMemberDto> list = biz.selectEnabledUser();
		
		request.setAttribute("list", list);
		
		pageContext.forward("userlisten.jsp");
		
	} else if (command.equals("insert")) {
		pageContext.forward("./regist.jsp");
		
	} else if (command.equals("logout")) {
		// session scope에서 값 삭제 (만료)
		session.invalidate();
		response.sendRedirect("index.html");
		
	} else if (command.equals("updateform")) {
		int myno = Integer.parseInt(request.getParameter("myno"));
		
		MYMemberDto dto = biz.selectUser(myno);
		
		request.setAttribute("dto", dto);
		
		pageContext.forward("updaterole.jsp");
		
	} else if (command.equals("updaterole")) {
		int myno = Integer.parseInt(request.getParameter("myno"));
		String myrole = request.getParameter("myrole");
		
		int res = biz.updateRole(myno, myrole);
		if (res > 0) {
%>
		<script type="text/javascript">
			alert("등급 변경 성공");
			location.href="logincontroller.jsp?command=listen";
		</script>
<%
		} else {
%>
		<script type="text/javascript">
			alert("등급 변경 성공");
			location.href="logincontroller.jsp?command=updateform&myno=<%=myno %>";
		</script>
<%
		}
%>
<%
	}  else if (command.equals("registform")) {
		response.sendRedirect("regist.jsp");
	} else if (command.equals("idchk")) {
		String myid = request.getParameter("myid");
		
		MYMemberDto dto = biz.idCheck(myid);
		
		boolean idnotused = true;
		
		if (dto.getMyid() != null) {
			idnotused = false;
		}
		response.sendRedirect("idchk.jsp?idnotused="+idnotused);
	} else if (command.equals("insertuser")) {
		String myid = request.getParameter("myid");
		String mypw = request.getParameter("mypw");
		String myname = request.getParameter("myname");
		String myaddr = request.getParameter("myaddr");
		String myphone = request.getParameter("myphone");
		String myemail = request.getParameter("myemail");
		
		MYMemberDto dto = new MYMemberDto();
		dto.setMyid(myid);
		dto.setMypw(mypw);
		dto.setMyname(myname);
		dto.setMyaddr(myaddr);
		dto.setMyphone(myphone);
		dto.setMyemail(myemail);
		
		int res = biz.insertUser(dto);
		
		if (res > 0) {
%>
		<script type="text/javascript">
			alert("회원가입이 완료 되었습니다.");
			location.href="./index.html";
		</script>
<%
		} else {
%>
		<script type="text/javascript">
			alert("회원가입이 실패 되었습니다.");
			location.href="./logincontroller.jsp?command=registform";
		</script>
<%
		}
	} else if (command.equals("update")) {
		int myno = Integer.parseInt(request.getParameter("myno"));
		MYMemberDto dto = biz.selectUser(myno);
		
		request.setAttribute("dto", dto);
		
		pageContext.forward("./updateuser.jsp");
	} else if (command.equals("select")) {
		int myno = Integer.parseInt(request.getParameter("myno"));
		
		MYMemberDto dto = biz.selectUser(myno);
		
		request.setAttribute("dto", dto);
		
		pageContext.forward("./selectuser.jsp");
	} else if (command.equals("updateres")) {
		int myno = Integer.parseInt(request.getParameter("myno"));
		String mypw = request.getParameter("mypw");
		String myname = request.getParameter("myname");
		String myaddr = request.getParameter("myaddr");
		String myphone = request.getParameter("myphone");
		String myemail = request.getParameter("myemail");
		
		MYMemberDto dto = new MYMemberDto();
		dto.setMyno(myno);
		dto.setMypw(mypw);
		dto.setMyname(myname);
		dto.setMyaddr(myaddr);
		dto.setMyphone(myphone);
		dto.setMyemail(myemail);
		
		int res = biz.updateUser(dto);
		if (res > 0) {
%>
		<script type="text/javascript">
			alert("정보 수정 성공");
			location.href="./logincontroller.jsp?command=select&myno=<%=dto.getMyno() %>";
		</script>
<%
		} else {
%>
		<script type="text/javascript">
			alert("정보 수정 실패");
			location.href="./logincontroller.jsp?command=update&myno=<%=dto.getMyno() %>";
		</script>
<%
		}
	} else if (command.equals("delete")) {
		int myno = Integer.parseInt(request.getParameter("myno"));
		MYMemberDto dto = new MYMemberDto();
		dto.setMyno(myno);
		
		int res = biz.deleteUser(myno);
		if (res > 0) {
%>
		<script type="text/javascript">
			alert("회원탈퇴 완료");
			location.href="index.html";
		</script>
<%
		} else {
%>
		<script type="text/javascript">
			alert("회원탈퇴 실패");
			location.href="./logincontroller.jsp?command=login&myid=<%=dto.getMyid() %>&mypw=<%=dto.getMypw() %>";
		</script>
<%
		}
	}
%>











	<h1 style="color: red;">잘못왔다....</h1>
	
</body>
</html>