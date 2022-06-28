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




<!-- 업로드한 파일들의 썸네일  -->
<div id="uploadedItems" class="row row-cols-lg-3">
</div>




<!--read페이지의 메뉴  -->
<a class="btn btn-warning" href="/board/update/${bDto.bno}">수정</a> 
<a class="btn btn-danger delete" href="#">삭제</a> 
<a class="btn btn-info goback" href="#">목록</a> 
<a class="btn btn-success reply">댓글</a>
<br>
<br>

<!-- collapse : 댓글 작성용 양식  -->
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

<!-- 게시글을 post방식으로 삭제하기 위한 form태그  -->
<form action="">
</form>

<!-- 댓글 출력 영역  -->
<div id="replies">
</div>






<!-- Modal 댓글 수정 양식 -->
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






<script type="text/javascript" src="/resources/js/tl.js"></script>

<script type="text/javascript">
   let bno = ${bDto.bno}; /*read.jsp 댓글을 출력해야 하는데 특정 bno에 대한 댓글을 다 가져와야하고 첨부파일도 가져와서 썸네일에 찍어줘야하고   */
   
   //DB쪽에서 가져오기, get제이슨 이용하기, 특정 bno를 이용하기
   
		 
   
   $(function() {
	   
	   
	   getAllUpload(bno, $("#uploadedItems")); /*특정 bno이 첨부파일 tl.js에 있음   */
	   
	   $(".goback").click(function() {
			history.go(-1);
	});
	   
      
      $("#item_btn_update_submit").click(function() {/*아이디가 item_btn_update_submit인 파일을 클릭하면 function()의 내용이 실행 된다 사실상 수정버튼  */
         let replyer = $("#item_input_update_replyer").val(); /*아이디가 item_input_update_replyer인 input태그의 value값을 가져와서 replyer 변수에 대입 */
         let replyText = $("#item_input_update_replyText").val(); /* 아이디가 item_input_update_replyText인 input태그의 value 값을 가져와서 replyText변수에 대입  */
     	 let rno =  $("#modal_rno").text(); /* 아이디가  modal_rno span태그의 텍스트값을 가져와서 rno 변수에 대입*/
     	 
     	 
     	 $.ajax({
     			/* 중괄호 열고 닫힌거 = 객체 이 안에 객체 넣어주기 */
     		 	type : "put", /* 래스트컨트롤러 이기 때문에 입력 포스트 가져올때 겟 수정할땐 put 삭제할때 delete 여기선 post방식으로 데티어 전송 */
     		 	url : "/replies", /*url이 /replies인 곳과 통신  */
  				headers : {
  					"Content-Type" : "application/json; charset=UTF-8", /* 큰 따옴표로 감싸져 있으니 제이슨, 한글로 데이터 전송 */
  					"X-HTTP-Method-Override" : "PUT"
  				},  		 	
	     		
  				data : JSON.stringify({ /* 함수니까 객체를 집어넣음 얘가 제이슨 형태의 문자열로 만들어 준다 */
  					replyer : replyer, /*replyer라는 객체를 replyer라는 변수에 대입 */
  					replyText : replyText, /*replyText라는 객체를 replyText라는 변수에 대입 */
  					rno : rno /*rno라는 객체를 rno라는 변수에 대입 */
  					
  				}),
     		 
				dataType : "text", ,/* 통신이 끝날 때 서버에서 넘여주는 데이터의 형태 */
				success : function(result) {
					//alert(result); // 객체를 출력할 땐 console.log,  문자를 출력할땐 alert
					if (result == "SUCCESS") {
						getAllReply(bno, $("#replies"));  /* tl.js에서 getAllReply함수 호출 */
					}
					
				}
  				
     	 }); 
     	 
         
      });
      
      
      $("#replies").on("click", ".item_btn_update", function() { /* 아이디가 replies인  버튼을 클릭하면 function()의 내용이 실행된다    */
         $("#myModal").modal("show"); /* 아이디가 myModal modal을 열어주는 코드  */
         
         let replyer = $(this).prev().prev().text(); /*방금 누른 클래스의 전, 전 텍스트 값을 가져와서 replyer 변수에 대입한다  */
         let replyText = $(this).prev().text(); /* 방금 누른 클래스의 전 텍스트 값을 가져와서 replyText 변수에 대입한다  */
         let rno = $(this).attr("data-rno"); /* 방금 누른 클래스의 태그에서 data-rno라는 속성값을 가져와서 rno라는 변수에 대입  */
         
         
         $("#item_input_update_replyer").val(replyer);  /* 아이디가 item_input_update_replyer인 인풋태그 값에 위에서 대입된 변수 replyer를 넣어서 호출  */
         $("#item_input_update_replyText").val(replyText); /* 아이디가 item_input_update_replyText인 인풋태그 값에 위에서 대입된 변수 replyText를 넣어서 호출  */
         $("#modal_rno").text(rno); /* 아이디가 modal_rno인 텍스트값에 위에서 대입된 변수 rno값을 넣어서 호출한것 */
         
        
         
         
      });
      
      
      $("#replies").on("click", ".item_btn_delete", function() { /*아이디가  replies인 버튼을 클릭하면 function()의 내용이 실행된다 사실상 댓글 삭제버튼 */
         let rno = $(this).attr("data-rno");
         $.ajax({
            type : 'delete', /* delete 방식으로 데이터 전송  */
            url : '/replies',  /* url이  /replies 인 곳과 통신 */
            headers : {
               "Content-Type" : "application/json",
               "X-HTTP-Method-Override" : "DELETE"
            },
            data : JSON.stringify({
               rno : rno /*rno값을 rno에 대입  */
            }),
            dataType : 'text', /* 통신이 끝날 때 서버에서 넘여주는 데이터의 형태 */
            success : function(result) { /* 통신이 성공했을때 실행되는 내용 서버가 넘겨준 result데이터를 라는 변수에 대입 */
               getAllReply(bno, $("#replies")); /* tl.js에 있는  getAllReply 호출 */
            }
            
         });
      });
      
      
      
      $("#reply_btn_submit").on("click", function() {
         let replyer = $("#replyer").val();
         let replyText = $("#replyText").val();
         $("#replyer").val("");
         $("#replyText").val("");

         $.ajax({
            type : 'post', /* post방식으로 데이터 전송  */
            url : '/replies', /* url이  /replies 인 곳과 통신 */
            headers : {
               "Content-Type" : "application/json",
               "X-HTTP-Method-Override" : "POST"
            },
            data : JSON.stringify({
               replyer : replyer,
               replyText : replyText,
               bno : bno /*bno값을 bno에 대입  */
            }),
            dataType : 'text', /* 통신이 끝날 때 서버에서 넘여주는 데이터의 형태 */
            success : function(result) { /* 통신이 성공했을때 실행되는 내용 서버가 넘겨준 result데이터를 라는 변수에 대입 */
            	if (result) { /* 만약 통신이 잘 됐으면 아래 메서드 실행  */
            		getAllReply(bno, $("#replies")); /* tl.js에 있는  getAllReply 호출 */
				}else{ /*통신이 잘 안됐으면  */
					alert("입력에 실패했습니다"); /* alert창에 있는 입력에 실패했습니다 라는 메세지 뜸 */
				}
               
               
            }
            
         });
         
         
      });
      
      
      
      
      
      $(".reply").on("click", function() { /*클래스가 reply 버튼을 누르면  collapse클래스가 실행되면서 토글이 열린다 */
         $(".collapse").collapse("toggle");
      });
      
      
      
      $(".delete").on("click", function() {/* 클래스가 delete인 버튼을 누르면  */
         $("form") /*form태그안에  */
         .attr("action", "/board/delete/${bDto.bno}") /* /board/delete/${bDto.bno}의 속성을 찾아서*/
         .attr("method", "post") /* post방식으로 메서드를 전송한다  */
         .submit(); /* 데이터 전송   */
      });
      
      
      
      getAllReply(bno, $("#replies")); /*tl.js에 있는  getAllReply 함수를 호출한다 */
      
   });


</script>
</body>
</html>