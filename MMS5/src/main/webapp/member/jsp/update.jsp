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

<label for = "id">ID</label>
<input id = "id" name = "id" value="${dto.id}" readonly>
<br>


<label for = "name">NAME</label>
<input id = "name" name = "name" value="${dto.name}">
<br>

<label for = "age">AGE</label>
<input id = "age" name = "age"  value="${dto.age}" type="number">
<br>

<input type="submit" value="수정 완료">

</form>

</body>
</html>