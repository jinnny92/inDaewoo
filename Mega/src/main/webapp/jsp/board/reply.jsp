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
<h1>답글 화면입니다</h1>
<form action="/board/reply.do" method="post">

<!-- 답글은 replyui에서 넘겨받은 num값(orgnum 원래글의 num값)이 반드시 폼태그 안에 들어가 있어야함 -->
<input type="hidden" value="${orgnum}" name="orgnum"> 
<!-- 얘도 서버로 넘겨야 하니까 이름이 있어야함 -->

아이디 : <input name="id"><br>
제목: <input name="title"><br>
내용 : <textarea rows="5" name="content"></textarea><br>

<input type="submit" value="답글완료">



</form>



</body>
</html>