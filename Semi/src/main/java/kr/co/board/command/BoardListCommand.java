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

public class BoardListCommand implements MenuCommand {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		BoardDAO bdao = new BoardDAO();
		
		List<BoardDTO> list = bdao.list();
		
		
		request.setAttribute("list", list);
		
		
		return new CommandAction("/jsp/board/list.jsp", false);
	}

}
