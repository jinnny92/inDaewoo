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
<h1 class="text-center">게시글 수정</h1>
</div>


<!--게시글 수정 양식  -->
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


<div class="form-group">
   <div id="uploadFile" class="form-control text-center"></div>
</div>

<!--업로드한 파일의 썸네일  -->
<div id="uploadedItems" class="row row-cols-1 row-cols-3">
</div>

<div class="form-group row">
    <input id="btn_submit" type="submit" class="form-control btn btn-danger col-sm-4 offset-sm-4" value="수정 완료">
  </div>

<script type="text/javascript" src="/resources/js/tl.js"></script>
<script type="text/javascript">

	

 	$(function() {
 		let bno = ${bDto.bno};  /* 수정할 게시글 지정 역할 &업로드된 파일들에 대한 정보를 가져오기 위한 용도  */
 		
 		let formData = new FormData(); /* html5에서 제공하는 form태그를 클래스로 구현한 것 나중에 form태그의 input태그에 있는 데이터와 새롭게 업로드 되는 파일들의 정보를 formData 객체에 저장해서 controller로 보내줄 거임*/
 		
 		
 		let idx = 0; 
 		
 		/*formData 객체에 업로드되는 파일 정보를 저장할 때, 기존에 key를 "file"로 설정했고 그래서 모든 업로드된 파일들의 file정보가 "file"로 저장이 됨 그래서 Controller에서 request.getFiles();를 사용했었음
 		그런데 이렇게 key 값을 동일하게 설정하면 파일을 추가하는 화면(insert.jsp, update.jsp)에서 해당 파일을 삭제할 수가 없었음
 		이 문제를 해결하는 방법은 formData 객체에 파일 정보를 저장할 때 key값을개별적으로 입력하게 해야함
 		그래서 키를 "file0", "file1", "file2", "file3"처럼 저장하기 위해서 idx를 선언함. 추후에 ++연산자를 이용해서 idx값이 1씩 증가되게 함
 		그리고 controller에서는 request.getFileMap()을 사용함*/
 		
 		/*formData 객체에 파일을 추가할 때 , filekey를 입력해야 하는데 공통적으로 들어가는 이름과 그렇지 않은 부분을 구분하기 위한 값,(공통적으로 들어가는 값은 file, 그렇지 않은 부분은 idx) 반복문을 사용할 수 있게하기 위해 선언했음 */
 		
 		/* ++idx는 곧바로 1이 증가되어 idx에 입력됨
 		idx++은 다음에 idx를 만나면 그때 1이 증가되어 idx에 입력됨 */
 		
 		
 		let deleteFilenameArr = []; //삭제버튼을 누르면 화면상에선 삭제가 되지만 DB에서는 수정완료 버튼을 누를때까지 살아있다
 		/*DB에 있던 원래 업로드된 파일들 중에서 update.jsp에서 삭제되는 파일들의 이름을 저장한 후에 수정완료버튼이 눌러졌을 때, 
 		같이 controller로 넘어가서 DB에서 해당 파일명을 삭제하기 위해 
 		아울러 실제 파일들도 삭제함
 		*/
 		

 		
 		getAllUploadForUpdateUI(bno, $("#uploadedItems")); /*업로드한 파일들에 대한 썸네일 표시. 
 		tl.js의 함수임 함수 내부에서 $.getJSON통신을 통해 업로드된 파일들에 대한 정보를 DB에서 가져온 후 이미지 파일은 자신의 썸네일을, 
 		일반 파일은 우리가 만든 썸네일을 아이디가 uploadedItems인 곳에 관련 태그를 만들어서 추가함  */
 		
 	   $("#uploadFile").on("dragenter dragover", function(event) { /*아이디가  uploadFile인 태그 안에 마우스의 왼쪽 버튼을 누른 상태로 들어오거나 그 상태에서 마우스의 커서 위치가 이동하면 function() 그 안에 내용을 실행하게 하는 태그*/

		      event.preventDefault();  /*해당 이벤트의 기본 기능을 막는 기능  */
		   });

		   $("#uploadFile").on("drop", function(event) {/* 아이디가  uploadFile인 영역에 파일을 drop 시킬때function() 안에 내용을 실행하게 하는 기능 */
		      event.preventDefault(); /* 해당 이벤트의 기본 기능을 막는 기능 */
		      
		      let files = event.originalEvent.dataTransfer.files; /*파일을 드랍하면, 파일 안에 있는 데이터를 바이너리 코드로 전환하고 그 내용을 files변수에 대입하는 기능  */
		      
		      let file = files[0]; /*드래그앤드랍한 파일 중에서 첫번째 파일만 추출해서 file이라는 변수에 대입  */
		      
		      
		      formData.append("file" + idx, file); /* 업로드한 파일들 중 인덱스가 0인 formData에 추가한 코드
		      키:  file0, file1 등의 형식으로 입력됨
		      하단에서 키가 0, 1, 2, 3 등등으로 1씩 증가되게 구현되어 있음*/
		      
		      /* 업로드할 파일의 썸네일을 화면에 표시하기 위한 코드 시작 */
		     
		      let reader = new FileReader(); /* 아이디가 uploadedItems인 영역에 드랍한 파일의 썸네일을 보여주기  위한  FileReader라는 스트림 객체 생성 */
		      
		      /*FileReader와  let file = files[0];에 있는 file 변수를 연결하고 그 안에 있는 데이터를 읽어와서 reader 객체에 그 데이터를 저장함  */
		      reader.readAsDataURL(file); /* 앞에서 만든 reader라는 스트림을 통해 드랍한 파일의 정보를 읽어온다 */
		      /*reader.onload : readAsDataURL(file);함수 작업이 종료됨을 감지하는 코드  */
		      reader.onload = function(event){ /* reader.onload : readAsDataURL() 작업이 끝나면 실행되는 함수 */
		         /*해당 이벤트에 대한 핸들러 작업  */
				/* event.target : reader */
				/* event.target.result : reader객체 안에 있는 result라는 속성인데 그 안에는 file로부터 읽어온 데이터가 들어있음 */
				/* test2()" tl.js안에 있는 함수인데 img, p, button으로 이루워진 text를 반환한다" */
		          let str  = test2(event.target.result, file["name"], "file"+ idx++);
		    		 /*tl.js에 있는 test2()함수를 호출함. 호출할 때, event.target.result를 건네줌. */
		          
		    		 
		    		 /* test2()가 반환한 text를 아이디가 uploadedItems인 div태그에 추가 */
		          $("#uploadedItems").append(str);
		    		 /* 업로드할 파일의 썸네일 추가, tl.js의 test2()함수를 실행해서 나온 태그를 아이디가  uploadedItems인 태그에 자식으로 추가 */

		    	  
			}
		      
				
	   });

 	
		   	/*클래스가  btn_del_item인 버튼을 눌러서 업로드하려고 했던 파일을 formData에서 삭제하는 코드 
		   		해당 버튼은 동적으로 생선되었기 떄문에 이벤트가 안 먹힐 수도 있고 먹힐 수도 있음
		   		이벤트를 항상 먹게 하려고 on()함수를 사용했음
		   	*/
 		$("#uploadedItems").on("click", ".btn_del_item", function() {   /*아이디가 uploadedItems 버튼을 클릭하면 function()의 내용이 실행된다  */
			let filename =	$(this).attr("data-filename"); 
 		/* 방금 누를 버튼의 태그에서 ata-filename이라는 사용자 속성값을 가져와서 filename이라는 변수에 대입  */
			
 		
 		/* 이미 업로드된 파일의 썸네일과 update.jsp에서 업로드하라고 formData에 추가한 파일의 썸네일은 구분이 안됨 
 		이 두 종류의 파일들을 구분하기 위해서 update.jsp에서 업로드한 파일들에 대해서는
 		data-filename 속성값을 new로 지정했고, 그렇지 않은 것들은 원래의 filename을 갖고 있음*/

 		if (filename == "new") { //update.jsp에서 드랍한 파일정보냐? filename이 new냐고 물어보는거
					let filekey =	$(this).attr("data-filekey"); 
 		/*upload.jsp에서 드랍한 파일의 썸네일태그 중 a태그는 삭제버튼역할을 하는데 그 안에는 data-filekey라는 속성이 있음. 이 속성은 삭제버튼을 눌렀을 때 
 		formData.delete()함수에서 요구하는 키 정보를 갖고 있음*/
 		
 		// 만약 새롭게 추가된 애라면data-filekey라는 속성값을 가져와서 filekey에 대입 화면에선 삭제가 되지만 formData에선 삭제안됨
					formData.delete(filekey);  /*파일키값을 가져와서 폼데이터 안에 있는거 지우기  */
			}else {
				/*insert.jsp에서 upload한 파일들 중에서 삭제하고 싶은 파일들의 목록 나중에 controller로 보내서 테이블에서 해당 파일들을 삭제하고 upload폴더에 있는 해당 업로드 파일들도 삭제할 예정임  */
				deleteFilenameArr.push(filename);//	deleteFilenameArr.push(filename); 이런식으로 사용하면된다
				
			}
			
			
			/* update.jsp에서 삭제버튼을 누른 파일들에 대한 썸네일을 제거하는 역할  */
 			$(this).parent().parent().parent().remove(); //div속에 div속에 div를 삭제 하기 위해서  parent()를 세번 썼다 (div)로 몇 번 감싸고 있는지 확인할것
 		});
 	
 	//삭제버튼은 동적으로 생성됐기 때문에 click이라는 이벤트를 사용하지 못하고 on이라는 이벤트만을 사용해야한다
 	
 		
 		$("#btn_submit").click(function() { /* 수정완료버튼을 클릭하면 form태그에 입력되어 있는 모든 text값을 가져와서 formData객페에 추가
 			긜고 삭제하기로 한 이미 업로드 된 파일 정보가 담긴 deleteFilenameArr를 formData에 객체로 추가
 			그 후 $.ajax()를 이용해서 formData를 Controller로 보내서 수정 작업을 완료함
 			*/
 			
 			formData.append("bno", bno); //게시글 제목이나 내용이 수정될 수 있으므로 bno값을 가져가야 한다. 그러기 위해 formData에 bno값을 추가 해준 것
 			let title = $("#title").val(); /* title 태그 안의 아이디 값을 가져와서 title 변수에 대입 */
 			formData.append("title", title); /*formData안에 title이라는 이름으로 title 값을 추가한다  */
 			
 			let writer = $("#writer").val(); /* writer태그 안의 아이디 값을 가져와서 writer변수에 대입 */
 			formData.append("writer", writer); /* formData안에 writer라는 이름으로 writer값을 추가한다  */
 			
 			let content = $("#content").val(); /*content태그 안에 있는 아이디 값을 가져와서 content변수에 대입한다  */
 			formData.append("content", content); /* formData안에 content라는 이름으로 content값을 추가한다  */
 			
 			
 			
 			formData.append("deleteFilenameArr", deleteFilenameArr); /*formData안에 deleteFilenameArr라는 이름으로 deleteFilenameArr를 추가한다  */
 			
 			
 		   $.ajax({
 		        type : "post", /* post방식으로 통신 */
 		         url : "/board/update", /* url값이 /board/update인 곳과 통신 */
 		          processData : false,  /* true가 되면 쿼리스트링형태로 주소창에 이 데이터가 딸려서 넘어가기때문에 false로 true로 전송하면 데이터를 주소창에 붙여서 전송하겠다는 의미이지만 false이므로 데이터를 메세지 본체에 저장해서 전송하겠다는 뜻이다*/ 
 		            contentType: false, /*  contentType 디폴트값은 true : form태그의 기본 enctyp을 사용하겠다는 의미. 그러면 파일 전송 안된다. false여야 multipart/form-data가 되고 파일 전송이 됨   */
 		             data : formData,  /* 전송되는 데이터는 formData객체 안에 추가. 데이터들이 전송된다   */
 		             dataType : "text", /*통tlsdl 끝날 때 서버에서 넘겨주는 데이터의 형태  */
 		             success : function(result){ /*통신이 성공했을 때 실행되는 내용  */
 		            	 
 		            	 if (result == "SUCCESS") { /*성공했으면  */
							location.assign("/board/read/"+bno); /* "/board/read/"+bno로 페이지 이동 */
						} else { /*실패했으면  */
							alert("수정실패"); /* alert창에 수정실패 띄우기  */
						}
 		              
 	                }
 	
 		    });
		
		});
 		
	});
 	



</script>

</body>
</html>