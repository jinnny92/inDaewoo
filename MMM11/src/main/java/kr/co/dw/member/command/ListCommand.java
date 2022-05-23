package kr.co.dw.member.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
		//1. 클라이언트가 보내준 데이터를 획득 및 가공
		
		//2. MemberDAO클래스의 객체를 생성및 해딩 메서드 호출 
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> list = dao.list();
		
		//3. dao에서 반환한 데이터 바인딩(저장)작업 
		//반환된 데이터를 jsp로 보내야함
		
		request.setAttribute("list", list);
		//request는 usb같은 저장장치 name(key)하고 value를 적어야함. value의 타입이 object라 어떠한 타입도 다 집어 넣을 수 있음
		//하지만 name은 String형이라 문자열로 넣어줘야함 보통 jsp로 보낼 데이터를 파일명과 name과 똑같이 적어줌. 
		//다르게 적어도 되지만 그럼 문서 작업을 해줘야함. 이런 지역변수명까지 문서 작업을 해주긴 좀 그렇다
		//나중에 왼쪽의 "list"라는 이름을 이용해 오른쪽의 list(값)을 가져올 수가 있음
		
		
		//4. 포워딩작업
		
		
		return new CommandAction("member/jsp/list.jsp", false); //false는 Dispatcher방식 
		//일반적으로 바인딩 작업을 할떄 request 객체를 이용해 데이터를 저장하는데 redirect방식으로 포워딩하면 데이터가 없어지기때문에
		//Dispatcher방식으로 하면 request에 바인딩한 데이터가 살아있다
	}

}
