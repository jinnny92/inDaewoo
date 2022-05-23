<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보자세히보기</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<h1>회원정보 자세히보기</h1>
아이디 : ${dto.id}<br>
비밀번호 : ${dto.pw}<br>
이름 : ${dto.name}<br>
생일 : ${dto.birth}<br>

<a href="/member/update/${dto.id}">수정</a> <a href="/member/delete/${dto.id}">삭제</a> <a href="/member/list">목록</a>

</body>
</html>