<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
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
<!-- 
	c:out -> 변수의 출력
	c:forEach -> 반복문
	c:choose, c:when, c:otherwise -> Switch 문
	c:if -> 조건문이지만 else는 없다.
 -->
	<h1>JSTL : Jsp Standard Tag Library</h1>
	
	<table border="1">
		<tr>
			<th>이름</th>
			<th>국어</th>
			<th>영어</th>
			<th>수학</th>
			<th>총점</th>
			<th>평균</th>
			<th>등급</th>
		</tr>
		<C:forEach items="${list }" var="score">
			<tr>
				<td>
					<!-- eq : == / ne : != / empty : null -->
					<C:if test="${score.name eq '이름10' }">
						<C:out value="홍길동"></C:out> <!-- 출력 -->
					</C:if>
					<C:choose>
						<C:when test="${score.name eq '이름20' }">
							<C:out value="${score.name }님!"></C:out>
						</C:when>
						<C:when test="${score.name eq '이름30' }">
							<C:out value="${score.name }님!"></C:out>
						</C:when>
						<C:otherwise>
							<C:out value="누구지?"></C:out>
						</C:otherwise>
					</C:choose>
				</td>
				<td>${score.kor }</td>
				<td>${score.eng }</td>
				<td>${score.math }</td>
				<td>${score.sum }</td>
				<td>${score.avg }</td>
				<td>
					<C:choose>
						<C:when test="${score.grade eq 'A' || score.grade eq 'B' }">
							<C:out value="PASS"></C:out>
						</C:when>
						<C:otherwise>
							<C:out value="FAIL"></C:out>
						</C:otherwise>
					</C:choose>
				</td>
			</tr>
		</C:forEach>
	</table>
	
	<C:forEach var="i" begin="2" end="10" step="1">
		<C:forEach var="i" begin="1" end="10" step="1">
			${i }
		</C:forEach>
	</C:forEach>
	<!-- 구구단 출력 -->

</body>
</html>