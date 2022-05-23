package kr.co.dw.member.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.board.command.BoardCommand;
import kr.co.board.domain.BoardCommandAction;
import kr.co.board.dao.MemberDAO;
import kr.co.board.domain.MemberDTO;

public class ListCommand implements BoardCommand {
	@Override
	public BoardCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> list = dao.list();
		
		HttpSession session = request.getSession(false);
		if (session == null) {
			return new BoardCommandAction("/loginui.do", true);
		}
		MemberDTO login = (MemberDTO) session.getAttribute("login");
		if (login == null || !login.getId().equals("admin")) {
			return new BoardCommandAction("/board/main.do", true);
		}

		
		request.setAttribute("list", list);
		

		return new BoardCommandAction("member/jsp/list.jsp", false);
	}
}
