<%@page import="kr.co.domain.MemberDTO"%>
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

	<%
		Object oList =  request.getAttribute("list");
		if(oList != null){
			List<MemberDTO> list = (List<MemberDTO>) oList;
			for(int i=0;i<list.size();i++){
				MemberDTO dto = list.get(i);
				%>
				
				ID: <a href="/finddtobyid.do?id=<%=dto.getId()%>"><%=dto.getId() %></a>
				NAME: <%=dto.getName()%>
				
				<%
			}
		}
	
		
	
	%>

</body>
</html>