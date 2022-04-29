<%@page import="kr.co.dw.member.dto.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원 정보 삭제</h1>
	<form action="/delete.do" method="post">
		ID: <input name="id" value="${dto.id}" readonly><br>
		NAME: <input name="name" value="${dto.name}" readonly><br>
		AGE: <input name="age" value="${dto.age}" readonly><br>
		<input type="submit" value="삭제 완료">
	
	
	
	
	
	</form>
</body>
</html>