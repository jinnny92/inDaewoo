<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
   
    .card {
        margin: 0 auto; 
        float: none; 
        margin-bottom: 10px;
        border: none;
   }
   
   .form-control {
      align-content: center;
        display: inline;
        height: 40px;
        width: 450px;
        padding: 5px;
        font-size: 16px;
        margin-left: 100px;
       
   }
   
    #btn-Yes,#btn_cancel{
       	align-content: center;
        background-color: #BAABDA;
        border-radius: 8px;
        border: none;
        width: 200px;
  	    height: 50px;
        margin: auto;
        
    }
   
   .text{
       margin-left: 100px;
    }
    
   .card-title{
       
        text-align: center;
    }
    
</style>
</head>

  <body cellpadding="0" cellspacing="0" marginleft="0" margintop="0" width="100%" height="100%">
<center>
   <a  href="/board/main.do"><img  alt="착한폰커뮤니티" width='600' height='300' src="../../css/main2.png" ></a>
</center>
<br>


   <div class="card" style="width:40rem;">
      <div class="card-title" style="margin-top:30px;">
            
         <h2 class="card-title" style="color:#e4932b;"></h2>
      </div>
      <div class="card-body">
      
      
<h1 align="center">게시글 작성</h1>
<form action="/board/insert.do" method="post">

<hr>

<p class="text">작성자</p>
<input type="text" name="writer" class="form-control" value = "${login.id}"  readonly ><br>
<br>


<p class="text">제목</p>
<input type="text" name="title" class="form-control" required><br>
<br>


<p class="text">내용</p>
<textarea style="height:488px;" name = "content" class="form-control" ></textarea><br>
<br>

<input type="submit" id = "btn-Yes" value="글 작성 완료"> 
&nbsp;&nbsp;<input type="button"  id = "btn_cancel" value="작성취소" onclick="history.back()">

</form>


</body>
</html>