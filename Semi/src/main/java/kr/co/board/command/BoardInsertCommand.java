package kr.co.board.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.board.dao.BoardDAO;
import kr.co.domain.BoardDTO;
import kr.co.domain.CommandAction;
import kr.co.menu.MenuCommand;

public class BoardInsertCommand implements MenuCommand {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String writer = request.getParameter("writer");
		
		String title = request.getParameter("title");
		
		String contene = request.getParameter("content");
		
		
		BoardDAO bdao = new BoardDAO();
		
		bdao.insert(new BoardDTO(0, writer, title, contene, null, null, 0, 0, 0, 0, null));
		
		return new CommandAction("/board/list.do", true);
	}

}
