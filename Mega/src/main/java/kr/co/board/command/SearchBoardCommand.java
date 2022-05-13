package kr.co.board.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.board.dao.BoardDAO;
import kr.co.domain.BoardDTO;
import kr.co.domain.CommandAction;
import kr.co.menu.MenuCommand;

public class SearchBoardCommand implements MenuCommand {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String criteria = request.getParameter("criteria");
		String keyword = request.getParameter("keyword");
		
		BoardDAO dao = new BoardDAO();
		List<BoardDTO> list =	dao.search(criteria, keyword);
		request.setAttribute("list", list);
	
		
		
		
		
		return new CommandAction("/jsp/board/search.jsp", false);
	}

}
