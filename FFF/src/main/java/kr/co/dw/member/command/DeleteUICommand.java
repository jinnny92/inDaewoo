package kr.co.dw.member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.board.command.BoardCommand;
import kr.co.board.domain.BoardCommandAction;
import kr.co.board.domain.MemberDTO;

public class DeleteUICommand implements BoardCommand {

	@Override
	public BoardCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		if (session == null) {
			return new BoardCommandAction("/loginui.do", true);
		}
		MemberDTO login = (MemberDTO) session.getAttribute("login");
		if (login == null || !login.getId().equals("admin")) {
			return new BoardCommandAction("/board/main.do", true);
		}
		String id = request.getParameter("id");

		request.setAttribute("id", id);
		
		
		
		return new BoardCommandAction("member/jsp/delete.jsp", false);
	}

}
