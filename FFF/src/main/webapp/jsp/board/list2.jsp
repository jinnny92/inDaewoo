<%@page import="kr.co.board.domain.BoardDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유 게시판</title>
<style type="text/css">

td{
	text-align: center;
	padding: 5px;
}
td.title{
text-align:left;
}
td.title a{
text-decoration: none;
}
.red{
	color:red;
}
</style>
</head>
<body>

	
<center>
<a href="/board/main.do"><img alt="착한폰마켓" width='600' height='300' src="../../css/main2.png" ></a>
	
<br>
<br>
	
	
<jsp:include page="/command/p_menu2.jsp"></jsp:include>
<br>

	<h1>자유 게시판</h1>
	<table border = "1">

		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
				
			
			</tr>
		</thead>
		<tbody>
		

 
 	  <c:forEach items="${pt.list}" var = "bdto">
 	<tr>
 				<td align="center" width="100">${bdto.num}</td>
				<td class ="title" width="250"> 
				<a href="/board/read.do?num=${bdto.num}">
				
				<c:forEach begin ="1" end = "${bdto.repIndent}">
				&nbsp;&nbsp;&nbsp;
				</c:forEach>
				
				${bdto.title}
				</a>
				</td>
				<td align="center" width="100">${bdto.writer }</td>
				<td align="center" width="250">${bdto.updateDay}</td>
				<td align="center" width="100">${bdto.readcnt}</td>
					
			
 	</tr>
 	
 	</c:forEach>  

		</tbody>
	</table>
	
	
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

	<a href = "/board/insertui.do">글쓰기</a>
	<br>
	
	<a href = "/board/list.do?curPage=${pt.curPage > 1 ? pt.curPage-1:1}">&laquo;</a>
	
	<c:forEach var = "i" begin="${pt.beginPageNum}" end = "${pt.finishPageNum}">
	<a href = "/board/list.do?curPage=${i}" class ="${i == pt.curPage?'red':''}">
	
	${i}
	
	
	
	</a> &nbsp;&nbsp;
	
	</c:forEach>
	<a href = "/board/list.do?curPage=${pt.curPage < pt.totalPage ? pt.curPage+1:pt.totalPage}">&raquo;</a>
	
	<form action="/board/search.do">
	<select name = "criteria">
		<option value = "writer">작성자</option>
		<option value = "title">제목</option>
		<option value = "content">내용</option>
	</select>
	<input name = "keyword">
	<input type = "submit" value = "검색">
	</form>
	
	
	 <script type="text/javascript">
	
	function openInsertUi() {
		location.assign("/board/insertui.do");
	}
	
	</script>
	</center>
</body>
</html>