package kr.co.dw.member.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dw.member.dao.MemberDAO;
import kr.co.dw.member.dto.CommandAction;
import kr.co.dw.member.dto.MemberDTO;

public class ListCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Command 클래스에서 하는 일 4가지
		
		//1. 클라이언트가 보내 준 데이터를 획득 및 가공
		
		//2. DAO클래스의 객체를 생성 및 해당 메서드 호출
		
		//3. dao에서 반환한 데이터 바인딩(저장) 저장한걸 jsp쪽으로 보내주는것 
		
		//4. 포워딩작업 ( CPU제어권을 넘겨주는것 서블릿에서 jsp쪽으로 제어권을 넘겨줘야함)
		
		
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> list = dao.list();
		
		request.setAttribute("list", list);
		
		
		return new CommandAction("member/jsp/list.jsp", false); //isredirect방식으로 할거냐 왜 
		//화면을 보여주고 싶으면 jsp DB작업을 하러가면  .do(컨트롤러로 가서)
		//ui들어간것과 안들어간것 ui는 입력 화면 안들어간곳은 실제로 DB작업 하는곳
	}

}
