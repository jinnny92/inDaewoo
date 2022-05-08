<%@ page language="java" contentType="text/html; charset= UTF-8"
    pageEncoding="UTF-8"%>
   
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<title>회원가입</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&display=swap" rel="stylesheet">

<style>
   
   *{
   font-family: 'Noto Sans KR', sans-serif;
   }
   
   
   html {
      height: 100%;
   }
   
   body {
       width:100%;
       height:100%;
       margin: 0;
        padding-top: 8px;
        padding-bottom: 200px;
        background-repeat: no-repeat;
   }
   
    .card {
        margin: 0 auto; 
        float: none; 
        margin-bottom: 10px;
        border: none;
   }

    submit{
        background-color: rgb(250, 164, 3);
        border: none;
        width: 25rem;
        margin: auto;
        
    }
   
   .form-tel {
      
      display: inline;
        height: 40px;
        width: 133px;
        padding: 5px;
        font-size: 16px;
        margin-left: 10px
       
       
   }
   
   
   
   .form-join {
      background-color: #B667F1;
      border: none;
      width: 25rem;
        display: inline;
        margin: auto;
        height: 40px;
        width: 400px;
        padding: 5px;
        font-size: 16px;
        margin-left: 100px;
       
   }
   
   .form-control {
        display: inline;
        height: 40px;
        width: 400px;
        padding: 5px;
        font-size: 16px;
        margin-left: 100px;
       
   }

    #member_id {
        padding: 10px;
        font-size: 16px;
        width: 250px;
        margin-left: 100px;
   }
   /* #email{
      padding: 10px;
        font-size: 16px;
        width: 300px;
        margin-left: 100px;
   } */
    .check{
       font-size: 16px;
       margin-left: 100px;
    }
    .card-title{
       
        text-align: center;
    }

    .text{
       margin-left: 100px;
    }
    
    .phonenumber1{
       display: block; 
       margin: auto;
    }

   span.massage{
   font-size: 14px;
    color: #333;
    display: block;
      margin: auto;
    padding: 20px 0 30px;
    line-height: 24px;
    text-align: center;
      }
      
    </style>
  </head>
   
<body cellpadding="0" cellspacing="0" marginleft="0" margintop="0" width="100%" height="100%">
   <div class="card" style="width:40rem;">


<a href="/board/main.do"><img alt="착한폰마켓" width='600' height='300' src="../../css/main2.png" ></a>
	
<br>
<br>
      
      
<h1 align="center">착한폰마켓 커뮤니티 회원가입</h1>

<span class="massage" >
   "지금 바로 신규회원 가입하고 엄청난 핸드폰 정보를 만나보세요!"
   <br>
   "회원가입시, "<img src="https://www.good-phone.net/pc/img/sub/join_medal.png"><b>착한폰마켓 할인 쿠폰</b>
   "을 드립니다!"
   
</span>

<form action="/insert.do" method="post">


<p class="text">아이디</p>
<input type="text" name="id" id="id"  class="form-control" ><br>
<br>


 <p class="text">비밀번호</p>
<input type="password" name="pw" id="pw" class="form-control" ><br>
<br>



<p class="text">비밀번호 확인</p>
<input type="password"  id="pw2" class="form-control" ><br>
<p id="pwck" class="check"> </p>


<p class="text">이름</p>
<input type="text" name="name" id="name"  class="form-control" ><br>
<br>

<p class="text">생년월일</p>
<input type="text" name="birthday" id="birthday"  class="form-control" placeholder="ex) 2022-05-04"><br>
<br>
   
   
<p class="text">전화번호</p>
<input type="text" name="phonenumber" id="phonenumber"  class="form-control" placeholder="ex) 010-0000-0000"><br>
   <br>



<p class="text">이메일</p>
<input type="text" name="email" id="email"  class="form-control" placeholder="ex) abc123@naver.com">
<br>
<br>

<input type = "submit"  value ="회원 가입하기" class="form-join">

 <br>

</form>

<br>


<footer class="text-muted py-5" align="center">
  <div class="container">
    <p class="float-end mb-1"> </p>
    <p class="mb-1">착한폰마켓 &copy;  회사명ㅣ 주식회사 YWBJ &nbsp;  대표ㅣ최원진 </p>
    <p class="mb-0">고객센터 <a href="https://www.good-phone.net/board/list/qna" style="text-decoration:none">고객행복센터</a> &nbsp; 바로지원상담 <a href="https://qoxe9.channel.io/lounge" style="text-decoration:none">카카오톡상담</a></p>
  </div>
</footer>

<script type="text/javascript">


   function checkEmail() {
      window.open("emailcheck.jsp", "emailcheck", "width=400, height = 250");
   }



$("#pw2").keyup(function(){
      
    if($(this).val()!=$("#pw").val()){
        $("#pwck").html("비밀번호가 다릅니다");
        $("#pwck").css("color",'red');
        pwc = false;

    }else{
        $("#pwck").html("비밀번호가 일치합니다");
        $("#pwck").css("color",'blue');
        pwc = true;
    }
});



$("#pw").keyup(function(){
    
    if($(this).val()!=$("#pw2").val()){
        $("#pwck").html("비밀번호가 다릅니다");
        $("#pwck").css("color",'red');
        pwc = false;

    }else{
        $("#pwck").html("비밀번호가 일치합니다");
        $("#pwck").css("color",'blue');
        pwc = true;
    }
});



</script>
</html>