package kr.co.board.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.board.dao.BoardDAO;
import kr.co.board.domain.BoardCommandAction;
import kr.co.board.domain.BoardDTO;

public class ListBoardCommand implements BoardCommand {

	@Override
	public BoardCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
<<<<<<< HEAD
		
		BoardDAO bDao = new BoardDAO();
		List<BoardDTO> list = bDao.list();
		
		request.setAttribute("list", list);
=======
		// TODO Auto-generated method stub
		
		BoardDAO bDao = new BoardDAO();
		
		List<BoardDTO> list = bDao.list();
		
		request.setAttribute("list", list);
		
		System.out.println(list);
		
>>>>>>> refs/remotes/origin/master
		
		return new BoardCommandAction("/jsp/board/list.jsp", false);
	}

}
