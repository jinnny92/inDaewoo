<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js" integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2" crossorigin="anonymous"></script>
</head>
<body>

<button>첨부파일 추가</button>

<form action="/uploadform" method="post" enctype="multipart/form-data"> <!-- 파일을 업로드하려면 enctype에 이렇게 넣어줘야함 -->
	<input name="id"><br>
	<input type="file" name="file"><br> <!-- 파일을 업로드하려면 타입이 파일이 되어야함 -->
	<!-- <input type="submit" value="제출"> -->
</form>

	 <input type="submit" value="제출"> 

<script type="text/javascript">
$(document).ready(function(){
	   
	/*    $("button").click(function(){
	     $("br:last").after('<input type="file" name="file"><br>');
	   });
	    */
	    $("input[type='submit']").click(function(){
	   $("form").submit();   
	   });
	   
	   
	   
	$("button").click(function(){
	   $("form").append('<input type="file" name="file"><br>');

	     });
	    
	});



</script>
</body>
</html>