<%@ page language="java" contentType="text/html; charset= UTF-8"
    pageEncoding="UTF-8"%>
   
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
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
  		padding-bottom: 40px;
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
	
	
	
	.form-update {
		background-color: #FFEEEE;
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
	#email{
		padding: 10px;
  		font-size: 16px;
  		width: 300px;
        margin-left: 100px;
	}
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


    </style>
</head>
<body>
<body cellpadding="0" cellspacing="0" marginleft="0" margintop="0" width="100%" height="100%">
	<jsp:include page="/main/p_menu.jsp"></jsp:include>
	
	<div class="card" style="width:40rem;">
		<div class="card-title" style="margin-top:30px;">
            
			<h2 class="card-title" style="color:#e4932b;"></h2>
		</div>
		<div class="card-body">

<h3 align="center">회원 정보 수정</h3>

<form action="/member/update.do" method = "post">

<input type = "hidden" name ="id" value ="${dto.id}">

<p class="text">아이디</p>
 <input type="text" name = "id" value = "${dto.id}" readonly="readonly" class="form-control"><br>
<br>


 <p class="text">비밀번호</p>
<input type="password" id = "pw" name = "pw" value = "${dto.pw}" class="form-control">
<br>

<p class="text">비밀번호 확인</p>
<input type="password" id = "pw2" class="form-control" >
<br>


<p class="text">이름</p>
<input id = "name" name = "name" value = "${dto.name}" class="form-control" >
<br>
  
 
<p class="text">생년월일</p>
<input id = "birthday" name = "birthday" value = "${dto.birthday}" class="form-control">
<br>
 

<p class="text">전화번호</p>
<input id = "phonenumber" name = "phonenumber" value = "${dto.phonenumber}" class="form-control" placeholder="010-0000-0000">
<br>



<p class="text">이메일</p>
<input id = "email" name = "email" value = "${dto.email}" class="form-join">
<br>
<br>
<input type = submit value = "수정 완료" class="form-update"> 


</form>

<script type="text/javascript">

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


</body>
</html>