<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" ></script>

<script>
$(function(){
	$("#loginChk").hide();
})

function login(){
	var memberid = $("#memberid").val().trim();
	var memberpw = $("#memberpw").val().trim();
	var loginVal = {
			"memberid" : memberid,
			"memberpw" : memberpw
	}
	
	if(!!memberid && !!memberpw ){
		console.log(loginVal)
		$.ajax({
			type : "POST",
			url : "ajaxlogin.do",
			data : JSON.stringify(loginVal),
			contentType : "application/json",
			dataType : "json",
			success : function(msg){
				if(msg.check){
					location.href="list.do";
				}else{
					$("#loginChk").show();
					$("#loginChk").html("id혹은 pw가 잘못되었습니다. ");
				}
			}, 
			error: function(){
				alert("failed");
			}
		})
	}else{
		alert(" id 및 pw를 확인해 주세요 ");
	}
	
}
</script>
</head>
<body>

<div style="width:600px;margin: 0 auto;">
    <label>id</label><input type="text" id="memberid"/>
    <label>password</label><input type="text" id="memberpw"/>
    <input type="button" onclick="login()" value="submit~"/>
    <span id="loginChk" style="display:inline-block;width:30px;height:30px;background-color:green;"></span>
</div>
</body>
</html>