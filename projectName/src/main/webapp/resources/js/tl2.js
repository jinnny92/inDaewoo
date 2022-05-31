/**
 * 
 */
 
 
 function getAllReply(id, el){
   $.getJSON("/replies/"+id+"/all", function(result){
	 	
      for(let i=0; i< result.length; i++){
         let item = result[i];
         let str = makeItemTag(item);
           el.append(str);
      }
       el.html("");/*반복문안에서 문자열은 누적되게 하고 반복문 밖에서 html을 진행되게 한다 */
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