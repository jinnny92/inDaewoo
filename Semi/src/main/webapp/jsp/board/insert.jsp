<%@ page language="java" contentType="text/html; charset=UTF-8"
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

<style type="text/css">

*{
	font-family: 'Noto Sans KR', sans-serif;
	font-size: mediun	}
</style>
</head>
<body>
<h1>게시글 작성</h1>
<form action="/board/insert.do" method="post">

<label for="writer">작성자</label>
<input id="writer" name="writer"><br>

<label for="title">제목</label>
<input id="title" name="title" required><br>

<label for="content">내용</label>
<textarea rows="5" id="content" name="content"></textarea><br>

<input type="submit" value="글 입력">
<input type="reset" value="다시 쓰기">
<a href="/board/list.do"><button type="button">목록으로 돌아가기</button></a>

</form>


</body>
</html>