<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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


<div id="uploadFile"></div>

<div id="uploadedItems"></div> <!-- 내가 업로드한 파일이 화면에 나오게끔 -->


<!-- <form action="" enctype="mutipart/form-data"></form> -->

<script type="text/javascript" src="/resources/js/tl.js"></script>
<script type="text/javascript">
   
$("#uploadedItems").on("click", ".btn_del_item", function() {
    let $delBtn = $(this);
    let filename = $(this).attr("data-filename");
    
    
    
    $.ajax({
       type : "post", /* 레스트컨트롤러가 아니라 일반 컨트롤러이기 떄문에 포스트아니면 겟만 쓴다 */
       url : "/deletefile",
       data : {
          "uploadedFilename" : filename
       },
       dataType : "text",
       success : function(result) {
          // 버튼의 부모태그인 div 태그를 삭제했음.
          // 업로드한 파일은 삭제되지 않았음.
          if(result == "SUCCESS"){
             $delBtn.parent().parent().parent().remove();
          }else{
             alert("삭제 실패");
          }
       }
    });
 });
   
   
   
      $("#uploadFile").on("dragenter dragover", function(event) {
         event.preventDefault();
      });
   


   $("#uploadFile").on("drop", function(event) {
      event.preventDefault();
       
      let formData = new FormData();
      
      let files =   event.originalEvent.dataTransfer.files;
      /* 파일이 하나였지만 여러개를 드래그해서 올수도 있으므로 files를 씀 파일안에 들어있는 데이터를 파일즈라고 하는 배열에 집어 넣는 코드 목록이 아니라 파일에 들어있는 데이터 그림의 바이너리 코드가 들어가게 한다*/
    
      for(let i=0; i< files.length; i++){
          let file = files[i]; 
          formData.append("file", file);     
      }
      
     
    /*   ajax를 이용해서 파일 전송이 가능하게 함(원래 ajax는 데이터를 전송해주고 싶은데 문자열 밖에 전송이 안됨) form태그를 클래스로 구현 form태그라고 생각하면 됨. 파일을 추가하기 위해서 사용하는것. 그냥 폼태그는 파일추가가 안되서 html5에서 제공함 */
       
    
    
   /*  이제 이 formData를 Ajax통신으로 넘겨주면 되는거 */
   /* ajax는 화면이 갱신이 안됨, 부분적인 통신만 가능 */
    
    $.ajax({
        type : "post",
         url : "/ajaxform",
          processData : false,  /* true가 되면 쿼리스트링형태로 주소창에 이 데이터가 딸려서 넘어가기때문에 false로 */ 
            contentType: false,
             data : formData,
             dataType : "text",
             success : function(filenameArr){
            	 filenameArr = filenameArr.substring(1, filenameArr.length-1);
                
                let arr = filenameArr.split(","); // ,를 이용해서 잘라내기를 할거다
                
                for(let i=0; i< arr.length; i++){
                	let fimename = arr[i].trim();
            
                  let str = makeUploadItemTag2(fimename);

                  
                  $("#uploadedItems").append(str);
                }
               

             }
                
          
       
    });
      
      
   });


</script>
</body>
</html>