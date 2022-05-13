package kr.co.board.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.board.domain.BoardCommandAction;
import kr.co.board.domain.MemberDTO;

public class ReplyUIBoardCommand implements BoardCommand {

	@Override
	public BoardCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sNum = request.getParameter("num");
		int num = Integer.parseInt(sNum);

		request.setAttribute("orgnum", num);
		HttpSession session = request.getSession(false);
		if (session == null) {
			return new BoardCommandAction("/loginui.do", true);
		}
		MemberDTO login = (MemberDTO) session.getAttribute("login");
		
		if (login == null ) {
			return new BoardCommandAction("/loginui.do", true);
		}
		
		
		return new BoardCommandAction("/jsp/board/reply.jsp", false);
	}

}
