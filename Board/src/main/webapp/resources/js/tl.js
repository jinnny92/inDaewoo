/**
 * 
 */
  	function makeUploadItemTag2(filename){
	
		let imgSrc = '';
						if (isImg(filename)) {
							imgSrc = "/displayfile?filename=" + filename;
						} else {
							imgSrc = "/resources/img/일반파일.png";
						}
						
						let aHref = '';
						if (isImg(filename)) {
							aHref = "/displayfile?filename=" + getImgFilePath(filename);
						} else {
							aHref = "/displayfile?filename=" + filename;
						}
						
						let pText = getOrgName(filename);
						let btnDataFilename = filename;
	
	
	
		let str = `<div class = "col mb-4">
			<div class="card filename border-danger text-center" style="width: 18rem;">
  <a href="${aHref}" target="_blank"><img src="${imgSrc}" class="" alt="업로드한 파일의 썸네일"></a>
  <div class="card-body">
    <p class="card-text">${pText}</p>
    <a href="#" data-filename ="${btnDataFilename}" class="btn btn-danger btn_del_item">삭제</a>
  </div>
</div>
</div>
		`;
		
		
		
	return str;
}
 
 
 
 
 	function makeUploadItemTag(imgSrc, aHref, pText, btnDataFilename){
		let str = `<div class = "col mb-4">
			<div class="card filename border-danger text-center" style="width: 18rem;">
  <a href="${aHref}" target="_blank"><img src="${imgSrc}" class="" alt="업로드한 파일의 썸네일"></a>
  <div class="card-body">
    <p class="card-text">${pText}</p>
    <a href="#" data-filename ="${btnDataFilename}" class="btn btn-danger btn_del_item">삭제</a>
  </div>
</div>
</div>
		`;
		
		
		
	return str;
}
 
 
 	
 
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
 
 
 
 
 
 
 function getAllReply2(bno, el){
   $.getJSON("/replies/"+bno+"/all", function(result){
	 	let tagStr = "";
	 	
      for(let i=0; i< result.length; i++){
         let item = result[i];
         let str = makeItemTag(item);
      	 tagStr += str; //문자열 누적을 시키고
         
      }
     el.html(tagStr) //반복문 밖에서 html을 씀 밑에꺼보다 속도가 더 빠름, 밑에는 태그에 계속 집어 넣는데 여기는 문자열에 그냥 누적을 시키고 마지막에 태그에 집어넣음 
   	//하나씩 어딘가에 저장을 해놓고(tagStr) 한 번에 옮기는 개념 (el.html)
   });
   
}
 
 
 function getAllReply(bno, el){
   $.getJSON("/replies/"+bno+"/all", function(result){
	 	el.html("");
	 	
      for(let i=0; i< result.length; i++){
         let item = result[i];
         let str = makeItemTag(item);
         el.append(str);
         
      }
      
   });
   
}
function makeItemTag(item){
   
   let str = `
   
   <div class="card item my-5">
  <div class="card-header">
    <span>댓글번호: ${item.rno}</span> <span class = "float-right">최종 수정일: ${item.updateDay}</span>
  </div>
  <div class="card-body">
    <h5 class="card-title">${item.replyer}</h5>
    <p class="card-text">${item.replyText}</p>
    <a data-rno="${item.rno}" href="#" class="btn btn-primary item_btn_update">수정</a>
    <a data-rno="${item.rno}" href="#" class="btn btn-primary item_btn_delete">삭제</a>
  </div>
</div>
</div>
</div>
   
   `;
   
   return str;
}