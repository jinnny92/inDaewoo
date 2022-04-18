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

/*  <% jsp문법중에 가장 많이 사용하는 태그 : 스크립틀릿. 
이 태그에서 jsp의 모든 태그가 파생이되고 이 안에 선언된 변수는 지역변수로 인식됨
이 안에 적은건 다 서비스라는 메서드 안에 들어간다 
 */
Object oList = request.getAttribute("list");
if(oList != null){
	List<MemberDTO> list = (List<MemberDTO>)oList;
	for(int i = 0; i < list.size(); i++){
		MemberDTO dto = list.get(i);
		
		out.println("ID: ");
		out.println(dto.getId());
		out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		
		out.println("NAME: ");
		out.println(dto.getName());
		out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		
		out.println("AGE: ");
		out.println(dto.getAge());
		out.println("<br>");
		
		%>
		
		ID: <a href="/finddtobyid.do?id=<%=dto.getId()%>">
		<%=dto.getId() %></a>
		
		NAME: <%=dto.getName() %>
		<%
		
		/* <%=dto. 자바 변수로 선언한 애는 어쩔수없이 익스프레션태그로 사용 */
	}	
	
}



%>
</body>
</html>