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
<h1>회원목록</h1>

<c:forEach items="${list}" var="list">
아이디:<a href="/member/find.do?id=${list.id}">${list.id}</a>
비밀번호:${list.pw}
이름:${list.name}
<br>
</c:forEach>
<br>
<a href="/member/insertui.do">가입</a>
<a href="/board/insertui.do">글쓰기</a>
<a href="/board/list.do">글목록</a>

</body>
</html>