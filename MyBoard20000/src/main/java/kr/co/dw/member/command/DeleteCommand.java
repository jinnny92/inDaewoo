package kr.co.dw.member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.board.command.BoardCommand;
import kr.co.board.domain.BoardCommandAction;
import kr.co.board.domain.MemberDTO;
import kr.co.board.domain.BoardCommandAction;
import kr.co.board.dao.MemberDAO;

public class DeleteCommand implements BoardCommand {

	@Override
	public BoardCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(false);
		if(session == null) {
			return new BoardCommandAction("/loginui.do", true);
		}
		MemberDTO login = (MemberDTO)session.getAttribute("login");
		if(login == null) {
			return new BoardCommandAction("/loginui.do", true);
		}
		
		
		String sId = request.getParameter("id");
		int id = Integer.parseInt(sId);
		
		if(login.getId() != id) {
			return new BoardCommandAction("/loginui.do", true);
		}
		
		MemberDAO dao = new MemberDAO();
		
		dao.delete(new MemberDTO(id, null, 0));
		
		return new BoardCommandAction("list.do", true);
	}

}
