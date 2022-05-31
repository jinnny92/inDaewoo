<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보자세히보기</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js" integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2" crossorigin="anonymous"></script>
</head>
<body>
<div class="jumbotron">
<h1>회원정보 자세히보기</h1>
</div>
아이디 : ${dto.id}<br>
비밀번호 : ${dto.pw}<br>
이름 : ${dto.name}<br>
생일 : ${dto.birth}<br>


<a   class="btn btn-warning" href="/member/update/${dto.id}">수정</a>
<a class="btn btn-danger delete" href="/member/delete/${dto.id}">삭제</a> 
<a class="btn btn-info" href="/member/list">목록</a>
<a class="btn btn-success reply">상담 등록</a>
<br>

<div class="collapse">
  <div class="card card-body">
   <div class="form-group row">
       <label for="replyer" class="col-sm-2 col-form-label col-form-label-lg">상담자</label>
       <div class="col-sm-10">
            <input class="form-control form-control-lg"  id="replyer"  placeholder="상담자">
       </div>
     </div>
          
   <div class="form-group row">
       <label for="replyText" class="col-sm-2 col-form-label col-form-label-lg">상담 내용</label>
       <div class="col-sm-10">
            <input class="form-control form-control-lg"  id="replyText"  placeholder="상담 내용 입력">
       </div>
     </div>
     
     <div class="form-group row">
       <input id="reply_btn_submit" class="form-control btn btn-primary col-sm-2 offset-sm-5" type="submit" value="상담 등록 완료">   
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
           <input id="item_input_update_replyer" class="form-control" >
        </div>
        <div class="form-group">
           <input id="item_input_update_replyText" class="form-control">
        </div>
      </div>
      <div class="modal-footer">
      
        <button id="item_btn_update_submit" type="button" class="btn btn-primary" data-dismiss="modal"> 수정 완료</button>
      	  <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
      </div>
    </div>
  </div>
</div>



<script type="text/javascript" src="/resources/js/tl2.js"></script>

<script type="text/javascript">
	 	let id =  "${dto.id}";
	
	
	$(document).ready(function() {
		 $(".reply").on("click", function() {
	         $(".collapse").collapse("toggle");
	      });
	 
		 
		 $("#item_btn_update_submit").click(function() {
			  let replyer = $("#item_input_update_replyer").val();
		      let replyText = $("#item_input_update_replyText").val();
		      let rno =  $("#modal_rno").text();
		     
		      $.ajax({
		    	  type : "put",
		    	  url : "/replies",
		    	  headers : {
		    		  "Content-Type" : "application/json;",
		    		  "X-Http-Method-Override" : "PUT"
		    		  
		    	  },
		    	  
		    	  data : JSON.stringify({
		    		  replyer : replyer,
		    		  replyText : replyText,
		    		  rno : rno
		    	  }),
		    	  
		    	  dataType : "text",
		    	  success : function(result) {
		    		  getAllReply(id, $("#replies"));
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
			type : "delete",
			url : "/replies",
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "DELETE"
				
			},
			data : JSON.stringify({
				rno : rno
			}),
			dataType : "text",
			success : function(result) {
				getAllReply(id, $("#replies"));
			}
			
		});
		
		
	});

	
	
	
		 
	$("#reply_btn_submit").on("click", function() {
			let replyer = $("#replyer").val();
			let replyText = $("#replyText").val();
			$("#replyer").val("");
			$("#replyText").val("");
			
			$.ajax({
				type : "post",
				url : "/replies",
				headers : {
					"Content-type" : "application/json;",
					"X-HTTP-Method-Override" : "POST"
				},
				
				data : JSON.stringify({
					replyer : replyer,
					replyText : replyText,
					id : id
					
				}),
				
				dataType : "text",
				success : function(result) {
					console.log(result);
					getAllReply(id, $("#replies"));
		
				}
				
			});
			
			
		
	});
		
	getAllReply(id, $("#replies"));
		
		
	});





</script>

</body>
</html>