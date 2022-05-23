<%@page import="java.util.List"%>
<%@page import="kr.co.board.domain.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>       
<!DOCTYPE html>
<html>
<head>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<meta charset="UTF-8">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&display=swap" rel="stylesheet">

<style type="text/css">

*{
   font-family: 'Noto Sans KR', sans-serif;
   font-size: mediun   }
   

      html {
      height: 100%;
   }
   
   
   body {
       width:100%;
       height:100%;
       margin: 0;
        padding-top: 8px;
        padding-bottom: 40px;
        background-repeat: no-repeat;
   }
  
  th, td {
    border: 1px solid #444444;
    border-color: #D9D7F1; 
  }
  
  a{
  	color: #9772FB;
  	font-weight:bold; 
  }

</style>
</head>

<body>
      
 <center>    

<a href="/board/main.do"><img alt="착한폰마켓" width='600' height='300' src="../css/main2.png" ></a>

<br>
<br>

<jsp:include page="/command/p_menu2.jsp"></jsp:include>
<br>




<table>
		<thead>
			<tr>
				<th width="100">번호</th>
				<th width="250">제목</th>
				<th width="100">작성자</th>
				<th width="250">작성일</th>
				<th width="100">조회수</th>
			</tr>
		</thead>
	<tbody>

		
<p>공지글</p> 
<c:forEach items = "${list3}" var = "dto">
<tr>
<td>${dto.num}</td>

<td><a href="/board/read.do?num=${dto.num}">${dto.title}</a></td>
<td>${dto.writer}</td>
<td>${dto.writeDay}</td>
<td>${dto.readcnt}</td>
</tr>

</c:forEach>
				</tbody>
						</table>
						
<br>

<p>최신글</p> 
<table>
		<thead>
			<tr>
				<th width="100">번호</th>
				<th width="250">제목</th>
				<th width="100">작성자</th>
				<th width="250">작성일</th>
				<th width="100">조회수</th>
			</tr>
		</thead>
	<tbody>
<c:forEach items = "${list2}" var = "dto">
<tr>
<td>${dto.num}</td>

<td><a href="/board/read.do?num=${dto.num}">${dto.title}</td>
</a>
<td>${dto.writer}</td>
<td>${dto.writeDay}</td>
<td>${dto.readcnt}</td>
</tr>

</c:forEach>
				</tbody>
						</table>	
						<br>
	<br>
<table>
		<thead>
			<tr>
				<th width="100">번호</th>
				<th width="250">제목</th>
				<th width="100">작성자</th>
				<th width="250">작성일</th>
				<th width="100">조회수</th>
			</tr>
		</thead>
	<tbody>
	
	
<p>베스트글</p> 
<c:forEach items = "${list4}" var = "dto">
<tr>
<td>${dto.num}</td>

<td><a href="/board/read.do?num=${dto.num}">${dto.title}</td></a>
<td>${dto.writer}</td>
<td>${dto.writeDay}</td>
<td>${dto.readcnt}</td>
</tr>

</c:forEach>
				</tbody>
						</table>
						<br> <br> <br>	
						
<a href="../jsp/board/market.jsp"><img alt="광고" width='600' height='150' src="../css/after.png" ></a>

	</center>
</body>
</html>