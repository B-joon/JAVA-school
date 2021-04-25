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
		function allCheck(bool){
			var chks = document.getElementsByName("chk");
			for (var i = 0; i < chks.length; i++) {
				chks[i].checked = bool;
			}
		}
		$(function () {
			$("#muldelform").submit(function () {
				if ($("#muldelform input:checked").length == 0) {
					alert("삭제하려는 글을 한개 이상 선택하여 주세요");
					
					return false;
				}
			});
		});
	</script>
</head>
<body>
	    <table border="1">
        <col width="50"> 
        <col width="100"> 
        <col width="500"> 
        <col width="100"> 
    
        <tr>
            <th>번호</th>
            <th>작성자</th>
            <th>제목</th>
            <th>작성일</th>
        </tr>
        <c:choose>
            <c:when test="${empty list }">
                <tr>
                    <td colspan="4" align="center">----------작성된 글이 존재하지 않습니다---------</td>
                </tr>
            
            </c:when>
            <c:otherwise>
                <c:forEach items="${list }" var="dto">
                    <tr>
                        <td>${dto.seq }</td>
                        <td>${dto.writer }</td>
                        <td><a href="selectone?seq=${dto.seq }">${dto.title }</a></td>
                        <td>${dto.regdate }</td>
                    </tr>
                
                </c:forEach>
            </c:otherwise>
        </c:choose>
        <tr>
            <td colspan="4" align="right">
                <input type="button" value="글작성" onclick="location.href='controller.do?command=insertform'">
            </td>
        </tr>
        
    </table>
</body>
</html>