<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<jsp:include page="/command1/jsp/p_menu.jsp"></jsp:include><br>
<h1>로그인 화면</h1>




<form action="/login.do" method="post">
ID : <input name = "id"><br>
PW : <input name = "pw"><br>
<input type = "submit" value = "로그인 완료">


</form>

</body>
</html>