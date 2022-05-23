package kr.co.board.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.board.dao.BoardDAO;
import kr.co.domain.BoardDTO;
import kr.co.domain.CommandAction;
import kr.co.menu.MenuCommand;

public class ReplyBoardCommand implements MenuCommand {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String sOrgNum = request.getParameter("orgnum");
		int orgnum = Integer.parseInt(sOrgNum);
		
		
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardDAO dao  = new BoardDAO();
		dao.reply(orgnum, new BoardDTO(0, id, title, content, null, null, 0, 0, 0, 0));
		
		//orgnum는 별개로 들어갔음. 앞에 orgnum은 원래 글에 대한 num값이고 boardDTO에 있는 num값은 새로운 num값이 들어가거라 이렇게 해준것임
		
		
		
		return new CommandAction("/board/list.do", true);
	}

}
