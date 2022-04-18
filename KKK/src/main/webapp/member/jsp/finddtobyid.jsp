<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> -->
</head>
<body>
<h1>회원 정보 자세히 보기</h1>
ID: ${dto.id}<br>
NAME: ${dto.name}<br>
AGE: ${dto.age}<br>
<br>

<a href="/list.do">목록</a>
<a href="/updateui.do?id=${dto.id}">수정 화면</a>
<a href="/deleteui.do?id=${dto.id}">회원 삭제</a> <%-- 실무용
<a href="/delete.do?id=${dto.id}">회원 삭제</a> 외부시험용 --%>

<!-- 삭제나 수정은 post방식으로 하게 되어있다. get방식으로 하면 주소창에 입력하는 것만으로도 수정과 삭제가 실행되기 때문 -->

<!-- <script type="text/javascript">
	$("document").ready(function() {
	let $delbtn = $("a[href='/delete.do?id=${dto.id}']");
	let href_val = $delbtn.attr("href");
	alert(href_val);
	});


</script> -->
</body>
</html>