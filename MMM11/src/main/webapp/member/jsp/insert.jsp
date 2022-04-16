<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원 등록</h1>
<form action="/insert.do" method="post">
<!-- action은 어디로 보낼건지 -->
<!-- 로그인이나 회원가입은 반드시 post방식 -->

ID : <input name = "id"><br>
NAME: <input name = "name"><br>
AGE: <input name = "age"><br>
<input type="submit" value = "회원 등록">

<!-- <input type=“submit”>는 서버의 
폼 핸들러(form handler)로 폼 데이터(form date)를 전송하는 제출 버튼(submit button)을 정의합니다.


폼 핸들러는 일반적으로 입력된 데이터를 처리하는 스크립트를 포함하고 있는 서버 페이지이며,
 이러한 폼 핸들러의 주소는 <form> 요소의 action 속성에 명시됩니다. -->

</form>
</body>
</html>