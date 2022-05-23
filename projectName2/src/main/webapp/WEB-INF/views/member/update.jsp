<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정 화면</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<h1>회원 정보 수정 화면</h1>
<form action="/member/update" method="post">
아이디 : <input readonly name= "id" value="${dto.id}"><br>
비밀번호 : <input  name="pw" type="password"><br>
이름 : <input  name="name" value="${dto.name}"><br>
생일 : <input  type="date" name="birth" value="${dto.birth}"><br>
<input type="submit" value="수정완료">




</form>
</body>
</html>