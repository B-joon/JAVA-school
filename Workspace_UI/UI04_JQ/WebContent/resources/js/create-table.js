
function makeTable(elem) {
    $table = $("<table border=1>");

    for (var i = 0; i < 1; i++) {
        // tr태그를 만든다.
        $tr = $("<tr>");
        for (var j = 0; j < elem.eq(0).children().length; j++) {
            // 0번지에 있는 자식들의 태그내임을 불러오고 td태그를 만들어서 넣어준다.
            $td = $("<td>").append(elem.eq(0).children().eq(j).prop("tagName"));
            // td를 tr에 넣어준다.
            $tr.append($td);
        }
        // 테이블에 tr을 넣어준다.
        $table.append($tr);
    }
    

    for (var i = 0; i < elem.length; i++) {
        $tr = $("<tr>");
        for (var j = 0; j < elem.eq(i).children().length; j++) {
            $td = $("<td>").append(elem.eq(i).children().eq(j).text());
            $tr.append($td);
        }
        $table.append($tr);
    }
    return $table;
}