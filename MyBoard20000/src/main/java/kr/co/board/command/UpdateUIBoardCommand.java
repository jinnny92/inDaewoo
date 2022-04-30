package kr.co.board.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.board.dao.BoardDAO;
import kr.co.board.domain.BoardCommandAction;
import kr.co.board.domain.BoardDTO;

public class UpdateUIBoardCommand implements BoardCommand {

	@Override
	public BoardCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String sNum = request.getParameter("num");
		
		int num = Integer.parseInt(sNum);
		
		BoardDAO bDao = new BoardDAO();
		BoardDTO dto = bDao.updateUI(num);
		
		request.setAttribute("dto", dto);
		
		return new BoardCommandAction("/jsp/board/update.jsp", false);
	}

}
