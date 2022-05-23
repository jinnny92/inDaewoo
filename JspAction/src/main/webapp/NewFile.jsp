<%@page import="java.util.ArrayList"%>
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

<% /* Command클래스에서 데이터 바인딩 한 코드라고 생각하고 작업해보기  바인딩을 이용하면 정적인 include도 동적인 include로 사용할 수 있다*/
	List<String> list = new ArrayList<String>();
	list.add("kim");
	list.add("lee");
	list.add("park");
	
	request.setAttribute("list", list);

%>



<jsp:include page="p_menu.jsp">
 	<jsp:param value="Member Managment" name="member"/>
 	<jsp:param value="Item Managment" name="item"/>
 	<jsp:param value="Order Managment" name="order"/>
 	
	<!-- 바인딩을 잘 이용하면 굳이 jsp:param을 이용하지 않아도 된다 -->
</jsp:include>
<hr>
본문
<hr>
<%@ include file="p_footer.jsp" %>




</body>
</html>