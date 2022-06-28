package kr.co.dw.controller.inter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/inter")
public class InterController {

		@RequestMapping(value = "/test1", method = RequestMethod.GET)
		public String test1(Model model) {
			System.out.println("222222" + "test1:::::::::::::::::::::::");
			
			model.addAttribute("test1", "테스트1입니다");
			
			return "/inter/test1";
		}
}
