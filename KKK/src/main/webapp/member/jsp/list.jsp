<%@page import="kr.co.dw.member.dto.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="/insertui.do"> 회원등록 </a>
<h1>회원 목록</h1>
<% 
	List<MemberDTO> list = (List<MemberDTO>)request.getAttribute("list");

	for(int i=0;i<list.size();i++){
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
</body>
</html>