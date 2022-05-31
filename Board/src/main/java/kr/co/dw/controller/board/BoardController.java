package kr.co.dw.controller.board;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.dw.domain.BoardDTO;
import kr.co.dw.service.board.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Inject
	private BoardService bService;
	
	
	
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
	
	
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(BoardDTO bDto) {
		
		bService.insert(bDto);
		
		return "redirect:/board/read/" + bDto.getBno();
	}
	
	
	
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
