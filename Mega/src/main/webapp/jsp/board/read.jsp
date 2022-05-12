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
<h1>글읽기</h1>

<p>번호: ${dto.num}</p><br>
<p>제목: ${dto.title}</p><br>
<p>작성자: ${dto.id}</p><br>
<p>등록일: ${dto.writeDay}</p><br>
<p>수정일:${dto.updateDay}</p><br>
<p>조회수:${dto.readCnt}</p><br>

<p>내용:</p>

<p>${dto.content}</p>




<br>
<a href="/board/list.do">글목록</a>
<a href="/board/insertui.do">글쓰기</a>
<a href="/board/updateui.do?num=${dto.num}">수정</a>
<a href="/board/delete.do?num=${dto.num}">삭제</a>
<a href="/board/replyui.do?num=${dto.num}">답글</a>

</body>
</html>