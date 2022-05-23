<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<h1>회원 목록</h1>

<table border="1px">
	<thead>
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>생일</th>
		
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="list">
			<tr>
				<td><a href="/member/read/${list.id}">${list.id}</a></td>
				<td>${list.name}</td>
				<td>${list.birth}</td>
			</tr>
		</c:forEach>
		
	</tbody>
</table>

</body>
</html>