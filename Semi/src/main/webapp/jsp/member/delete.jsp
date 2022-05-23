<%@ page language="java" contentType="text/html; charset= UTF-8"
    pageEncoding="UTF-8"%>
   
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&display=swap" rel="stylesheet">
<style type="text/css">
*{
	font-family: 'Noto Sans KR', sans-serif;
	}
	
</style>
</head>
<body>
<h1>삭제 화면</h1>
${id}(을)를 
정말 삭제하시겠습니까?
<form action="/member/delete.do" method="post" id="form">
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
	
}

</script> 

</body>
</html>