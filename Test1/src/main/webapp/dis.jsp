<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>여기가 최종 화면입니다</h1>

<%

Object oHidden1 = request.getAttribute("hidden1");

if(oHidden1 instanceof String){
	String hidden1 = (String)oHidden1;
	out.print(hidden1);
	out.print("<br>");
	}
%>
<%

Object oTest1 = request.getAttribute("test1");

if(oTest1 instanceof String){
	String test1 = (String)oTest1;
	out.print(test1);
	
}

%>

<br>

${test2}

${hidden2}




</body>
</html>