package kr.co.board.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.AbstractDocument.Content;

import kr.co.board.dao.BoardDAO;
import kr.co.domain.BoardDTO;
import kr.co.domain.CommandAction;
import kr.co.menu.MenuCommand;

public class ReadBoardCommand implements MenuCommand {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String sNum = request.getParameter("num");
		int num = Integer.parseInt(sNum);
		
		BoardDAO dao = new BoardDAO();
		
		BoardDTO dto = dao.read2(num);
		
		
		String content = dto.getContent();
		
		if (content != null) {
	content = content.replace(System.lineSeparator(), "<br>");
	dto.setContent(content);
		
		}
	
		
		request.setAttribute("dto", dto);
		
		
		
		
		return new CommandAction("/jsp/board/read.jsp", false);
	}

}
 