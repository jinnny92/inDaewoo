<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 화면</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<h1>회원가입</h1>
<form action="/member/insert" method="post">

아이디 : <input name="id"><br>
비밀번호 : <input type="password" name="pw"><br>
이름 : <input name="name"><br>
생일 : <input type="date" name="birth"><br>



<input type="submit" value="가입완료">
</form>


</body>
</html>