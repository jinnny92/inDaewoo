package kr.co.board.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.board.dao.BoardDAO;
import kr.co.board.domain.BoardCommandAction;
import kr.co.board.domain.BoardDTO;

public class LoginBoardCommand implements BoardCommand {

	@Override
	public BoardCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String num = request.getParameter("id");
		int id = Integer.parseInt(num);
		
		String repRoot = request.getParameter("pw");
		
		BoardDAO dao = new BoardDAO();
		
		BoardDTO login = new BoardDTO(id, null, null, null, null, repRoot, 0, 0, 0, 0);
		
		HttpSession session = request.getSession();
		session.setAttribute("login", login);
		
		dao.login(login);
		
		
		return new BoardCommandAction("/board/list.do", true);
	}

}
