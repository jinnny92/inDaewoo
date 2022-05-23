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
</head>
<body>
<h1>검색결과</h1>


<table border="1">
 <thead>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>조회수</th>
		<th>repRoot</th>
		<th>repStep</th>
	</tr>
	
</thead>
     <tbody>

<c:forEach items="${list}" var="list">


		<tr>
		<td>${list.num}</td>
		<td class="title">
			<a href="/board/read.do?num=${list.num}">
					<c:forEach begin="1" end="${list.repIndent}">
						&nbsp;&nbsp;&nbsp;
					
					</c:forEach>
					
					
			${list.title}</a>
		</td>
		<td>${list.id}</td>
		<td>${list.updateDay}</td>
		<td>${list.readCnt}</td>
		<td>${list.repRoot}</td>
		<td>${list.repStep}</td>
		</tr>
	</c:forEach>
	   </tbody>
</table>



</body>
</html>