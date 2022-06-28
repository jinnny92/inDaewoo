package kr.co.dw.controller.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.dw.domain.MemberDTO;
import kr.co.dw.service.member.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService mService;
	
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
		public String update(MemberDTO dto) {
		mService.update(dto);
		
		return "redirect:/member/read/" + dto.getId();
		
	}
	
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
		public String updateUI(@PathVariable("id") String id, Model model) {
		
		MemberDTO dto = mService.updateUI(id);
		
		model.addAttribute("dto", dto);
		
		return "/member/update"; 
	}
	
	
	
	@RequestMapping(value = "/read/{id}")
	public String read(@PathVariable("id") String id, Model model) {
		
	MemberDTO dto = mService.read(id);
	
	model.addAttribute("dto", dto);
	
	
	return "/member/read";
}



	
	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
		public String list(Model model) {
			List<MemberDTO> list  = mService.list();
			
			model.addAttribute("list", list);
			
			return "/member/list";
		
	}
	
	
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(MemberDTO dto) {
		
		mService.insert(dto);
		
		
		return "redirect:/member/list";
	}
	
	
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert() {
		
		return "/member/insert";
	}
}
