
<%@page import="kr.co.board.domain.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/command/p_menu.jsp"></jsp:include>


<%-- <c:choose>

<c:when test="${empty login}">
<a href = "/loginui.do">로그인</a>
</c:when>

<c:otherwise>
${login.name}님 환영합니다. <a href ="/logout.do">로그아웃</a>
</c:otherwise>

</c:choose> --%>



<h1>회원 목록</h1>
<%

	List<MemberDTO> list = (List<MemberDTO>)request.getAttribute("list");
	
	for(int i = 0 ; i < list.size() ; i++){
		
		MemberDTO dto = list.get(i);
		out.println("<a href='/finddtobyid.do?id="+dto.getId()+"'>");
		out.println("ID: ");
		out.println(dto.getId());
		out.println("</a>");
		out.println("&nbsp;&nbsp;&nbsp;&nbsp;");
		
		out.println("NAME: ");
		out.println(dto.getName());
		out.println("<br>");
		
	}
%>
<br><br>

<%-- <c:forEach items="${list }" var="dto">
<a href = "/finddtobyid.do?id=${dto.id}">%{dto.id} : ${dto.name}</a><br>

</c:forEach> --%>

</body>
</html>