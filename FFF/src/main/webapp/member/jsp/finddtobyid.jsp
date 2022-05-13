<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/command/p_menu.jsp"></jsp:include>
<h1>회원 정보 자세히 보기</h1>
ID: ${dto.id}<br>
비밀번호 : ${dto.pw}<br>
NAME: ${dto.name}<br>

전화번호 :${dto.phonenumber }<br>
생년월일 : ${dto.birthday}<br>
이메일 : ${dto.email}<br>
<br>
<a href="/list.do">목록</a> 
<a href="/updateui.do?id=${dto.id}">회원 정보 수정</a>
<%-- <a href="/delete.do?id=${dto.id}">삭제화면_외부시험용</a>  --%>
<a href="/deleteui.do?id=${dto.id}">회원 정보 삭제</a>


</body>
</html>