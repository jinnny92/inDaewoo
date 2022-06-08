<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js" integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2" crossorigin="anonymous"></script>

<style type="text/css">
 #uploadFile{
       width: 100%;
       height : 250px;
       border : 1px solid red;
       
 }


</style>

</head>
<body>
<jsp:include page="../common/header.jsp"/>

<div class="jumbotron">
<h1 class="text-center">게시글등록</h1>
</div>


<form action="/board/insert" method="post">
    <div class="form-group row">
    <label for="title" class="col-sm-2 col-form-label col-form-label-lg">제목</label>
    <div class="col-sm-10">
      <input name="title" class="form-control form-control-lg" id="title" placeholder="제목 제목">
    </div>
  </div>
  
   <div class="form-group row">
    <label for="writer" class="col-sm-2 col-form-label col-form-label-lg">작성자</label>
    <div class="col-sm-10">
      <input name="writer" class="form-control form-control-lg" id="writer" placeholder="작성자 입력">
    </div>
  </div>
  
   <div class="form-group row">
    <label for="content" class="col-sm-2 col-form-label col-form-label-lg">내용</label>
    <div class="col-sm-10">
    <textarea name="content" class="form-control" id="content" rows="5"></textarea>
    </div>
  </div>
</form>

<div id="uploadFile"></div>

 <div class="form-group row">
    <input type="submit" class="form-control btn btn-danger col-sm-4 offset-sm-4" value="게시글 등록 완료" id="btn_submit">
  </div>
  
  
  
  
  <script type="text/javascript">
   $(document).ready(function() {
	   let formData = new FormData();
	   
	   $("#uploadFile").on("dragenter dragover", function(event) {
	         event.preventDefault();
	      });
	   
	   $("#uploadFile").on("drop", function(event) {
		      event.preventDefault();
		      
		      let files = event.originalEvent.dataTransfer.files;
		      
		      let file = files[0];
		      
		      formData.append("file", file);
		   });

	   
	   
		$("#btn_submit").on("click", function() {
			
			
			let title = $("#title").val();
			let writer = $("#writer").val();
			let content = $("#content").val();

			formData.append("title", title);
			formData.append("writer", writer);
			formData.append("content", content);

		
			
			
			$.ajax({
				type : "post",
				url : "/board/insert",
				processData: false,
				contentType: false,
				data : formData,
				dataType : "text",
				success : function(bno) {
				   location.assign("/board/read/"+bno);
				   
				   
				}

				
				
			});
			
		});
	   
});
  
  
  
  
  </script>

</body>
</html>