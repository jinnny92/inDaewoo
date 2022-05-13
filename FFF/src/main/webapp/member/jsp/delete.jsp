<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/command/p_menu.jsp"></jsp:include>
<h1>삭제 화면</h1>
정말 삭제할래?
<form action="/delete.do" method="post" id = "form">
<input type = "hidden" name = "id" value = "${id}">

</form>
<button onclick ="yesDel()">예</button>
<button onclick = "noDel()">아니오</button>

<script type="text/javascript">

function yesDel() {
	document.getElementById("form").submit();
}
function noDel() {
	history.back();
	//location.assign("/list.do");
}

</script> 
</body>
</html>