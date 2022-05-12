<%@ page language="java" contentType="text/html; charset= UTF-8"
    pageEncoding="UTF-8"%>
   
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&display=swap" rel="stylesheet">
</head>
<body>

<h1>회원정보 자세히 보기</h1>

아이디 : ${dto.id}
비밀번호 : ${dto.pw}
이름 : ${dto.name}


<br>
<a href="/member/list.do">회원목록</a>
<a href="/member/updateui.do?id=${dto.id}">회원 수정</a>
<a href="/member/delete.do?id=${dto.id}">회원 삭제</a>
</body>
</html>