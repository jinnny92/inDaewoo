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



<div>
<a href="/displayfile?filename=${uploadedFilename}">
    <img alt="test" src="${uploadedFilename}">
</a>
<p>업로드한 파일 이름</p>
<button>삭제</button>
</div>




<script type="text/javascript">
	$(document).ready(function() {
		

		let uploadedFilename = "${uploadedFilename}";
			
		$("div").on("click", "button", function() {
			
			//ajax의 success에서는 $(this)를 인식하지 못함
			//그래서 $(this) 값을 변수에 담았다가 success에서 사용함
			
			let $btn = $(this); //ajax를 선택자로 지정할 때 하나를 지정할 때오 여러개를 지정할 때가 다르다. 반복문을 돌렸을 때 실제 태그가 아니라 문자열로 인식이 되기 때문에
			
			$.ajax({
				type : 'post', //레스트컨트롤러가 아니라 일반 컨트롤러이기 때문에 delete가 아닌 post, 
				url : "/deletefile",
				//headers 레스트 컨트롤러 일때만 만든다
				data : {
					"uploadedFilename" : uploadedFilename
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
		

			
			if (isImg(uploadedFilename)) {
				 $("img").attr("src", "/displayfile?filename="+uploadedFilename);

				
			}else{
				   $("img").attr("src", "/resources/img/일반파일.png");
				/* 클릭하면 일반파일같은 경우 다운로드 될 수 있게  */
			}
			
			
			if (isImg(uploadedFilename)) {
				let oriName = getImgFilePath(uploadedFilename);
				
				
				$("a").attr("href", "/displayfile?filename="+oriName);
			}
			
			 $("p").text(getOrgName(uploadedFilename));

			 function getOrgName(filename){
			    let orgName = "";
			    let idx = -1;
			    
			    if(isImg(filename)){
			    	//인덱스가 14인 위치를 시작점으로 해서 "_"의 인덱스를 찾아라
			    	//그리고 그 인덱스에서 +1을 해라 (원래 이름의 첫글자 인덱스 찾기)
			       idx = filename.indexOf("_", 14) + 1;
			       
			    }else{
			        idx = filename.indexOf("_") +1;
			       
			    }
			    
			    orgName = filename.substring(idx);
			    return orgName;
			    
			 }

			
			function getImgFilePath(filename) {
				let prefix = filename.substring(0, 12);
				let suffix = filename.substring(14);
				return prefix + suffix;
			}
			
			
			function isImg(filename) {
				let idx = filename.lastIndexOf(".") + 1;
				let formatName = filename.substring(idx).toLowerCase();
				if (formatName == "png"|| formatName == "gif" || formatName == "jpg" || formatName == "jpeg") {
					
					return true;
					
				}else{
					
					return false;
				}
			}
	});


</script>
</body>
</html>