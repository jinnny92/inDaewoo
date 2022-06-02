package mytld.mycompany.myapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.dw.domain.MemberDTO;
import kr.co.dw.utils.DWUtils;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private String uploadPath = "C:" + File.separator + "upload";
	
	
	@RequestMapping(value = "/displayfile", method = RequestMethod.GET)
	public ResponseEntity<byte[]>  displayFile(String filename) {
		ResponseEntity<byte[]> entity = null;
		
		InputStream in = null;
		
		try {
			in =  new FileInputStream(new File(uploadPath, filename));
			
			MediaType mType =	DWUtils.getMediaType(filename);
			
			HttpHeaders headers = new HttpHeaders(); //헤더 작업하기
			
			
			if (mType != null) {//이미지 파일이라는 뜻
				
				headers.setContentType(mType);
				
			}else {
				
			}
			
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), 
												headers, HttpStatus.OK);
		
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
			
		}finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
		return entity;
	}
	
	@RequestMapping(value = "/uploadform", method = RequestMethod.POST)
	public String uploadForm(MultipartHttpServletRequest request, Model model) throws Exception {
		
		String id = request.getParameter("id");
		//System.out.println(id);
		MultipartFile file = request.getFile("file"); //파일을 한번에 여러개 업로드할땐 FileMap을 이용한다
		
		//System.out.println(file.getOriginalFilename());
		//System.out.println(file.getSize());
		//System.out.println(file.getBytes()); //파일에 있는 콘텐츠를 바이트로 바꾼거 이게 왜 중요하냐면
		
		
	
		
		
		 String uploadedFilename= DWUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
			model.addAttribute("uploadedFilename", uploadedFilename);
			
		// System.out.println(uploadedFilename);
		return "test";
	}
	
	@RequestMapping(value = "/uploadform", method = RequestMethod.GET)
	public String uploadForm() {
		
		return "uploadform";
	}
	
	
	
	@RequestMapping(value = "/jsontest", method = RequestMethod.GET)
	@ResponseBody
		public  MemberDTO jsonTest() {
		return new MemberDTO("m001", "111", "kim", "2022-01-01");
	}
	
	
	@RequestMapping(value = "/makefolder", method = RequestMethod.GET)
	public String makefolder() {
		 
	 String uploadpath = DWUtils.makefolder("C:"+File.separator+"upload");
		
	 //System.out.println(uploadpath);
	 
	 
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
	
	
	//클래스는 한번 만들면 수정하지 않고 재사용해야 재사용율이 높다고 한다
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		System.out.println(DWUtils.makefolder("C:"+File.separator+"upload"));
		
		
		

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
