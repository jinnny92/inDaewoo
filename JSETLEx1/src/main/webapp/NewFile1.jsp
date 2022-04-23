<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- core 라이브러리 사용할 수 있도록 taglib지시어 태그 등록해주세요 -->
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<%

request.setAttribute("id", "teacheryo");
request.setAttribute("name", "홍길동");

%>


<c:out value="${id}"/>
<c:out value="${name}"/>
<br>

<!-- id가 null이 아니면 그 값을 출력하고 null이면 '로그인'을 출력하세요 -->

<c:if test="${id != null}">  
	${id}
</c:if>

<c:if test="${id == null}">
 	<a href="/loginui.do">로그인</a>


</c:if>

<c:if test="${not empty id}"> empty not empty
	${id}
</c:if>

<c:if test="${empty id}">
 	<a href="/loginui.do">로그인</a>


</c:if>



</body>
</html>