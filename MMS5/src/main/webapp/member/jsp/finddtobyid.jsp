<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원 정보 자세히 보기</h1>
ID: ${dto.id}<br>
NAME: ${dto.name}<br>
AGE: ${dto.age}<br>

<a href="/list.do">목록</a>
<a href="/updateui.do?id=${dto.id}">정보 수정</a>
<a href="/delete.do?id=${dto.id}">회원 삭제</a>
</body>
</html>