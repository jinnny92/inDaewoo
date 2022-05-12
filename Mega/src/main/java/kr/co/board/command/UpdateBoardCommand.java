package kr.co.board.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.board.dao.BoardDAO;
import kr.co.domain.BoardDTO;
import kr.co.domain.CommandAction;
import kr.co.menu.MenuCommand;

public class UpdateBoardCommand implements MenuCommand {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sNum = request.getParameter("num");
		int num = Integer.parseInt(sNum);
		

		
		String title = request.getParameter("title");
		
		String content = request.getParameter("content");
		
		System.out.println(title);
		
		System.out.println(content);
		
		
		BoardDAO dao = new BoardDAO();
		dao.update(new BoardDTO(num, null, title, content, null, null, 0, 0, 0, 0));
		
		
		
		
		
		
		return new CommandAction("/board/read.do?num=" + num, true);
	}

}
