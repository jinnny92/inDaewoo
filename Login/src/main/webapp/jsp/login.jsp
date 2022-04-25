<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면 만들기</title>
</head>
<body>
<%@ include file="p_footer.jsp"%>

<hr>
<h1>로그인 화면</h1>

<form action="/login.do" method="post">


ID: <input name = "id"><br> 
PW: <input name = "pw" type="password"><br> 

<input type = "submit" value="로그인 완료">
<input type="submit" value="취소" onclick="listUi()">
<br>
<br>

<nav>
<a href="#">회원가입</a> |
<a href="#">아이디 찾기</a> |
<a href="#">비밀번호 찾기</a>
</nav>

<script type="text/javascript">
	function listUi() {
		location.assign("/listui.do");
	}

</script>
</form>
</body>
</html>