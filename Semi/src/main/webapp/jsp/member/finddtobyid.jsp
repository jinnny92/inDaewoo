<%@ page language="java" contentType="text/html; charset= UTF-8"
    pageEncoding="UTF-8"%>
   
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 자세히 보기</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&display=swap" rel="stylesheet">

<style type="text/css">
*{
	font-family: 'Noto Sans KR', sans-serif;
	}
	
</style>

</head>
<body>

<h1>회원 정보 자세히 보기</h1>
ID: ${dto.id}<br>
비밀번호 : ${dto.pw}<br>
NAME: ${dto.name}<br>

전화번호 :${dto.phonenumber}<br>
생년월일 : ${dto.birthday}<br>
이메일 : ${dto.email}<br>
<br>
<a href="/member/list.do">목록</a> 
<a href="/member/updateui.do?id=${dto.id}">수정 화면</a>
<a href="/member/delete.do?id=${dto.id}">바로 삭제</a> 
<a href="/member/deleteui.do?id=${dto.id}">삭제 화면</a>



</body>
</html>