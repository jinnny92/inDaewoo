package kr.co.board.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.board.dao.BoardDAO;
import kr.co.board.domain.BoardCommandAction;
import kr.co.board.domain.BoardDTO;

public class ReplyBoardCommand implements BoardCommand {

	@Override
	public BoardCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sOrgNum = request.getParameter("orgnum");
		int orgNum = Integer.parseInt(sOrgNum);
		
		String writer = request.getParameter("writer");
		
		String title = request.getParameter("title");
		
		String content = request.getParameter("content");
		
		BoardDAO dao = new BoardDAO();
		dao.reply(orgNum, new BoardDTO(0, writer, title, content, null, null, 0, 0, 0, 0));
		
		
		
		return new BoardCommandAction("/board/list.do", true);
	}

}
