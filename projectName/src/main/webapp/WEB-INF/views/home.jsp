<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<meta charset="UTF-8">
   <title>Home</title>
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>





<div id="orgDiv">
		
	<div class="item">
		<p>id1</p>
		<p>name1</p>
		<p>age1</p>
		<button class="btn_del">삭제</button>
	</div>
	
	<div class="item">
		<p>id2</p>
		<p>name2</p>
		<p>age2</p>
		<button class="btn_del">삭제</button>
	</div>

</div>


<jsp:forward page="/member/list"/>

<script type="text/javascript">
	$(document).ready(function() {
		$("#orgDiv").on("click", ".btn_del", function() {
			$(this).parent().remove();
		});
	});


</script>

</body>
</html>
