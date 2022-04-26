<%@page import="kr.co.board.domain.BoardDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록2</title>
<style type="text/css">
	td{
		text-align: center;
		padding: 0 5px;
		}

td.title{
	text-align : left

}


td.title a{
	text-decoration : none;
}

.red{
	color : red;
	text-decoration : none;
	
	
}
</style>
</head>
<body>
 <button id="btn_board_insertui" onclick="openInsertUi()">글쓰기</button>
 <h1>게시글 목록2</h1>

<table>
      <thead>
         <tr>

            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
            <th>조회수</th>
            
         </tr>
      </thead>
     <tbody>



   <c:forEach items="${pt.list}" var="bdto">
           <tr>
               <td>${bdto.num}</td>
               <td class="title">
                  <a href ="/board/read.do?num=${bdto.num}">
                  <c:forEach begin="1" end="${bdto.repIndent}">
                  &nbsp;&nbsp;&nbsp;
                  </c:forEach>

              	 ${bdto.title}
              	 </a>
              	 </td>
                <td>${bdto.writer}</td>
               <td>${bdto.updateDay}</td>
               <td>${bdto.readcnt}</td>
               
            </tr>


         </c:forEach>

      </tbody>

   </table>
   

 
 <a href="/board/list.do?curPage=${pt.curPage-1}">&laquo;</a>
 <c:forEach var="i" begin="${pt.beginPageNum}" end="${pt.finishPageNum}">
 	<a href="/board/list.do?curPage=${i}" class = "${i == pt.curPage?'red':''}">${i}</a> 
 	
 

 </c:forEach>
 <a href="/board/list.do?curPage=${pt.curPage+1}"> &raquo;</a>
 
 
 <script type="text/javascript">
 	function openInsertUi() {
 		location.assign("/board/insertui.do");
		
	}
 
 
 </script>
 
</body>
</html>