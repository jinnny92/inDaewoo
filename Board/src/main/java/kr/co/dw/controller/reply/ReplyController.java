package kr.co.dw.controller.reply;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.dw.domain.ReplyDTO;
import kr.co.dw.service.reply.ReplyService;

@RestController
@RequestMapping("/replies")
public class ReplyController {
	
	@Autowired
	private ReplyService rService;
	
	@RequestMapping(value = "", method = RequestMethod.PUT)
		public ResponseEntity<String> update(@RequestBody Map<String, Object> map) {
			ResponseEntity<String> entity = null;
			
			try {
				rService.update(map);
				entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
				
			} catch (Exception e) {
				// TODO: handle exception
				entity = new ResponseEntity<String>("FAIL", HttpStatus.BAD_REQUEST);
			}
		
			
		
		return entity;
	}
	
	
	
	
	   @RequestMapping(value = "", method = RequestMethod.DELETE)
	   public ResponseEntity<String> delete(@RequestBody Map<String, Object> map) {
		   ResponseEntity<String> entity = null;
		   
		   try {
			   rService.delete(map);
			   entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			entity = new ResponseEntity<String>("FAIL", HttpStatus.BAD_REQUEST);
		}
	      
	      
	      return entity;
	   }
	   
	
	
	@RequestMapping(value = "/{bno}/all", method = RequestMethod.GET)
	public List<ReplyDTO> rList(@PathVariable("bno")int bno){
		List<ReplyDTO> list = rService.list(bno);
		
		return list;
	}
	
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> insert(@RequestBody Map<String, Object> map) {
		ResponseEntity<String> entity = null;
		
		
		try {
			rService.insert(map);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK); //HttpStatus.CREATED나 HttpStatus.OK중 하나
			//HttpStatus.FAILED_DEPENDENCY를 통해 성공했지만 실패한 척 할 수도 있음
		} catch (Exception e) {
			// TODO: handle exception
			entity = new ResponseEntity<String>("FAIL", HttpStatus.BAD_REQUEST);
		}
		
		
		
		return entity;
	}

}
