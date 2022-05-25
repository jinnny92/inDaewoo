<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품등록</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<h1>상품 등록</h1>
<form action="/item/insert" method="post">


상품명: <input name="iName"><br>
가격: <input type="number" name="iPrice"><br>
할인율:<input type="number" name="iDc"><br>
상품수량: <input type="number" name="iCount"><br>
<input type="submit" value="상품등록">


</form>





<script type="text/javascript">
	$(document).ready(function() {
		
	});


</script>
</body>
</html>