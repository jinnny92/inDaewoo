package kr.co.board.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.board.dao.BoardDAO;
import kr.co.board.domain.BoardCommandAction;

public class DeleteBoardCommand implements BoardCommand {
	@Override
	public BoardCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String sNum = request.getParameter("num");
		int num = Integer.parseInt(sNum);
		
		BoardDAO bDao = new BoardDAO();
		
		bDao.delete(num);
		
		return new BoardCommandAction("/board/list.do",true);
	}

}
