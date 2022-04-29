<%@page import="java.util.List"%>
<%@page import="kr.co.dw.member.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%--     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="/insertui.do">회원등록</a> 

<%-- ${login == null?"<a href = '/loginui.do'>로그인</a>":"<a href = '/logout.do'>로그아웃</a>"}<br> --%>
${empty login? "<a href = '/loginui.do'>로그인</a>":"<a href = '/logout.do'>로그아웃</a>"}<br>


<%-- <c:if test="${empty login}">
<a href='/loginui.do'>로그인</a>

</c:if>

<c:if test="${not empty login}">
${login.name} 님, 환영합니다. <a href="/logout.do">로그아웃</a>
</c:if>

 <a href="/loginui.do">로그인화면</a> 
  --%>
<%--  <%@ include file="../../common/jsp/p_menu.jsp" %> --%>


<h1>회원 정보</h1>

<%
		Object oList =  request.getAttribute("list");
		if(oList != null){
			List<MemberDTO> list = (List<MemberDTO>) oList;
			for(int i=0;i<list.size();i++){
				MemberDTO dto = list.get(i);
				
				 	out.println("ID: ");
				   out.println(dto.getId());
				   out.println("&nbsp;&nbsp;&nbsp;&nbsp;");
				   out.println("&nbsp;&nbsp;&nbsp;&nbsp;");
				   
				   out.println("NAME: ");
				   out.println(dto.getName());
				   out.println("&nbsp;&nbsp;&nbsp;&nbsp;");
				   out.println("&nbsp;&nbsp;&nbsp;&nbsp;");
				   
				   out.println("AGE: ");
			       out.println(dto.getAge());
			       out.println("<br>");
				
				%>
				
				
				ID: <a href="/finddtobyid.do?id=<%=dto.getId()%>">
				<%=dto.getId() %></a>
				NAME: <%=dto.getName()%>
				
				<%
			}
		}
	
		
	
	%>
	
</body>
</html>