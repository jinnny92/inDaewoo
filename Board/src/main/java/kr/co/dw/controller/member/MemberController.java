package kr.co.dw.controller.member;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.dw.domain.MemberDTO;
import kr.co.dw.service.member.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Inject
	private MemberService mService;
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value = "/loginget", method = RequestMethod.GET)
	public String login() {
		
		return "/member/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(MemberDTO mDto, Model model) {
		
		MemberDTO login = mService.login(mDto);
		model.addAttribute("login", login);
		System.out.println("333333333333");
		
		return "redirect:/board/list";
	}


}
