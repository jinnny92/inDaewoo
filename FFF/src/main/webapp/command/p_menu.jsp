<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>   

<nav>

<style>
 .a{
	text-decoration: none;
	 color: black;
	 font-weight: bold;
} 
</style>


 <div style='float: right;'>
 <c:choose>

<c:when test="${empty login}">
<a class="a" href = "/board/main.do">홈으로 |</a>
<a class="a" href ="/myinfo.do">내정보 |</a>
<a class="a" href = "/board/list.do">자유게시판 |</a>
<a class="a" href = "/loginui.do">로그인 |</a>
<a class="a" href = "/insertui.do">회원가입</a>
</c:when>

<c:otherwise>
${login.name}님 환영합니다. 

<a class="a" href = "/board/main.do">홈으로 |</a>
<a class="a" href ="/myinfo.do">내정보 |</a>
<a class="a" href = "/board/list.do">자유게시판 |</a>
${empty login?"<a href = '/loginui.do'>로그인</a>" : "<a href = '/logout.do'>로그아웃</a>" }

</c:otherwise>
</c:choose>
</div>
<br>
<hr>
</nav>