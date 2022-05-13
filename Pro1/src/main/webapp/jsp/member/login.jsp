<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인화면</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<jsp:include page="/main/p_menu.jsp"></jsp:include>
<h1>로그인 화면</h1>

<form action="/member/login.do">

<label for="id">아이디:</label>
<input id="id" name="id"><br>

<label for="pw">비밀번호:</label>
<input id="pw" name="pw" type="password"><br>

<input type="submit" value="로그인 완료">
</form>

</body>
</html>