<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
	header{
		text-align: center;
	}
	
	section{
		background-color: rgb(200, 200, 200);
		height: auto;
		min-height: 100%;
		padding: 100px;
		margin: auto;
		
	}
	
	nav{
	background-color: rgb(0	, 100, 255);
		height: 50px;
	}
	
	
	nav ul li{
	list-style: none;
	float: left;
	}
	
		nav ul li a{
	text-decoration: none;
	color: white;
	display: block;
	padding: 10px;
	margin: auto;
	}
	
	footer{
		background-color: rgb(0	, 100, 255);
		height: 30px;
		color: white;
		margin: auto;
		padding: 10px;
		text-align: center;
	}
</style>

<header>
	<h1>(과정평가형 정보처리산업기사) 지역구의원투표 프로그램 ver 2020-05</h1>
</header>


<nav>
	<ul>
		<li><a href="/member/list.do">후보조회</a></li>
		<li><a href="/vote/insertui.do">투표하기</a></li>
		<li><a href="/vote/list.do">투표검수조회</a></li>
		<li><a href="/member/grade.do">후보자등수</a></li>
		<li><a href="/">홈으로</a></li>
	</ul>

</nav>