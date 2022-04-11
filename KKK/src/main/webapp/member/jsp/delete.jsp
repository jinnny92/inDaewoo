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
<form action="/delete.do" method="post"> 
	삭제할 회원의 ID : <input name="id"><br>
	
	<input type="submit" value="회원 삭제">
</body>
</html>