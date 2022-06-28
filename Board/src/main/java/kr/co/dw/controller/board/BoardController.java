package kr.co.dw.controller.board;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.inject.Inject;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.dw.domain.BoardDTO;
import kr.co.dw.domain.PageTO;
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
	
	
	
	//비밀번호 인증용 외부 클래스
	 public class UserAuthentication extends Authenticator{
	      private PasswordAuthentication pwa;
	      
	      public UserAuthentication(String id, String pw) {
	         pwa = new PasswordAuthentication(id, pw);
	      }
	      
	      @Override
	      public PasswordAuthentication getPasswordAuthentication() {
	         // TODO Auto-generated method stub
	         return pwa;
	      }
	      
	   }
	
	
	@RequestMapping(value = "/sendMail", method = RequestMethod.POST)
		public void send(String from, String to, 
				String title, String content, String pw) {
		
		Properties props = System.getProperties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.naver.com");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");
		
		Authenticator auth = new UserAuthentication(from, pw);
		
		Session session = Session.getDefaultInstance(props, auth);
		
		
		//실제로 메일을 전달할 수 있는 객체 만들기
		MimeMessage mMsg = new MimeMessage(session);
		
		try {
			mMsg.setSentDate(new Date());
			
			InternetAddress fromId = new InternetAddress(from);
			mMsg.setFrom(fromId);
			
			
			InternetAddress toId = new InternetAddress(to);
			Address[] arr = {toId};
		
			mMsg.setRecipients(Message.RecipientType.TO,arr);//setTo가 없다
			mMsg.setSubject(title, "UTF-8");
			mMsg.setText(content, "UTF-8");
			mMsg.setHeader("content-Type", "text/html");
			
			Transport.send(mMsg, mMsg.getAllRecipients());
			
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	
	
   @RequestMapping(value = "/sendMail", method = RequestMethod.GET)
   public void sendMail() {
      
   }
	
	
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
		public void search(Integer curpage, String criteria, String keyword, Model model) {
		
		if (curpage == null) {
			curpage = 1;
		}
		
		PageTO<BoardDTO> pt	=	bService.search(curpage, criteria, keyword);
		//서치로 페이징처리 한다고 하면 PageTO가 나와야함
		
		model.addAttribute("list", pt.getList());
		model.addAttribute("pt", pt);
		model.addAttribute("criteria", criteria);
		model.addAttribute("keyword", keyword);
	}
	
	
	
    @RequestMapping(value = "/{bno}/uploadall", method = RequestMethod.GET)
    public ResponseEntity<List<String>> getAllUpload(@PathVariable("bno") int bno){
       ResponseEntity<List<String>> entity = null;

       try {
		
    	List<String> list  = uService.getAllUpload(bno);
    	   entity = new ResponseEntity<List<String>>(list, HttpStatus.OK);
    	   
	} catch (Exception e) {
		e.printStackTrace();
		entity = new ResponseEntity<List<String>>(HttpStatus.BAD_REQUEST);
	}
       
       return entity;
       
    }
    
	
	@RequestMapping(value = "/delete/{bno}", method = RequestMethod.POST)
		public String delete(@PathVariable("bno") int bno) {
		
		List<String> list = uService.getAllUpload(bno);
		
		System.out.println(list);
		
		bService.delete(bno);
		
		
		for (int i = 0; i < list.size(); i++) {
			String filename	= list.get(i);
			DWUtils.deleteFile(uploadPath, filename);
		}
		
		return "redirect:/board/list";
	}
	
	
	
	
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String> insert(MultipartHttpServletRequest request, Model model) {
		ResponseEntity<String> entity = null;
		
		String title =	request.getParameter("title");
		String writer =	request.getParameter("writer");
		String content =	request.getParameter("content");
		
		BoardDTO bDto = new BoardDTO(0, title, content, writer, null, null, 0);
		
		
		
			try {
				
				//List<MultipartFile> list = request.getFiles("file");
				
				Map<String, MultipartFile>	map = request.getFileMap();
				Set<String>	set = map.keySet();
				Iterator<String> it = set.iterator();
				 List<String> filenameList = new ArrayList<String>();
				
				while (it.hasNext()) {
					String key =  it.next();
					MultipartFile file = map.get(key);
					
					 String uploadedFilename = DWUtils.uploadFile(uploadPath, 
			                  file.getOriginalFilename(), file.getBytes());
					 
					 filenameList.add(uploadedFilename);
				}
		 
				 bDto.setFilenameList(filenameList);
				 
				 bService.insert(bDto);
				 
				 entity = new ResponseEntity<String>(bDto.getBno()+"", HttpStatus.OK);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				entity = new ResponseEntity<String>(-1+"", HttpStatus.BAD_GATEWAY);
			}
		
		return entity;
	}
	
	
	
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<String> update(MultipartHttpServletRequest request) {
		
		ResponseEntity<String> entity = null;
		
		
		try {
			String SBno  = request.getParameter("bno"); 
			int bno = Integer.parseInt(SBno);
			
			String title =	request.getParameter("title");
			
			String writer =	request.getParameter("writer");
			
			String content = request.getParameter("content");
			
			String deleteFilenames = request.getParameter("deleteFilenameArr"); //하나의 문자열로 들어온 것이다 콤마를 이용하면 문자열배열을 만들 수 있다
			
			
			
			String[] arr = deleteFilenames.split(",");
			
			
			Map<String, MultipartFile>	map	=	request.getFileMap();
			List<String> fileList = new ArrayList<String>();
			
			
			Set<String> set = map.keySet(); //key를 가져오는 메서드 set형태
			
			Iterator<String> it = set.iterator();
			while (it.hasNext()) {
				String key =  it.next();
				
				MultipartFile file	= map.get(key);
				String orgFilename = file.getOriginalFilename();
				
			try {
				String uploadedFilename = DWUtils.uploadFile(uploadPath, orgFilename , file.getBytes());
				fileList.add(uploadedFilename);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			}
	
				
		
			
			 
			BoardDTO bDto = new BoardDTO(bno, title, content, writer, null, null, 0, null);
			
			bService.update(bDto, arr, fileList);
			
			for (int i = 0; i < arr.length; i++) {//0보다 크다는 이야기는 삭제된 파일이 있다는 뜻이다
				String deleteFilename  = arr[i];
				DWUtils.deleteFile(uploadPath, deleteFilename);
			}
			
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>("FAIL", HttpStatus.BAD_GATEWAY);
		}
		
		
		
		
		
	return  entity;
}
	
	
	/*
	 * @RequestMapping(value = "/update", method = RequestMethod.POST) public String
	 * update(BoardDTO bDto) { bService.update(bDto);
	 * 
	 * 
	 * 
	 * return "redirect:/board/read/" +bDto.getBno(); }
	 */
	
	
	@RequestMapping(value = "/update/{bno}", method = RequestMethod.GET)
		public String updateUI(@PathVariable("bno") int bno, Model model) {
		
		
		BoardDTO bDto =	bService.updateUI(bno);
		model.addAttribute("bDto", bDto);
		
		return "/board/update";
	}
	
	
	@RequestMapping(value = "/read/{bno}", method = RequestMethod.GET)
		public String read(@PathVariable("bno") int bno, Model model, HttpServletRequest request) {
		String ip = request.getRemoteAddr();
		BoardDTO bDto = bService.read(bno, ip);
		model.addAttribute("bDto", bDto);
		
		
		return "/board/read";
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
	public String list(Integer curpage, Model model) {
		
		if (curpage == null) { // http://localhost:8900/board/list 일 때 curpage는 1이다
			curpage = 1;
		}
		
//		List<BoardDTO> list = bService.list();
		
		
		
		PageTO<BoardDTO> pt = bService.list(curpage);
		
		model.addAttribute("list", pt.getList());
		model.addAttribute("pt", pt);
		
		return "/board/list";
	}
	
}
