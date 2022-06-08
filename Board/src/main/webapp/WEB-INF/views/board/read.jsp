<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 자세히 보기</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js" integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2" crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="../common/header.jsp"/>

<div class="jumbotron">
   <h1 class="text-center">글 자세히 보기</h1>
</div>

  <div class="form-group row">
    <label for="bno" class="col-sm-2 col-form-label col-form-label-lg">글번호</label>
    <div class="col-sm-10">
      <input readonly class="form-control form-control-lg"  id="bno" value="${bDto.bno}">
    </div>
  </div>
  
  <div class="form-group row">
    <label for="writer" class="col-sm-2 col-form-label col-form-label-lg">작성자</label>
    <div class="col-sm-10">
      <input readonly class="form-control form-control-lg"  id="writer" value="${bDto.writer}">
    </div>
  </div>
  
  <div class="form-group row">
    <label for="regDay" class="col-sm-2 col-form-label col-form-label-lg">작성일</label>
    <div class="col-sm-10">
      <input readonly class="form-control form-control-lg"  id="regDay" value="${bDto.regDay}">
    </div>
  </div>
  
  <div class="form-group row">
    <label for="updateDay" class="col-sm-2 col-form-label col-form-label-lg">수정일</label>
    <div class="col-sm-10">
      <input readonly class="form-control form-control-lg"  id="updateDay" value="${bDto.updateDay}">
    </div>
  </div>

  <div class="form-group row">
    <label for="title" class="col-sm-2 col-form-label col-form-label-lg">글제목</label>
    <div class="col-sm-10">
      <input readonly class="form-control form-control-lg"  id="title" value="${bDto.title}">
    </div>
  </div>
  

  
   <div class="form-group row">
    <label for="content" class="col-sm-2 col-form-label col-form-label-lg">내용</label>
     <div class="col-sm-10">
       <textarea readonly class="form-control" id="content" rows="5">${bDto.content}</textarea>
     </div>   
  </div>











<a class="btn btn-warning" href="/board/update/${bDto.bno}">수정</a> 
<a class="btn btn-danger delete" href="#">삭제</a> 
<a class="btn btn-info" href="/board/list">목록</a> 
<a class="btn btn-success reply">댓글</a>
<br>
<br>

<div class="collapse">
  <div class="card card-body">
   <div class="form-group row">
       <label for="replyer" class="col-sm-2 col-form-label col-form-label-lg">댓글 작성자</label>
       <div class="col-sm-10">
            <input class="form-control form-control-lg"  id="replyer"  placeholder="댓글 작성자 입력">
       </div>
     </div>
          
   <div class="form-group row">
       <label for="replyText" class="col-sm-2 col-form-label col-form-label-lg">댓글</label>
       <div class="col-sm-10">
            <input class="form-control form-control-lg"  id="replyText"  placeholder="댓글 입력">
       </div>
     </div>
     
     <div class="form-group row">
       <input id="reply_btn_submit" class="form-control btn btn-primary col-sm-2 offset-sm-5" type="submit" value="댓글 작성 완료">   
    </div>    
    
  </div>
</div>


<form action="">
</form>

<div id="replies">
</div>






<!-- Modal -->
<div class="modal fade" id="myModal" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">rno: <span id="modal_rno">5</span></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
         <div class="form-group">
           <input id="item_input_update_replyer" class="form-control" value="홍길동">
        </div>
        <div class="form-group">
           <input id="item_input_update_replyText" class="form-control" value="아버지를 아버지라 부르지 못 하고">
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
        <button id="item_btn_update_submit" type="button" class="btn btn-primary" data-dismiss="modal">댓글 수정 완료</button>
      </div>
    </div>
  </div>
</div>



<div id="uploadedItems">
</div>


<script type="text/javascript" src="/resources/js/tl.js"></script>

<script type="text/javascript">
   let bno = ${bDto.bno};
   let filenameList = "${filenameList}";
   let formData = new FormData();
     
   
   $("#uploadFile").on("dragenter dragover", function(event) {
       event.preventDefault();
    });
   
   $("#uploadFile").on("drop", function(event) {
	event.preventDefault();
	let files =   event.originalEvent.dataTransfer.files;
   let file = files[0]; 
   formData.append("file", file);  
   
   $.ajax({
		        type : "post",
		         url : "/board/insert",
		          processData : false,  /* true가 되면 쿼리스트링형태로 주소창에 이 데이터가 딸려서 넘어가기때문에 false로 */ 
		          contentType: false,
		             data : formData,
		             dataType : "text",
		             success : function(bno){
		            	 filename = bno; //나중엔 bno값을 넘겨주게 만들것이다
		            	 bno = bno.substring(1, bno.length-1).trim();
		                 
		                 let str = makeUploadItemTag2(bno);
		            	 
		            	    $("#uploadedItems").append(str);
		            	    
		            	 location.assign("/board/read/"+bno);
		                }

		    });
		 
   });
   
		 
   
   $(function() {
      
      $("#item_btn_update_submit").click(function() {
         let replyer = $("#item_input_update_replyer").val();
         let replyText = $("#item_input_update_replyText").val();
     	 let rno =  $("#modal_rno").text();
     	 
     	 
     	 $.ajax({
     			/* 중괄호 열고 닫힌거 = 객체 이 안에 객체 넣어주기 */
     		 	type : "put", /* 입력 포스트 가져올때 겟 수정할땐 put 삭제할때 delete */
     		 	url : "/replies",
  				headers : {
  					"Content-Type" : "application/json; charset=UTF-8", /* 큰 따옴표로 감싸져 있으니 제이슨 */
  					"X-HTTP-Method-Override" : "PUT"
  				},  		 	
	     		
  				data : JSON.stringify({ /* 함수니까 객체를 집어넣음 */
  					replyer : replyer,
  					replyText : replyText,
  					rno : rno
  					
  				}),
     		 
				dataType : "text",
				success : function(result) {
					//alert(result); // 객체를 출력할 땐 console.log,  문자를 출력할땐 alert
					getAllReply(bno, $("#replies"));
				}
  				
     	 }); 
     	 
         
      });
      
      
      $("#replies").on("click", ".item_btn_update", function() {
         $("#myModal").modal("show");
         
         let replyer = $(this).prev().prev().text();
         let replyText = $(this).prev().text();
         let rno = $(this).attr("data-rno");
         
         
         $("#item_input_update_replyer").val(replyer);
         $("#item_input_update_replyText").val(replyText);
         $("#modal_rno").text(rno);
         
        
         
         
      });
      
      
      $("#replies").on("click", ".item_btn_delete", function() {
         let rno = $(this).attr("data-rno");
         $.ajax({
            type : 'delete',
            url : '/replies',
            headers : {
               "Content-Type" : "application/json",
               "X-HTTP-Method-Override" : "DELETE"
            },
            data : JSON.stringify({
               rno : rno
            }),
            dataType : 'text',
            success : function(result) {
               getAllReply(bno, $("#replies"));
            }
            
         });
      });
      
      
      
      $("#reply_btn_submit").on("click", function() {
         let replyer = $("#replyer").val();
         let replyText = $("#replyText").val();
         $("#replyer").val("");
         $("#replyText").val("");

         $.ajax({
            type : 'post',
            url : '/replies',
            headers : {
               "Content-Type" : "application/json",
               "X-HTTP-Method-Override" : "POST"
            },
            data : JSON.stringify({
               replyer : replyer,
               replyText : replyText,
               bno : bno
            }),
            dataType : 'text',
            success : function(result) {
            	if (result) {
            		getAllReply(bno, $("#replies"));
				}else{
					alert("입력에 실패했습니다");
				}
               
               
            }
            
         });
         
         
      });
      
      
      
      
      
      $(".reply").on("click", function() {
         $(".collapse").collapse("toggle");
      });
      
      
      
      $(".delete").on("click", function() {
         $("form")
         .attr("action", "/board/delete/${bDto.bno}")
         .attr("method", "post")
         .submit();
      });
      
      
      
      getAllReply(bno, $("#replies"));
      
   });


</script>
</body>
</html>