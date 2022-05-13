<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정 화면</title>
</head>
<body>
<jsp:include page="/command/p_menu.jsp"></jsp:include>
<h1>게시글 수정</h1>

<form action="/board/update.do" method="post">

<input type = "hidden" name ="num" value ="${dto.num}">

작성자 : <input name = "writer" value = "${dto.writer}" readonly="readonly"><br>
제목 : <input name = "title" value ="${dto.title}"><br>
내용 : <textarea rows="5" name ="content">${dto.content}</textarea>
<br>
<input type = "submit" value = "글 수정 완료">
<input type = "reset" value = "취소" onclick ="history.back()">

</form>


</body>
</html>