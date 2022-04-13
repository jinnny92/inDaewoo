<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원 정보 수정</h1>
<form action="/update.do" method="post"> 
수정할 회원의	ID : <input name="id"><br>
수정할 이름 : <input name = "name"><br>
수정할 나이: <input name  = "age"><br>
	<input type="submit" value="회원 정보 수정">
</form>
</body>
</html>