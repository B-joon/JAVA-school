<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	file: ${fileObj.name }<br/>
	desc: ${fileObj.desc }<br/>
	
	<form action="download" method="post">
		<input type="hidden" name="name" value="${fileObj.name }">
		<input type="submit" value="download">
	</form>
	
	<!-- 
		tomcat web.xml
		mime-type (Multipurpose Internet Mail Extension)
		데이터가 어떤 종류의 stream인지를 나타내주는 프로토콜 (request header에 지정!)
		
		mine-type 추가!
		
		<min-mapping>
			<extension>hwp</extension>
			<mine-type>application/unknown</mine-type>
		</min-mapping>
	 -->

</body>
</html>