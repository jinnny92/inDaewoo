<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 자세히 보기</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&display=swap" rel="stylesheet">

<style type="text/css">

*{
	font-family: 'Noto Sans KR', sans-serif;
	font-size: xx-large;	}
</st</style>

</head>
<body>
<jsp:include page="/main/p_menu.jsp"></jsp:include>

<form action="/member/delete.do" method="post" id = "form">
<input type = "hidden" name = "id" value = "${mdto.id}">


아이디:${mdto.id}<br>
이름:${mdto.name}<br>
나이:${mdto.age}<br>

<button onclick="/member/updateui.do?id=${mdto.id}">회원 정보 수정</button> <br>
<button onclick="if(!confirm('정말 탈퇴하시겠습니까?')){return false;}">회원 탈퇴</button> <br>


<script type="text/javascript">

function delete() {
	if(!confirm('정말 삭제하시겠습니까?')){
		document.getElementById("form").submit();
		}else{
			return false;
		}
}

$(function(){
	
	$('#delete').click(function(){
		if(!confirm('정말 삭제하시겠습니까?')){
			document.getElementById("form").submit();
			}else{
				return false;
			}
		
	}
}
</script>
</body>
</html>