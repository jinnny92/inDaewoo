package kr.co.board.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.board.domain.BoardCommandAction;
import kr.co.board.domain.MemberDTO;

public class InsertUIBoardCommand implements BoardCommand {

	@Override
	public BoardCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		MemberDTO login = (MemberDTO) session.getAttribute("login");

		if (session == null) {
			return new BoardCommandAction("/loginui.do", true);
		}
		if (login == null) {
			return new BoardCommandAction("/loginui.do", true);
		}

		return new BoardCommandAction("/jsp/board/insert.jsp", false);
	}

}
