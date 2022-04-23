<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원 등록</h1>
<form action="/insert.do" method="post">
<label for = "id">ID:</label>
<input id = "id" name = "id"><br>

<label for = "name">NAME:</label>
<input id = "name" name = "name"><br>

<label for = "age">AGE:</label>
<input id = "age" name = "age"><br>

<input type="submit" value="회원 등록">






</form>

</body>
</html>