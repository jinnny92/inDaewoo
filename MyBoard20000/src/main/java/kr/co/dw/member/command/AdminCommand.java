package kr.co.dw.member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.board.command.BoardCommand;
import kr.co.board.dao.MemberDAO;
import kr.co.board.domain.BoardCommandAction;
import kr.co.board.domain.MemberDTO;

public class AdminCommand implements BoardCommand {

	@Override
	public BoardCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		System.out.println(session);

		MemberDTO login = (MemberDTO) session.getAttribute("login");
		System.out.println(login);
		if (login == null || login.getId() != 500) {

			return new BoardCommandAction("/main/main.jsp", true);
		} else {
			return new BoardCommandAction("/member/jsp/admin.jsp", true);
		}
			
		

	}

}
