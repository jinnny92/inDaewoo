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
<jsp:include page="../../command1/jsp/p_menu.jsp"></jsp:include>
ID: ${dto.id}<br>
NAME: ${dto.name}<br>
AGE: ${dto.age}<br>
<br>
<a href="/list.do">목록</a> 
<a href="/updateui.do?id=${dto.id}">수정화면</a>
<a href="/delete.do?id=${dto.id}">삭제화면_외부시험용</a> 
<a href="/deleteui.do?id=${dto.id}">삭제화면_실무용</a>


</body>
</html>