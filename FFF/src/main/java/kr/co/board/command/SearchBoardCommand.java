package kr.co.board.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.board.dao.BoardDAO;
import kr.co.board.domain.BoardCommandAction;
import kr.co.board.domain.BoardDTO;

public class SearchBoardCommand implements BoardCommand {

	@Override
	public BoardCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String criteria = request.getParameter("criteria");
		System.out.println(criteria);
		String keyword = request.getParameter("keyword");
		System.out.println(keyword);
		BoardDAO dao = new BoardDAO();
		List<BoardDTO> list = dao.search(criteria, keyword);
		System.out.println(list);
		request.setAttribute("list", list);

		return new BoardCommandAction("/jsp/board/search.jsp", false);
	}

}
