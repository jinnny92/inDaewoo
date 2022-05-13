package kr.co.dw.member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.board.command.BoardCommand;
import kr.co.board.domain.BoardCommandAction;

public class LogoutCommand implements BoardCommand {

	@Override
	public BoardCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession(false);
		
		if (session != null) {
			session.invalidate();
			
		}
		
		String url = request.getHeader("referer");
		url = url.substring(21);
		
		if(url.equals("/member/jsp/admin.jsp")) {
			return new BoardCommandAction("/loginui.do", true);
		}

		return new BoardCommandAction(url , true);
	}

}
