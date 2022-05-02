package kr.co.board.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.board.dao.BoardDAO;
import kr.co.board.domain.BoardCommandAction;
import kr.co.board.domain.BoardDTO;

public class ReadBoardCommand implements BoardCommand {

	@Override
	public BoardCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String sNum = request.getParameter("num");
		int num = Integer.parseInt(sNum);
		
		BoardDAO bDao = new BoardDAO();
		 
		BoardDTO bDto = bDao.read2(num);
		
		
		String content = bDto.getContent();
		content = content.replace(System.lineSeparator(), "<br>");
		bDto.setContent(content);
		
		
		request.setAttribute("bDto", bDto);
		return new BoardCommandAction("/jsp/board/read.jsp", false);
	}

}
