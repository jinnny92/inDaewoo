<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	
	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<h1>회원 정보 수정</h1>
<form action="/member/update.do" method="post">
<label for="id">ID</label>
<input id = "id" name="id" readonly value="${dto.id}"><br>

<label for="name">NAME</label>
<input id="name" name="name" value="${dto.name}"><br>
<label for="age">AGE</label>
<input id="age" name="age" value="${dto.age}"><br>

<input type="submit" value="수정 완료">






</form>

</body>
</html>