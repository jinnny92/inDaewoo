<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일반 컨트롤러를 이용한 Ajax 구현2</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js" integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2" crossorigin="anonymous"></script>
</head>
<body>
<body>
   <h1>일반 컨츠롤러를 이용한 Ajax 구현2</h1>

   <%
   ObjectMapper oMapper = new ObjectMapper();
   String list = oMapper.writeValueAsString(request.getAttribute("list"));
   pageContext.setAttribute("list", list);
   %>
<p>${list}</p>
<p id="hello">hello</p>

   <button>클릭하면 Ajax 통신이 이뤄짐</button>
   
   <div id="result">
   
   
   </div>
   <script type="text/javascript" src="resources/js/tl.js">
   
   
   
   </script>
   <script type="text/javascript">
   
   $(document).ready(function(){
   $("button").on("click", function() {
      let list = '${list}';
      let hello = $("#hello").text();
      
      
      $.ajax({
         type : "post", 
         url : "/gat2",
         data: {
            list: list,
            hello : hello
         },
         
         dataType : "text",
         success : function(result){
            
            console.log(result);
            
            result = JSON.parse(result)
            
            
            for(let i=0;i<result.length;i++){
               for(x in result[i]){
                  
                  let str = makeItemTag(result[i]);
                  
                  $("#result").append(str);
                  
               }
            }
            
         }
         
      });
      
      
   });   
   
   
   });
   
   
   </script>

</body>
</html>