

function getParameterValues() {
	var name = "name=" + encodeURIComponent(document.getElementById("name").value);
	var kor = "kor=" + document.getElementById("kor");
	var eng = "eng=" + document.getElementById("eng");
	var math = "math=" + document.getElementById("math");
	
	return "?" + name + "&" + kor + "&" + eng + "&" + math;
}

function load() {
	var url = "score.do" + getParameterValues();
	
	httpRequest = new XMLHttpRequest();
	httpRequest.onreadystatechange=callback;
	httpRequest.open("GET", url, true);
	httpRequest.send();
}

function callback() {
	alert("readystate : " + httpRequest.readyState);
	if (httpRequest.readyState == 4) {
		alert("status : " + httpRequest.status);
		if (httpRequest.status == 200) {
			var obj = JSON.parse(httpRequest.responseText);
			document.getElementById("result").innerHTML = decodeURIComponent(obj.name) + "의 총점 : " + obj.sum +
			"\n평균 : " + obj.avg;
		} else {
			alert("통신 실패");
		}
	}
}


/*
	encodeURIComponent : 모든 문자를 인코딩(UTF-8)
	decodeURIComponent : UTF-8 에서 다시 원래 글자로.
	encodeURI : 조소줄에서 사용되는 특수문자는 제외하고 인코딩
	
	JSON.parse : json형태의 문자열을 json 객체로 변환 (String -> json object)
	JSON.stringify : javascipt 객체(json 형태로 변환할 수 있는)를 json 형태의 문자열로 변환 (object - > json string)
*/