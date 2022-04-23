<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

footer입니다

<c:forEach items="${list}" var="name">

	${name}<br>

</c:forEach>