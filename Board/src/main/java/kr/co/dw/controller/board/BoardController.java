package kr.co.dw.controller.board;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.dw.domain.BoardDTO;
import kr.co.dw.service.board.BoardService;
import kr.co.dw.service.upload.UploadService;
import kr.co.dw.utils.DWUtils;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Inject
	private BoardService bService;
	
	@Autowired
	private UploadService uService;
	
	private String uploadPath = "C:" + File.separator + "upload";
	
	
	
	@RequestMapping(value = "/delete/{bno}", method = RequestMethod.POST)
		public String delete(@PathVariable("bno") int bno) {
		
		bService.delete(bno);
		
		return "redirect:/board/list";
	}
	
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
		public String update(BoardDTO bDto) {
			bService.update(bDto);
			
			
			
		return "redirect:/board/read/" +bDto.getBno();
	}
	
	
	@RequestMapping(value = "/update/{bno}", method = RequestMethod.GET)
		public String updateUI(@PathVariable("bno") int bno, Model model) {
		
		
		BoardDTO bDto =	bService.updateUI(bno);
		model.addAttribute("bDto", bDto);
		
		return "/board/update";
	}
	
	
	@RequestMapping(value = "/read/{bno}", method = RequestMethod.GET)
		public String read(@PathVariable("bno") int bno, Model model) {
		BoardDTO bDto = bService.read(bno);
		model.addAttribute("bDto", bDto);
		
		
		return "/board/read";
	}
	
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String> insert(MultipartHttpServletRequest request, Model model) {
		ResponseEntity<String> entity = null;
		
		String title =	request.getParameter("title");
		String writer =	request.getParameter("writer");
		String content =	request.getParameter("content");
		
		BoardDTO bDto = new BoardDTO(0, title, content, writer, null, null, 0);
		
		
		
			try {
				bService.insert(bDto);
				List<MultipartFile> list = request.getFiles("file");
				 List<String> filenameList = new ArrayList<String>();
				
				 for(int i=0;i<list.size();i++) {
			            MultipartFile file = list.get(i);

			            String uploadedFilename = DWUtils.uploadFile(uploadPath, 
			                  file.getOriginalFilename(), file.getBytes());

			           filenameList.add(uploadedFilename);
			            
			         }
				 
				 bDto.setFilenameList(filenameList);
				 
				 uService.insert(bDto);
				 
				 entity = new ResponseEntity<String>(bDto.getBno()+"", HttpStatus.OK);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				entity = new ResponseEntity<String>(-1+"", HttpStatus.BAD_GATEWAY);
			}
		
		return entity;
	}
	
	
	/*
	 * @RequestMapping(value = "/insert", method = RequestMethod.POST) public String
	 * insert(BoardDTO bDto) {
	 * 
	 * bService.insert(bDto);
	 * 
	 * return "redirect:/board/read/" + bDto.getBno(); }
	 */
	
	
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert() {
		
		
		return "/board/insert";
	}
	
	
	
	@RequestMapping( value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<BoardDTO> list = bService.list();
		model.addAttribute("list", list);
		
		return "/board/list";
	}
	
}
