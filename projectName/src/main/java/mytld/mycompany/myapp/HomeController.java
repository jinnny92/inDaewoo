package mytld.mycompany.myapp;

import java.io.File;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.dw.domain.MemberDTO;
import kr.co.dw.utils.DWUtils;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping(value = "/gat2", method = RequestMethod.GET)
	public String gat2(Model model) {//컨트롤러쪽에서 jsp로 list보내주고 그 list통해서 ajax통신하는거 
		
		
		
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		
		
		list.add(new MemberDTO("m001", "1111", "kim", "2020-01-01"));
		list.add(new MemberDTO("m002", "2222", "koo", "2021-02-02"));
		list.add(new MemberDTO("m003", "3333", "lee", "2022-03-03"));
		
		
		//System.out.println(list);
		model.addAttribute("list", list);
		
		return "gat2";
		
	}
	
	
	
	@RequestMapping(value = "/gat2", method = RequestMethod.POST)
	   @ResponseBody
	   public   List<Map<String, Object>> gat2(@RequestParam Map<String, Object> map) throws Exception {

	      String hello = (String) map.get("hello");
	      

	      String sList = (String) map.get("list");
	     

	      ObjectMapper oMapper = new ObjectMapper();
	      List<Map<String, Object>> list = oMapper.readValue(sList, new TypeReference<ArrayList<Map<String, Object>>>() {
	      });
	      
	      for (int i = 0; i < list.size(); i++) {
	    	  System.out.println(":::::::::");
	    	 Map<String, Object> subMap = list.get(i);
	    	 String id = (String)subMap.get("id");
	    	 String pw = (String)subMap.get("pw");
	    	 String name = (String)subMap.get("name");
	    	 String birth = (String)subMap.get("birth");
	    	 System.out.println(id);
	    	 System.out.println(pw);
	    	 System.out.println(name);
	    	 System.out.println(birth);
	    	 System.out.println(":::::::::");
	    	 
		}
	      
	      

	      return list;
	   }

	
	
	
	@RequestMapping(value = "/gat1", method = RequestMethod.POST)
	   @ResponseBody
	   public String gat1(@RequestParam Map<String, Object> map) throws Exception {

	      String hello = (String) map.get("hello");
	      

	      String sList = (String) map.get("list");
	     

	      ObjectMapper oMapper = new ObjectMapper();
	      List<Map<String, Object>> list = oMapper.readValue(sList, new TypeReference<ArrayList<Map<String, Object>>>() {
	      });
	      
	      for (int i = 0; i < list.size(); i++) {
	    	  System.out.println(":::::::::");
	    	 Map<String, Object> subMap = list.get(i);
	    	 String id = (String)subMap.get("id");
	    	 String pw = (String)subMap.get("pw");
	    	 String name = (String)subMap.get("name");
	    	 String birth = (String)subMap.get("birth");
	    	 System.out.println(id);
	    	 System.out.println(pw);
	    	 System.out.println(name);
	    	 System.out.println(birth);
	    	 System.out.println(":::::::::");
	    	 
		}
	      
	      

	      return "test";
	   }

	
	
	@RequestMapping(value = "/gat1", method = RequestMethod.GET)
	public String gat1(Model model) {//컨트롤러쪽에서 jsp로 list보내주고 그 list통해서 ajax통신하는거 
		
		
		
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		
		
		list.add(new MemberDTO("m001", "1111", "kim", "2020-01-01"));
		list.add(new MemberDTO("m002", "2222", "koo", "2021-02-02"));
		list.add(new MemberDTO("m003", "3333", "lee", "2022-03-03"));
		
		
		//System.out.println(list);
		model.addAttribute("list", list);
		
		return "gat1";
		
	}
	
	
	
	@RequestMapping(value = "/jsontest", method = RequestMethod.GET)
	@ResponseBody
		public  MemberDTO jsonTest() {
		return new MemberDTO("m001", "111", "kim", "2022-01-01");
	}
	
	
	@RequestMapping(value = "/makefolder", method = RequestMethod.GET)
	public String makefolder() {
		 
	 String uploadpath = DWUtils.makefolder();
		
	 System.out.println(uploadpath);
	 
	 
		return "redirect:/";
		
	}
	
	//exists() 존재하냐? 하고 물어보는거~ / new DecimalFormat("00") 양식을 두자리로 표시하겠다는 의미
	
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(Model model) {
			String say = "mmmmmmmmmm";
			model.addAttribute("say", say);
		
		return "hello";
		
	}
	
	//String대신 void를 쓰면 uri값을 그대로 넘겨주기때문에 return이 없어도 있는것과 같다
	
	
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
	
		//Date date = new Date();
		//DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String serverTime = "안녕하세요";
		
		model.addAttribute("serverTime", serverTime );
		
		return "home";
	}
	//model 데이터를 jsp쪽으로 보내주는 역할 
	//MVC핸들러 
	//locale 각 나라별로 시간대 맞춰주기 위해 쓰는거
}
