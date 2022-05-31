package kr.co.dw.controller.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.dw.service.test.TestService;

@Controller
public class TestController {

	@Autowired
	private TestService tService;
	
	@RequestMapping(value = "/ba", method = RequestMethod.GET)
		public String ba() {
		
		tService.ba("zzzz");
		
		return "ba";
		
		
	}
}


