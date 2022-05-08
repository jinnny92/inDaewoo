package kr.co.board.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.board.dao.BoardDAO;
import kr.co.board.domain.BoardCommandAction;
import kr.co.board.domain.BoardDTO;
import kr.co.board.domain.MemberDTO;

public class UpdateBoardCommand implements BoardCommand {

	@Override
	public BoardCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sNum = request.getParameter("num");
		int num = Integer.parseInt(sNum);

		String title = request.getParameter("title");

		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		
		
		BoardDAO bdao = new BoardDAO();

		bdao.update(new BoardDTO(num, null, title, content, null, null, 0, 0, 0, 0));
		return new BoardCommandAction("/board/read.do?num=" + num, true);
	}

}
