<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 등록</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<jsp:include page="/main/p_menu.jsp"></jsp:include>

<form action="/member/insert.do" method ="post">

<label for="id">ID:</label>
<input id = "id" name = "id"><br>

<label for="name">NAME:</label>
<input id = "name" name = "name"><br>

<label for="age">AGE:</label>
<input id = "age" name = "age"><br>
	
	<input type = "submit" value ="회원 등록">








</form>
</body>
</html>