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

<!-- 파일을 드래그앤 드랍하는 영역 : 여기에 파일을 드랍하면 파일이 업로드할 준비가 된다 -->
<div class="form-group">
	<div id="uploadFile" class="form-control text-center"></div>
</div>

<!-- 업로드할 파일의 썸네일이 보여지는 영역, row-cols-lg-3: 한 줄에 3개씩만 배치하게-->
<div id="uploadedItems" class="row row-cols-1 row-cols-lg-3">
</div>

<!--클릭하면, form태그에 있는 내용과 업로드할 파일 정보가 서버로 전송됨. ajax방식으로 스크립트 구현  -->
 <div class="form-group row">
    <input type="submit" class="form-control btn btn-danger col-sm-4 offset-sm-4" value="게시글 등록 완료" id="btn_submit">
  </div>
  
  
  <!--tl.js안에 들어있는 함수를 사용하기 위해 등록  -->
  <script type="text/javascript" src="/resources/js/tl.js"></script>
  <script type="text/javascript">
   $(document).ready(function() { /* jquery사용을 알리는 코드 */
	   let formData  = new FormData(); /*html5에서 form태그를 클래스로 구현한 FormData의 객체(그 클래스를 이용한 객체)  */
	   let idx = 0;/*formData에 파일을 추가할 때 , filekey를 입력해야 하는데 공통적으로 들어가는 이름과 그렇지 않은 부분을 구분하기 위한 값,(공통적으로 들어가는 값은 file, 그렇지 않은 부분은 idx) 반복문을 사용할 수 있게하기 위해   */

	   
	   $("#uploadedItems").on("click", ".btn_del_item", function() { /*동적으로 생성된 태그는 이벤트가 안먹힐 '수' 있다, 그래서 확실하게 먹히게 하기 위해서 위임기능을 갖는 on()함수를 사용했음  */
			/*클래스 btn_del_item인 태그를 클릭하면 function()에 들어있는 내용이 실행된다  */
		   let filekey =	$(this).attr("data-filekey");
	   /*방금 누른 클래스가 btn_del_item인 태그에서 data-filekey라는 속성값을 가져와서 filekey라는 변수에 대입  */
			formData.delete(filekey); /*formData에서 filekey가 변수 filekey(formData.append(파일키, 파일))와 같은 file객체를 삭제하는 기능  */
			
			$(this).parent().parent().parent().remove(); 
				/*방금 누른 클래스가  btn_del_item인 태그의 부모 태그, 그리고 그 부모태그의 부모태그(조부모태그) 그리고 그 조부모태그의 부모태그(증조부모태그)를 제거하는 코드  */
			//div속에 div속에 div를 삭제 하기 위해서  parent()를 세번 썼다 (div)로 몇 번 감싸고 있는지 확인할것
		});
	   
	   
	   
	   $("#uploadFile").on("dragenter dragover", function(event) {/*아이디가  uploadFile인 태그 안에 마우스의 왼쪽 버튼을 누른 상태로 들어오거나 그 상태에서 마우스의 커서 위치가 이동하면 function() 그 안에 내용을 실행하게 하는 태그*/
		      event.preventDefault(); /*해당 이벤트의 기본 기능을 막는 기능  */
		   });

		   $("#uploadFile").on("drop", function(event) {/*아이디가 uploadFile인 영역에 파일을 drop(마우스 왼쪽 버튼을 놓음)시킬 때 function() 안에 내용을 실행하는 기능 */
		      event.preventDefault(); /* 해당 이벤트의 기본 기능을 막는 기능 */
		      
		      let files = event.originalEvent.dataTransfer.files; /* 파일을 드랍하면, 파일 안에 있는 데이터를 바이너리 코드로 전환하고 그 내용을 files변수에 대입하는 기능  */
		      
		      let file = files[0]; /*드랍한 파일 중에서 첫번째 파일만 추출해서 file이라는 변수에 대입  */
		      
		      
		      formData.append("file" + idx, file); /* 드랍한 파일의 정보가 들어 있는 file변수의 내용을 formData객체에 추가. 파일키: file0, file1 형태로 지정된다 삭제할 때 중요  */
		      
		      let reader = new FileReader(); /*아이디가 uploadedItems인 영역에 드랍한 파일의 썸네일을 보여주기 위한 스트림(데이터가 흘러가는 통로) 객체 생성   */
		      
		      reader.readAsDataURL(file);  /*앞에서 만든 reader라는 스트림(통로)를 통해 드랍한 파일의 정보를 읽어온다  */
		      
		      reader.onload = function(event){/* reader.onload : readAsDataURL() 작업이 끝나면 실행되는 function  */
		         
		          let str  = test2(event.target.result, file["name"], "file" + idx++);
		      	 /* tl.js에 있는 test2()함수를 호출함. 호출할 때, event.target.result(스트림을 통해 읽어온 file의 데이터) 를 건네줌, file["name"] : 업로드할 파일의 오리지널 이름,  "file" + idx++ : filekey이고 나중에 삭제 버튼의 data-filekey 속성값으로 입력됨 그리고 idx의 값을 1 (후, 나중에 증가한다) 증가  */
		          
		          $("#uploadedItems").append(str);	/* 업로드할 파일의 썸네일추가, tl.js의 test2() 함수를 실행해서 나온 tag를 아이디가 uploadedItems인 태그에 자식으로 추가   */
			}
				
	   });
		   
		   
		   
	 	
	 	//삭제버튼은 동적으로 생성됐기 때문에 click이라는 이벤트를 사용하지 못하고 on이라는 이벤트만을 사용해야한다
	 	

	   
	   
		$("#btn_submit").on("click", function() { /*아이디가 tn_submit인 파일을 클릭하면 function()의 내용이 실행됨  사실상 insert완료 버튼  */
			
			
			let title = $("#title").val(); /* 아이디가 title인 input태그의 value값을 가져와서 title 변수에 대입  */
			let writer = $("#writer").val();  /* 아이디가 writer인 input태그의 value값을 가져와서 writer 변수에 대입  */
			let content = $("#content").val();  /* 아이디가 content인 textarea태그의 value값을 가져와서 content 변수에 대입  */

			formData.append("title", title); /* formData객체게 title이라는 키로 title 변수 안에 있는 값을 추가  */
			formData.append("writer", writer);  /* formData객체게 writer이라는 키로 writer 변수 안에 있는 값을 추가  */
			formData.append("content", content);  /* formData객체게 content이라는 키로 content 변수 안에 있는 값을 추가  */

		
			
			
			$.ajax({ /* 비동기 통신  */
				type : "post", /* 포스트 방식으로 데이터 전송  */
				url : "/board/insert", /* url이  /board/insert인 곳과 통신 */
				processData: false, /* processData의 디폴트값은 true : 데이터를 주소창에 붙여서 전송하겠다 근데 이게 false니까 데이터를 메시지 본체에 저장해서 전송 */
				contentType: false, /* contentType의 디폴트값은 true : form태그의 기본 enctyp을 사용하겠다는 의미. 그러면 파일 전송 안됨, false : multipart/form-data가 되고 파일 전송이 됨 */
				data : formData,/*전송되는 데이터는 formData 객체 안에 추가 데이터들이 전송됨  */
				dataType : "text",/* 통신이 끝날 때 서버에서 넘여주는 데이터의 형태 */
				success : function(bno) { /* 통신이 성공했을때 실행되는 내용 서버가 넘겨준 데이터를 bno라는 변수에 대입 */
				   location.assign("/board/read/"+bno); /* 주소가 /board/read/bno인 곳으로 이동함   */
				   
				   
				}

				
				
			});
			
		});
	   
});
  
  
  
  
  </script>

</body>
</html>