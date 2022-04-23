package kr.co.board.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.board.domain.BoardCommandAction;

public class InsertUIBoardCommand implements BoardCommand {

	@Override
	public BoardCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
<<<<<<< HEAD
=======
		
		
	
		
		
>>>>>>> refs/remotes/origin/master
		return new BoardCommandAction("/jsp/board/insert.jsp", false);
	}

}
