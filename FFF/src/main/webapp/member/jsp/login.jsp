<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Insert title here</title>
 <style>
     
   
   html {
      height: 100%;
   }
   
   body {
       width:100%;
       height:100%;
       margin: 0;
        padding-top: 100px;
        padding-bottom: 40px;
        font-family: "Nanum Gothic", arial, helvetica, sans-serif;
        background-repeat: no-repeat;
   }
   
    .card {
        margin: 0 auto; /* Added */
        float: none; /* Added */
        margin-bottom: 10px; /* Added */
   }

    #btn-Yes{
        background-color: #764AF1;
        border: none;
    }
   
   .login .form-control {
        position: relative;
        height: auto;
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
            box-sizing: border-box;
        padding: 10px;
        font-size: 16px;
   }
    .checkbox{
        margin-right: 20px;
        text-align: right;
    }
    .card-title{
        margin-left: 30px;
    }

    .links{
        text-align: center;
        margin-bottom: 10px;
    }
    a{ 
       color: #764AF1; text-decoration: none; 
    }
    .check{
       color : red;
    }
    
    </style>
  </head>
<body>
<center>
<a href="/board/main.do"><img alt="착한폰마켓" width='600' height='300' src="../css/main2.png" ></a>

<br>
<br>


<br>



  <body cellpadding="0" cellspacing="0" marginleft="0" margintop="0" width="100%" height="100%" align="center">
<form action="/login.do" method="post">
   <div class="card align-middle" style="width:25rem;">
      <div class="card-title" style="margin-top:30px;">
            
         <h2 class="card-title" style="color:#f58b34;"></h2>
      </div>
      <form action="login" class="login" method="POST">
      
      <div class="card-body">
  
        <input type="text" name="id" id="Id" class="form-control" placeholder="아이디" autofocus required><BR>
        <input type="password" name="pw" id="Pw" class="form-control" placeholder="비밀번호"  required><br>
         <input  name = "url" value = "${referer}" type="hidden"><br>
        <input id="btn-Yes" class="btn btn-lg btn-primary btn-block" type="submit" value="로 그 인">
      </form>
    
      </div>
        <div class="links">
            <a href="*">아이디 찾기</a> | <a href="*">비밀번호 찾기</a> | <a href="/insertui.do">회원가입</a>

        </div>
   </div>



</form>
</center>
</body>
</html>

