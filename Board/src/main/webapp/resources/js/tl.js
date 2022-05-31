/**
 * 
 */
 
 
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