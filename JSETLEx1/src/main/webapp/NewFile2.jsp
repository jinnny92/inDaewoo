<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%

pageContext.setAttribute("score", 100);






%> <!-- command클래스에서 데이터 바인딩 해왔다고 생각하고 작업 request나 session에 바인딩 해야하는데 pageContext를 보여주고 싶었음 -->

<c:choose>
	<c:when test = "${score > 80 }">
		성적이 우수하군요
	</c:when>
	
	<c:when test = "${score > 70 }">
		성적이 보통이군요
	</c:when>
	
	
	<c:otherwise>
		불합격 입니다
	</c:otherwise>

</c:choose>




</body>
</html>