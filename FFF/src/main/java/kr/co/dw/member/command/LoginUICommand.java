package kr.co.dw.member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.board.command.BoardCommand;
import kr.co.board.domain.BoardCommandAction;

public class LoginUICommand implements BoardCommand {

	@Override
	public BoardCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String referer = request.getHeader("referer");
		request.getSession().setAttribute("referer", referer);
		return new BoardCommandAction("member/jsp/login.jsp", false);
	}

}
