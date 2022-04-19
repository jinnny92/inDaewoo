package kr.co.dw.member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.dw.member.dao.MemberDAO;
import kr.co.dw.member.dto.CommandAction;
import kr.co.dw.member.dto.MemberDTO;

public class LoginCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String sId = request.getParameter("id");
		int id = Integer.parseInt(sId);
		
		String pw = request.getParameter("pw");
		int age = Integer.parseInt(pw);
		
		MemberDAO dao = new MemberDAO();
		MemberDTO login = dao.login(new MemberDTO(id, null, age));
		
		//MemberDTO보다 정보가 적게 들어간 LoginDTO를 만들어 사용할 수도 있음 아이디 별칭정도
		
		HttpSession session = request.getSession(); //반환형 있음 get일땐 무조건 반환형있음. set은 없음 
		//이 세션이 없을 확률은 0퍼센트 getSession 뒤에()가 비어있는 이유는 없으면 만들어서라도 달라는 의미. true를 넣거나 비워놓거나
		session.setMaxInactiveInterval(60); //로그인 시간 설정하기 단위는 초 
		
		session.setAttribute("login", login);
		
		
		return new CommandAction("list.do", true);
		//request에 redirect방식으로(같은요청) 하면 데이터 날아감 하지만 session은 아님. 
		//ession은 두개의 스코프로 되어있음 시간, 같은 브라우저
	}

}
