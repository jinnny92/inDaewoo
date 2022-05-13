package kr.co.board.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.board.dao.BoardDAO;
import kr.co.board.domain.BoardCommandAction;
import kr.co.board.domain.BoardDTO;
import kr.co.board.domain.MemberDTO;

public class UpdateUIBoardCommand implements BoardCommand {

	@Override
	public BoardCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String sNum = request.getParameter("num");

		int num = Integer.parseInt(sNum);

		String writer = request.getParameter("writer");
	
		BoardDAO bDao = new BoardDAO();
		
		
		BoardDTO dto = bDao.updateUI(num);
		
		request.setAttribute("dto", dto);
		HttpSession session = request.getSession(false);
		System.out.println(session);
		if (session == null) {
			return new BoardCommandAction("/loginui.do", true);
		}
		MemberDTO login = (MemberDTO) session.getAttribute("login");
		System.out.println(login);
		if(login == null) {
			return new BoardCommandAction("/loginui.do", false);
		}
		if(login.getId().equals("admin")) {
			return new BoardCommandAction("/jsp/board/update.jsp", false);
		}else if(!login.getId().equals(writer)) {
			return new BoardCommandAction("/loginui.do", false);
		}
		
		
		
		
		
		return new BoardCommandAction("/jsp/board/update.jsp", false);
	}

}
