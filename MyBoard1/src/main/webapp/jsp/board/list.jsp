<<<<<<< HEAD
<%@page import="kr.co.board.domain.BoardDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
</head>
<body>

	<a href="/board/insertui.do">글쓰기</a>

	<h1>게시글 목록</h1>
	
	<table>
		<thead>
			<tr>
				<th>num</th>
				<th>title</th>
				<th>writer</th>
				<th>writeday</th>
				<th>readcnt</th>
				<th>repRoot</th>
				<th>repStep</th>
				<th>repIndent</th>
			</tr>
		</thead>
		<tbody>
		
		
		<%
			List<BoardDTO> list = (List<BoardDTO>)request.getAttribute("list");
			for(int i=0;i<list.size();i++){
				BoardDTO dto = list.get(i);
				
				%>
				<tr>
				<td><%=dto.getNum()%></td>
				<td><a href="/board/read.do?num=<%=dto.getNum()%>"><%=dto.getTitle()%></a></td>
				<td><%=dto.getWriter()%></td>
				<td><%=dto.getWriteDay()%></td>
				<td><%=dto.getReadcnt()%></td>
				<td><%=dto.getRepRoot()%></td>
				<td><%=dto.getRepStep()%></td>
				<td><%=dto.getRepIndent()%></td>
				</tr>
				<%
				
			}
		%>
		
		
		
		
		
		
		
			
<%-- 			<c:forEach items="${list}" var="bdto">
			<tr>
				<td>${bdto.num}</td>
				<td><a href="/board/read.do?num=${bdto.num}">${bdto.title}</a></td>
				<td>${bdto.writer}</td>
				<td>${bdto.writeDay}</td>
				<td>${bdto.readcnt}</td>
				<td>${bdto.repRoot}</td>
				<td>${bdto.repStep}</td>
				<td>${bdto.repIndent}</td>
				
			</tr>
			
			
			</c:forEach> --%>
					
		</tbody>
		
	</table>

=======
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
</head>
<body>
<h1>글 목록</h1>
>>>>>>> refs/remotes/origin/master

</body>
</html>