<%@ page language="java" contentType="text/html; charset= UTF-8"
    pageEncoding="UTF-8"%>
   
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

td{
	text-align: center;
	padding: 0 5px;
}

td.title{
	text-align: left;
	}
	
td.title a{
	text-decoration: none;
}

.red{
	color : red;
}

</style>



<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&display=swap" rel="stylesheet">
</head>
<body>
<h1>글목록</h1>

<table border="1">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>조회수</th>
		<th>repRoot</th>
		<th>repStep</th>
	</tr>
	
	<c:forEach items="${pt.list}" var="list">
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
</table>

<a href="/board/list.do?curPage=${pt.curPage>1? pt.curPage -1:1 }">&laquo;</a>
<c:forEach begin="${pt.beginPageNum}" end="${pt.finishPageNum}" var="i">

		<a href="/board/list.do?curPage=${i}" class="${i == pt.curPage?'red':''}"> ${i}</a> 


</c:forEach>
<a href="/board/list.do?curPage=${pt.curPage<pt.totalPage? pt.curPage+1:pt.totalPage }">&raquo;</a>
<br>

<a href="/board/insertui.do">글쓰기</a>


<form action="/board/search.do">
	<select name="criteria">
			<option value="id">작성자</option>
			<option value="title">제목</option>
			<option value="content">내용</option>
	</select>
		<input name="keyword">
		<input type="submit" value="검색">


</form>

</body>
</html>