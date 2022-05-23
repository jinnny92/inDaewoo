<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session = "false" errorPage = "error.jsp" %> <!-- 이 부분이 있어야 jsp 없으면 html이랑 똑같다 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body><!--  jsp는 먼저 클래스로 전환이 되고 그 다음  -->

<%

int a = 4/0;

%>





<!-- hello world (html 코드 주석) html주석은 중요한 내용 적으면 안됨-->

<%
// java 주석 html주석보다는 좋지만 jsp주석보단 별로 
%>

<%-- <%="jsp주석" html과 java주석보다 좋다 (보안이 좋다는 것) %> --%>


<% 

	String msg = "세계 보건 기구"; /* 변수를 하나 집어 넣음 */

%>

<p title = "<%=msg %>">who는 오늘 팬데믹 종료</p>

</body>
</html>