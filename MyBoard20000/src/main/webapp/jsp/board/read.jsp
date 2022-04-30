<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 자세히 보기</title>
</head>
<body>
<jsp:include page="/command/p_menu.jsp"></jsp:include>
<h1>글 자세히 보기</h1>

<p>번호: ${bDto.num}</p>
<p>작성자: ${bDto.writer}</p>
<p>작성일: ${bDto.writeDay}</p>
<p>수정일: ${bDto.updateDay}</p>
<p>조회수: ${bDto.readcnt}</p>
<p>제목: ${bDto.title}</p>
<p>내용</p>
<p>${bDto.content}</p>

<a href="/board/updateui.do?num=${bDto.num}">수정화면</a>
<a href="/board/delete.do?num=${bDto.num}">삭제</a>
<a href="/board/list.do">목록</a>
<a href="/board/replyui.do?num=${bDto.num}">답글</a>
</body>
</html>