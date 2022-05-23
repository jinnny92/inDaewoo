<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:out value="hello world"/>
<br>
${"hello world"}
<br>
<%="hello" %> 

<c:set var="id" value="teacheryo"/>
<c:out value="${id}"/>


<c:set var="pw" value="1234"/>

<c:if test="${pw == 1234 }">

정답입니다.

</c:if>


<c:if test="${pw != 1234 }">

정답이 아닙니다.

</c:if>


</body>
</html>