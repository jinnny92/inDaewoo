<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href ="/myinfo.do">내정보관리</a>
<a href = "/board/list.do">게시글화면</a>
<a href = "/insertui.do">회원가입</a>
<a href = "/board/main.do">메인페이지</a>
<h1>회원 정보 수정</h1>
<form action="/myinfoupdate.do" method = "post">
<label for ="id">ID</label>
<input id = "id" name = "id" readonly value ="${dto.id}">
<br>
<label for="name">NAME</label>
<input id = "name" name = "name" value = "${dto.name}">
<br>
<label for="pw">pw</label>
<input id = "pw" name = "pw" value = "${dto.pw}">
<br>
<label for="phonenumber">phonenumber</label>
<input id = "phonenumber" name = "phonenumber" value = "${dto.phonenumber}" size ="8">
<br>
<label for="birthday">생일</label>
<input id = "birthday" name = "birthday" value = "${dto.birthday}">
<br>
<label for="email">이메일</label>
<input id = "email" name = "email" value = "${dto.email}">
<br>
<input type = submit value = "수정 완료">
</form>
</body>
</html>