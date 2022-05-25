<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품목록</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<h1>상품목록</h1>
<table border="1px">
	<thead>
		<tr>
			<th>상품번호</th>
			<th>상품명</th>
			<th>상품단가</th>
			<th>할인율(%)</th>
			<th>상품수량</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${iList}" var="list">
			<tr>
				<td>${list.iId}</td>
				<td><a href="/item/read/${list.iId}">${list.iName}</a></td>
				<td>${list.iPrice}</td>
				<td>${list.iDc}</td>
				<td>${list.iCount}</td>
			</tr>
		</c:forEach>
	</tbody>
	
</table>





<script type="text/javascript">
	$(document).ready(function() {
		
	});


</script>
</body>
</html>