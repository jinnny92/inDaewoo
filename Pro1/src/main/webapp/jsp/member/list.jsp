<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&display=swap" rel="stylesheet">

<style type="text/css">

*{
	font-family: 'Noto Sans KR', sans-serif;
	font-size: xx-large;	}

td{
	text-align: center;
	padding: 5px;
	
}
td.title{
text.align: center;
}

</style>

</head>
<body>
<jsp:include page="/main/p_menu.jsp"></jsp:include>



<h1>회원 목록</h1>

<table>
	<thead>
		<tr>
		<th>아이디</th>
		<th>이름</th>
		<th>나이</th>
		</tr>
	</thead>
</table>

<c:forEach items="${list}" var="ndto">
	<tr>
		<td><a href="/member/finddtobyid.do?id=${ndto.id}">${ndto.id}</a></td>
		<td>${ndto.name}</td>
		<td>${ndto.age}</td>
		<br>
	</tr>
</c:forEach>


</body>
</html>