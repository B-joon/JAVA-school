
$(function() {
	getJsonDate();
});

function getJsonDate() {
	$.getJSON("resources/json/bike.json", function(mydata){
		$.ajax({
			url:"bike.do",
			method:"post",
			data: {"command": "getdata", "mydata": JSON.stringify(mydata)},
			dataType: "json",
			success: function(msg){
				var $tbody = $("tbody");
				
				var list = msg.result;
				for (var i = 0; i < list.length; i++) {
					var $tr = $("<tr>");
					
					$tr.append($("<td>").append(list[i].name));
					$tr.append($("<td>").append(list[i].addr));
					$tr.append($("<td>").append(list[i].latitude));
					$tr.append($("<td>").append(list[i].longitude));
					$tr.append($("<td>").append(list[i].bike_count));
					
					$tbody.append($tr);
				}
			},
			error: function(){
				alert("통신실패");
			}
		});
	});
}
