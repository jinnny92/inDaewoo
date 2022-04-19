package kr.co.dw.member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.dw.member.dto.CommandAction;

public class LogoutCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//request.getSession();
		//request.getSession(true); 위 두개는 세션이 있으면 있는거 주고 없으면 만들어서라도 줘 라는뜻
		
		HttpSession session = request.getSession(false); //세션이 있으면 있는거 주고 없으면 null값 넘기라는 뜻
		
		if (session != null) {
			session.invalidate(); //세션을 무효화 시키는 작업
			
		}
		
		
		return new CommandAction("list.do", true);
	}

}
