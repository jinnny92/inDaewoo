<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 검색</title>
</head>
<body>

   <h1>검색 결과</h1>

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

         <c:forEach items="${list}" var="bdto">
            <tr>
               <td>${bdto.num}</td>
               <td class="title"><a href="/board/read.do?num=${bdto.num}">
                     <c:forEach begin="1" end="${bdto.repIndent}">
               &nbsp;&nbsp;&nbsp;
            </c:forEach> ${bdto.title}
               </a></td>
               <td>${bdto.writer}</td>
               <td>${bdto.updateDay}</td>
               <td>${bdto.readcnt}</td>

            </tr>


         </c:forEach>

      </tbody>

   </table>

</body>
</html>