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
<h1>회원 목록</h1>
<% 
	List<MemberDTO> list = (List<MemberDTO>)request.getAttribute("list");

	for(int i=0;i<list.size();i++){
		MemberDTO dto = list.get(i);
	
		 out.println("ID: ");
		   out.println(dto.getId());
		   out.println("&nbsp;&nbsp;&nbsp;&nbsp;");
		   
		   out.println("NAME: ");
		   out.println(dto.getName());
		   out.println("&nbsp;&nbsp;&nbsp;&nbsp;");
		   
		   
		   out.println("AGE: ");
	       out.println(dto.getAge());
	       out.println("<br>");
	       
	 
}



%>
</body>
</html>