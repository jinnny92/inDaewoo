package mytld.mycompany.myapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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
	
	
	   @RequestMapping(value = "/ajaxform", method = RequestMethod.POST, 
			   produces = "text/plain;charset=UTF-8")
	   public ResponseEntity<String> ajaxform(MultipartHttpServletRequest request, 
	                                 Model model) throws Exception {
	      
		   		String id = request.getParameter("id");
		   		
		   		System.out.println(id);
		   		System.out.println("id를 데이터베이스에 저장함");
		   		System.out.println("저장이 잘 됐으면, 아래의 파일 저장하는 코드 실행");
		   		System.out.println("저장이 안 됐으면, 아래의 파일 저장하는 코드 미실행");
		   
	      ResponseEntity<String> entity = null;
	      
	      try {
	         //여러 개의 파일이 업로드 되었을 때, 해당 파일들의 목록을 가져오는 코드
	         List<MultipartFile> list = request.getFiles("file");
	         
	         // 여러 개의 파일들이 업로드 된 후 파일명을 저장할 리스트
	         List<String> filenameList = new ArrayList<String>();
	         
	         // 업로드 된 여러 개의 파일들을 반복문을 이용해서 실제로 저장하게 하는 코드
	         for(int i=0;i<list.size();i++) {
	            // list에 들어 있는 MultipartFile 객체 하나씩 획득
	            MultipartFile file = list.get(i);
	            
	            // multipartfile에 들어 있는 파일 데이터를 파일로 저장하는 코드
	            String uploadedFilename = DWUtils.uploadFile(uploadPath, 
	                  file.getOriginalFilename(), file.getBytes());
	            
	            // 여러 개의 업로드된 파일명을 저장하는 코드
	            filenameList.add(uploadedFilename);
	         }
	         
	         entity = new ResponseEntity<String>(filenameList.toString(), HttpStatus.OK);
	      } catch (Exception e) {
	         e.printStackTrace();
	         entity = new ResponseEntity<String>("FAIL", HttpStatus.BAD_REQUEST);
	      }
	      
	      return entity;
	   }
	
	
	@RequestMapping(value = "/ajaxform", method = RequestMethod.GET)
	public String ajaxForm() {
		
		return "ajaxform";
	}
	
	
	@RequestMapping(value = "/deletefile", method = RequestMethod.POST)
	public ResponseEntity<String> deleteFile(String uploadedFilename){
		ResponseEntity<String> entity = null;
		
		try {
			DWUtils.deleteFile(uploadPath, uploadedFilename);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>("FAIL", HttpStatus.BAD_REQUEST);
		}
		
		
		return entity;
	}
	
	
	@RequestMapping(value = "/displayfile", method = RequestMethod.GET)
	public ResponseEntity<byte[]>  displayFile(String filename) {
		ResponseEntity<byte[]> entity = null;
		
		InputStream in = null;
		
		try {
			in =  new FileInputStream(new File(uploadPath, filename));
			
			MediaType mType =	DWUtils.getMediaType(filename);
			
			HttpHeaders headers = new HttpHeaders(); //헤더 작업하기
			
			
			if (mType != null) {
				//이미지 파일을 썸네일에 보여주기 위한 코드
				//파일 업로드 하고 이미지 파일의 썸네일을 보여줄 때 한 번 실행이 되고
				//jsp파일에서 이미지 파일의 썸네일을 클릭했을 때 원본 파일을 보여줄 때 한 번 더 실행이 된다
				headers.setContentType(mType);
				
			}else {//여기는 일반 파일의 썸네일을 클릭하면 실행되는 코드
				//다운로드 받을때 컨텐트타입 이렇게 적어주면 됨 파일 다운로드하게 하는 마임타입(OCTET_STREAM)
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				//오리지널 네임을 추출하게 하기 위해 오리지널 네임 바로 앞에 있는 _인덱스를 구하고
				//그 인덱스에 1을 더해서 오리지널 네임의 첫 글자 인덱스 획득
				int idx = filename.indexOf("_") +1;
				
				//오리지널 네임 추출
				String oriName = filename.substring(idx);
				
				//브라우저에서 파일명이 깨지지 않게 하기 위해서 브라우저에서 요구하는 인코딩으로 변경
				oriName = new String(oriName.getBytes("UTF-8"), "ISO-8859-1");
				
				//헤어데 새로운 이름으로 파일명 지정
				// \"는 문자열 안에 "(큰따옴표)를 넣기 위해서 \를 추가했음
				//큰따옴표는 이스케이프 문자라 문자열에 표기할 때 단독으로 표기 불가능함
				headers.add("Content-Disposition", "attachment;filename=\""+oriName+"\"");
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
		
		
		//System.out.println(file.getOriginalFilename());
		//System.out.println(file.getSize());
		//System.out.println(file.getBytes()); //파일에 있는 콘텐츠를 바이트로 바꾼거 이게 왜 중요하냐면
		
		
		//여러 개의 파일이 업로드 되었을 때, 해당 파일들의 목록을 가져오는 코드
		List<MultipartFile>	list = request.getFiles("file");
		
		//여러 개의 파일들이 업로드 된 후 파일명을 저장할 리스트
		List<String> filenameList = new ArrayList<String>();
		
		
		//업로드 된 여러 개의 파일들을 반복문을 이용해서 실제로 저장하게 하는 코드
		for (int i = 0; i < list.size(); i++) {
			
			// list에 들어 있는 MultipartFile 객체 하나씩 획득
			MultipartFile file	= list.get(i);
			
			//multipartfile에 들어있는 파일 데이터를 파일로 저장하는 코드
			 String uploadedFilename= DWUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
			
			 
			 // 여러 개의 업로드된 파일명을 저장하는 코드
			 filenameList.add(uploadedFilename);
		}
		
		
	
//		Map<String, MultipartFile> map	=	request.getFileMap();
//		System.out.println(map);
		
		//파일을 한번에 여러개 업로드할땐 FileMap을 이용한다 MAP을 이용하면 file을 그냥 file로 두면 안되고 반복문 돌려서 파일1, 2 이런식으로해야한다
		//MultipartFile file = request.getFile("file"); 
		
		model.addAttribute("filenameList", filenameList);
			
		// System.out.println(uploadedFilename);
		return "test";
	}
	
	
	@RequestMapping(value = "/uploadform", method = RequestMethod.GET)
	public String uploadForm() {
		
		return "uploadform";
	}
	
	
	
	
	
	/*
	 * @RequestMapping(value = "/uploadform", method = RequestMethod.POST) public
	 * String uploadForm(MultipartHttpServletRequest request, Model model) throws
	 * Exception {
	 * 
	 * String id = request.getParameter("id"); //System.out.println(id);
	 * MultipartFile file = request.getFile("file"); //파일을 한번에 여러개 업로드할땐 FileMap을
	 * 이용한다
	 * 
	 * //System.out.println(file.getOriginalFilename());
	 * //System.out.println(file.getSize()); //System.out.println(file.getBytes());
	 * //파일에 있는 콘텐츠를 바이트로 바꾼거 이게 왜 중요하냐면
	 * 
	 * 
	 * 
	 * 
	 * 
	 * String uploadedFilename= DWUtils.uploadFile(uploadPath,
	 * file.getOriginalFilename(), file.getBytes());
	 * model.addAttribute("uploadedFilename", uploadedFilename);
	 * 
	 * // System.out.println(uploadedFilename); return "test"; }
	 * 
	 * @RequestMapping(value = "/uploadform", method = RequestMethod.GET) public
	 * String uploadForm() {
	 * 
	 * return "uploadform"; }
	 */
	
	
	
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
