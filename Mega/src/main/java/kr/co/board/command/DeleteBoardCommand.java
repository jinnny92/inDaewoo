package kr.co.board.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.board.dao.BoardDAO;
import kr.co.domain.CommandAction;
import kr.co.menu.MenuCommand;

public class DeleteBoardCommand implements MenuCommand {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String sNum = request.getParameter("num");
		int num = Integer.parseInt(sNum);
		
		BoardDAO dao = new BoardDAO();
		
		dao.delete(num);
		
		
		
		
		return new CommandAction("/board/list.do", true);
	}

}
