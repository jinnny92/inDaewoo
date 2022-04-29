<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- <jsp:include page=""/> 이렇게 닫으면 정적으로 사용됨 include directve tag랑 똑같음 --%>

<jsp:include page="p_menu.jsp">
	<jsp:param value="teacheryo" name="id"/>
	<jsp:param value="1234" name="pw"/>
</jsp:include>


<article>

	삭제 화면입니다

</article>
</body>
</html>