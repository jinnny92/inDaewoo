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

public class InsertBoardCommand implements BoardCommand {

	@Override
	public BoardCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String writer = request.getParameter("writer");

		String title = request.getParameter("title");

		String content = request.getParameter("content");
		HttpSession session = request.getSession();
		MemberDTO login = (MemberDTO) session.getAttribute("login");

		String a = login.getId();

		BoardDAO bdao = new BoardDAO();

		bdao.insert(new BoardDTO(0, writer, title, content, null, null, 0, 0, 0, 0), a);
		return new BoardCommandAction("/board/list.do", true);
	}

}
