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
        padding-bottom: 60px;
        background-repeat: no-repeat;
   }
   
   
   .form-control {
     
        display: inline;
        height: 40px;
        width: 500px;
        padding: 5px;
        font-size: 16px;
        margin-left: 100px;
       
   }
   
   a{
   	color: black;
   	font-weight: bold;
   	text-decoration: none;
   
   }
   
   .read{
       margin-left: 100px;

    }
    
    
    #btn{
    	border-radius: 3px;
    	background-color: #D9D7F1;
        border: none;
        width: 5rem;
        margin: auto;
        
    }
    
</style>
</head>

<body cellpadding="0" cellspacing="0" marginleft="0" margintop="0" width="100%" height="100%">
 <center>
 <a  href="/board/main.do"><img  alt="착한폰커뮤니티" width='600' height='300' src="../../css/main2.png" ></a>
</center>



<jsp:include page="/command/p_menu.jsp"></jsp:include>

<center>
<!-- <h1>글 자세히 보기</h1>
<br> -->

<p class="read">글번호</p>
<input class="form-control" value = "${bDto.num}" readonly><br>

<br>

<p class="read">작성자</p>
<input class="form-control" value = "${bDto.writer}" readonly><br>
<br>

<p class="read">작성일</p>
<input class="form-control" value = "${bDto.writeDay}" readonly><br>
<br>

<p class="read">수정일</p>
<input class="form-control" value = "${bDto.updateDay}" readonly><br>
<br>

<p class="read">조회수</p>
<input class="form-control" value = "${bDto.readcnt}" readonly><br>
<br>

<p class="read">제목</p>
<input class="form-control" value = "${bDto.title}" readonly><br>
<br>

<p class="read">내용</p>
<input style = "height:488px" class="form-control" value = "${bDto.content}" readonly><br>
<br>
</center>




<form action="/board/updateui.do">
<input type = "hidden" name = "num" value = "${bDto.num}">
<input type = "hidden" name = "writer" value = "${bDto.writer}">
<button type="submit" id="btn">수정</button>
</form>
<br>

<form action="/board/delete.do">
<input type = "hidden" name = "num" value = "${bDto.num}">
<input type = "hidden" name = "writer" value = "${bDto.writer}">
<button type="submit" id="btn">삭제</button>
</form>
<br>
<a href="/board/replyui.do?num=${bDto.num}"> 
<button type="submit" id="btn">답글</button></a>


</body>
</html>