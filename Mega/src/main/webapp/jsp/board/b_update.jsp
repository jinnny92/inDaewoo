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
<h1>수정화면</h1>

<form action="/board/update.do" method="post">
	<input type="hidden" name="num" value="${dto.num}">

작성자: <input type="text"  value="${dto.id}" readonly><br>
제목: <input inputmode="text" name="title" value="${dto.title}"><br>
내용:<textarea rows="5" name="content">${dto.content}</textarea><br>


<input type="submit" value="수정완료">


</form>


<br>

<a href="/board/list.do">글목록</a>
<a href="/board/insertui.do">글쓰기</a>
<a href="/member/insertui.do">회원가입</a>



</body>
</html>