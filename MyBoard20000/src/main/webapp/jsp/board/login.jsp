<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
</head>
<body>
<jsp:include page="/command/p_menu.jsp"></jsp:include>
<h1>로그인 화면</h1>
<form action="/board/login.do" method="post">

ID:<input name = "id"><br>
PW:<input type = "password" name = pw><br>
<input type = "submit" value = "로그인 완료">
<input type = "reset" value = "취소" onclick ="history.back()">

</form>

</body>
</html>