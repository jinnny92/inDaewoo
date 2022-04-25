<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답글 등록 </title>
</head>
<body>
<h1>답글 작성</h1>
<form action="/board/reply.do" method="post">
<input type="hidden" value="${orgnum}" name ="orgnum">
작성자: <input name = "writer" required><br>
제목: <input name="title" required><br>
내용: <textarea rows="5" name="content"></textarea>
<br>
<input type= "submit" value="답글 입력 완료">
<input type="reset" value="취소">


</form>
</body>
</html>