<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정 화면</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js" integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2" crossorigin="anonymous"></script>
</head>
<body>

<jsp:include page="../common/header.jsp"/>

<div class="jumbotron">
<h1 class="text-center">게시글 수정</h1>
</div>



<form action="/board/update" method="post">
<input type="hidden" name="bno" value="${bDto.bno}">
    <div class="form-group row">
    <label for="title" class="col-sm-2 col-form-label col-form-label-lg">제목</label>
    <div class="col-sm-10">
      <input name="title" class="form-control form-control-lg" id="title" value="${bDto.title}">
    </div>
  </div>
  
   <div class="form-group row">
    <label for="writer" class="col-sm-2 col-form-label col-form-label-lg">작성자</label>
    <div class="col-sm-10">
      <input name="writer" class="form-control form-control-lg" id="writer"  value="${bDto.writer}">
    </div>
  </div>
  
   <div class="form-group row">
    <label for="content" class="col-sm-2 col-form-label col-form-label-lg">내용</label>
    <div class="col-sm-10">
    <textarea name="content" class="form-control" id="content" rows="5">${bDto.content}</textarea>
    </div>
  </div>
</form>


<div id="uploadedItems" class="row row-cols-1 row-cols-3">
</div>

<div class="form-group row">
    <input id="btn_submit" type="submit" class="form-control btn btn-danger col-sm-4 offset-sm-4" value="수정 완료">
  </div>

<script type="text/javascript" src="/resources/js/tl.js"></script>
<script type="text/javascript">

 	$(function() {
 		let bno = ${bDto.bno};
 		
 		let formData = new FormData();
 		
 		let deleteFilenameArr = []; //삭제버튼을 누르면 화면상에선 삭제가 되지만 DB에서는 수정완료 버튼을 누를때까지 살아있다
 		
 		

 		
 		getAllUploadForUpdateUI(bno, $("#uploadedItems"));
 	
 	
 		$("#uploadedItems").on("click", ".btn_del_item", function() {
			let filename =	$(this).attr("data-filename");
			deleteFilenameArr.push(filename);//	deleteFilenameArr.push(filename); 이런식으로 사용하면된다
			console.log(deleteFilenameArr);
 			$(this).parent().parent().parent().remove(); //div속에 div속에 div를 삭제 하기 위해서  parent()를 세번 썼다 (div)로 몇 번 감싸고 있는지 확인할것
 		});
 	
 	//삭제버튼은 동적으로 생성됐기 때문에 click이라는 이벤트를 사용하지 못하고 on이라는 이벤트만을 사용해야한다
 	
 		
 		$("#btn_submit").click(function() {
 			formData.append("bno", bno); //게시글 제목이나 내용이 수정될 수 있으므로 bno값을 가져가야 한다. 그러기 위해 formData에 bno값을 추가 해준 것
 			let title = $("#title").val();
 			formData.append("title", title);
 			
 			let writer = $("#writer").val();
 			formData.append("writer", writer);
 			
 			let content = $("#content").val();
 			formData.append("content", content);
 			
 			
 			
 			formData.append("deleteFilenameArr", deleteFilenameArr);
 			
 			
 		   $.ajax({
 		        type : "post",
 		         url : "/board/update",
 		          processData : false,  /* true가 되면 쿼리스트링형태로 주소창에 이 데이터가 딸려서 넘어가기때문에 false로 */ 
 		            contentType: false,
 		             data : formData,
 		             dataType : "text",
 		             success : function(result){
 		            	 
 		            	 if (result == "SUCCESS") {
							location.assign("/board/read/"+bno);
						} else {
							alert("수정실패");
						}
 		              
 	                }
 	
 		    });
		
		});
 		
	});
 	



</script>

</body>
</html>