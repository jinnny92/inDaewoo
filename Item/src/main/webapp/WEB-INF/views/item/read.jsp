<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품정보</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<h1>상품정보 자세히 보기</h1>

아이템코드:${iDto.iId}<br>
상품명:${iDto.iName}<br>
단가: ${iDto.iPrice}<br>
할인율(%): ${iDto.iDc}<br>
수랑: ${iDto.iCount}<br>



   <form action=""></form>
   <a href="/item/update/${iDto.iId}">수정 화면</a>
   <a href="#">삭제</a>
   <a href="/item/list">목록</a>

   <script type="text/javascript">
      $(document).ready(function() {
         $("a:eq(1)").on("click", function() {
             $("form").attr("action", "/item/delete/${iDto.iId}");
             $("form").attr("method", "post");
                 $("form").submit();
         });

      });
   </script>
</body>
</html>