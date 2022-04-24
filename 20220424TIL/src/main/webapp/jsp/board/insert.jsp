<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
</head>
<body>
<h1>게시글 작성</h1>
<form action="/board/insert.do" method="post">
<label for = "writer"> 작성자: </label>
<input id = "writer" name ="writer"><br>
<label for = "title">제목: </label>
<input id = "title" name = "title"><br>
<label for = "content">내용: </label>
<textarea rows="5" id = "content" name = "contene"></textarea>
<br>
<input type="submit" value="글 입력 완료">





</form>
</body>
</html>