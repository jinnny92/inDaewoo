<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제화면</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<h1>삭제화면</h1>
<form action="/member/delete" method="post">
	<input name="id" value="${id}" type="hidden">

비밀번호 : <input type="password" name="pw"><br>

<button>삭제 완료</button>

</form>




</body>
</html>