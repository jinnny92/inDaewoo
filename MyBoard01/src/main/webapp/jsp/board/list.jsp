<%@page import="kr.co.board.domain.BoardDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
<style type="text/css">
	td{
		text-align: center;
		padding: 0 5px;
		}

</style>
</head>
<body>
 <button id="btn_board_insertui" onclick="openInsertUi()">글쓰기</button>
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
<!--  외부시험용 -->
 <%-- <%
 List<BoardDTO> list= (List<BoardDTO>)request.getAttribute("list");
 
 for(int i=0; i<list.size(); i++){
	 BoardDTO dto = list.get(i);
	 pageContext.setAttribute("dto", dto);
	
	 %>
	 <tr>
	  <td>${dto.num}<td>
	 <td>${dto.title}</td>
	 <td>${dto.writer}</td>
	 <td>${dto.writeDay}</td>
	 <td>${dto.readcnt}</td>
	 <td>${dto.repRoot}</td>
	 <td>${dto.repStep}</td>
	 <td>${dto.repIndent}</td>
	 
	 </tr>
	 <% 
 }
 
 %> 
  --%>
 
 
   <c:forEach items="${list}" var="bdto">
            <tr>
               <td>${bdto.num}</td>
               <td><a href="/board/read.do?num=${bdto.num}">${bdto.title}</a></td>
               <td>${bdto.writer}</td>
               <td>${bdto.writeDay}</td>
               <td>${bdto.readcnt}</td>
               <td>${bdto.repRoot}</td>
               <td>${bddto.repStep}</td>
               <td>${bdto.repIndent}</td>

            </tr>


         </c:forEach>
 
 </tbody>
 
 
 
 </table>
 
 <script type="text/javascript">
 	function openInsertUi() {
 		location.assign("/board/insertui.do");
		
	}
 
 
 </script>
 
</body>
</html>