<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정화면</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<h1>상품 수정 화면</h1>
<form action="/item/update" method="post">

 <input type="hidden" name="iId" value="${iDto.iId}">
상품명: <input name="iName" value="${iDto.iName}"><br>
가격: <input type="number" name="iPrice" value="${iDto.iPrice}"><br>
할인율:<input type="number" name="iDc" value="${iDto.iDc}"><br>
상품수량: <input type="number" name="iCount" value="${iDto.iCount}"><br>
<input type="submit" value="상품수정">

</form>




</body>
</html>