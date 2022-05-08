<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<meta charset="UTF-8">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<title>내 정보 관리</title>
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
   
   h1{
   	text-align: center;
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
   
    

    #btn{
    	border-radius: 3px;
    	background-color: #D9D7F1;
        border: none;
        width: 5rem;
        margin: auto;
        
    }
    
</style>
</head>
</head>
<body>
<body cellpadding="0" cellspacing="0" marginleft="0" margintop="0" width="100%" height="100%">
 <center>
 <a  href="/board/main.do"><img  alt="착한폰커뮤니티" width='600' height='300' src="../../css/main2.png" ></a>
</center>


<jsp:include page="/command/p_menu.jsp"></jsp:include>

<h1>내 정보 관리</h1> 
<br>

<center>
<p class="read">아이디<p>
<input class="form-control" value = "${dto.id}" readonly><br>

<p class="read">비밀번호<p>
<input type="password" class="form-control" value = "${dto.pw}" readonly><br>

이름 : ${dto.name}<br>
전화번호 : ${dto.phonenumber}<br>
생일 : ${dto.birthday}<br>
이메일 : ${dto.email}<br>
<a href = "myinfoupdateui.do?=${login.id}">내 정보 수정</a>
<br>
<a href="/myinfodeleteui.do?=${login.id}">회원 탈퇴</a>
</p>
</center>


</body>
</html>