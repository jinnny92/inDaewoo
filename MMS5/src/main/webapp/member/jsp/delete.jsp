<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원 삭제</h1>
정말 삭제하시겠습니까?

<form action="/delete.do" method="post" id = "form">
<input type = "hidden" name = "id" value="${id}">
</form>

<button onclick="yesDel()">예</button>
<button onclick="noDel()">아니오</button>

<script type="text/javascript">

function yseDel() {
	document.getElementById("form").submit();
}


function noDel() {
	history.back();
}
</script>

</body>
</html>