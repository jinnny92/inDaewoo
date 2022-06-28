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
</head>
<body>

<div id="uploadedItems">

</div>



<script type="text/javascript" src="/resources/js/tl.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
			let filenameList = "${filenameList}";
			let uploadedFilename = "${uploadedFilename}";
			
			$("#uploadedItems").on("click", ".btn_del_item", function() {
				 let filename = $(this).attr("data-filename");
				//ajax의 success에서는 $(this)를 인식하지 못함
				//그래서 $(this) 값을 변수에 담았다가 success에서 사용함
				
				let $btn = $(this); //ajax를 선택자로 지정할 때 하나를 지정할 때오 여러개를 지정할 때가 다르다. 반복문을 돌렸을 때 실제 태그가 아니라 문자열로 인식이 되기 때문에
				
				$.ajax({
					type : 'post', //레스트컨트롤러가 아니라 일반 컨트롤러이기 때문에 delete가 아닌 post, 
					url : "/deletefile",
					//headers 레스트 컨트롤러 일때만 만든다
					data : {
						"uploadedFilename" : filename
						//"uploadedFilename" 그냥 Filename으로 줬으면 homecontroller쪽에서도 바꿔야해서 걍 uploadedFilename로줌 
					},
					
					dataType : 'text',
					success : function(result) {
						// 버튼의 부모태그인 div 태그를 삭제했음
						// 업로드한 파일은 삭제되지 않았음
						if (result == "SUCCESS") {
							$btn.parent().remove();
						}else{
							alert("삭제 실패");
						}
						
					}
				});
				
			});

			
			
			filenameList	= filenameList.substring(1, filenameList.length-1);
			
			   let arr = filenameList.split(",");
			   console.log(arr);
		         
		         for(let i=0; i< arr.length; i++){
		            let filename = arr[i].trim();
				
				let imgSrc = '';
				if (isImg(filename)) {
					imgSrc = "/displayfile?filename=" + filename;
					
				}else{
					imgSrc = "/resources/img/일반파일.png";
					
				}
				
				let aHref = '';
				if (isImg(filename)) {
					aHref = "/displayfile?filename=" + getImgFilePath(filename);
				} else {
					aHref = "/displayfile?filename="+filename;
				}
				
				
				let pText = getOrgName(filename);
				
				let btnDataFilename = filename;
				
				let str = makeUploadItemTag(imgSrc, aHref, pText, btnDataFilename)
				
				
				$("#uploadedItems").append(str);
				
			}
			

	});


</script>
</body>
</html>