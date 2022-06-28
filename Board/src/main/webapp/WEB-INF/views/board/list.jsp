<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>게시글목록</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js" integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2" crossorigin="anonymous"></script>
</head>
<body>




<jsp:include page="../common/header.jsp"/>


${login.id}<br>


<a class="btn btn-primary" href="/board/insert">글쓰기</a>



<div class="jumbotron">
<h1 class="text-center">게시글목록</h1>
</div>
<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">글번호</th>
      <th scope="col">글제목</th>
      <th scope="col">작성자</th>
      <th scope="col">작성일</th>
      <th scope="col">조회수</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${list}" var="list">
    <tr>
      <td>${list.bno}</td>
      <td><a href="/board/read/${list.bno}">${list.title}</a></td>
      <td>${list.writer}</td>
	  <td>${list.updateDay}</td>
	  <td>${list.readCnt}</td>
    </tr>
    </c:forEach>
  </tbody>
</table>


<nav aria-label="...">
  <ul class="pagination">
    <li class="page-item">
      <a class="page-link" href="/board/list?curpage=${pt.curPage <= 1? 1: pt.curPage-1}">Previous</a>
    </li>
    
    <c:forEach begin="${pt.beginPageNum}" end="${pt.finishPageNum}" var="page">
    	<c:if test="${page == pt.curPage}">
    		 <li class="page-item active" aria-current="page">
      			<a class="page-link" href="/board/list?curpage=${pt.curPage}">${page}</a>
    		</li>
    	</c:if>
    	
    	<c:if test="${page != pt.curPage}">
    		  <li class="page-item">
    		  <a class="page-link" href="/board/list?curpage=${page}">${page}</a></li>
    	</c:if>
    	
    </c:forEach>
    
    
    
    <li class="page-item">
      <a class="page-link" href="/board/list?curpage=${pt.curPage >= pt.totalPage? pt.totalPage : pt.curPage+1}">Next</a>
    </li>
  </ul>
</nav>

<form action="/board/search" method="get" target="blank">

<div class="input-group mb-3">
	<select name="criteria" class="form-control col-sm-2">
		<option selected>검색 조건</option>
		<option value="writer">작성자</option>
		<option value="title">제목</option>
		<option value="content">내용</option>
	
	</select>


  <input class="form-control" name="keyword">
  <div class="input-group-append">
    <button class="btn btn-info" type="submit" >검색</button>
  </div>
</div>



</form>



	<%-- <a href = "/board/list?curPage=${pt.curPage > 1 ? pt.curPage+1:1}">&laquo;</a>

	<c:forEach var = "i" begin="${pt.beginPageNum}" end = "${pt.finishPageNum}">
	<a href = "/board/list?curPage=${i}" class ="${i == pt.curPage?'red':''}">

	${i}



	</a> &nbsp;&nbsp;

	</c:forEach>
	<a href = "/board/list?curPage=${pt.curPage < pt.totalPage ? pt.curPage-1:pt.totalPage}">&raquo;</a>


 --%>

<script type="text/javascript">
	$(document).ready(function() {
		
	});


</script>
</body>
</html>