<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	
	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<a class="hello"> hello </a>
	<a class="world">world</a>
	<a id="good">good</a>
	<a href="hello.do">morning</a>
	<input value="kim">
	
	<script type="text/javascript">
	$(document).ready(function(){
				$("a").css("border", "1px solid red");
				let = $("a.hello").text();
				
				alert(text);
				$("a.world").text("WORLD");
				$("a#good").text("GOOD");
				 let msg = $("input").val();
				 alert(msg);
				 
			});
	
	
	</script>
	
	
</body>
</html>