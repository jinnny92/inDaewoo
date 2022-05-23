package kr.co.dw.member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.board.command.BoardCommand;
import kr.co.board.domain.BoardCommandAction;

public class DeleteUICommand implements BoardCommand {

	@Override
	public BoardCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String sId = request.getParameter("id");
		int id = Integer.parseInt(sId);
		
		request.setAttribute("id", id);
		
		
		
		return new BoardCommandAction("member/jsp/delete.jsp", false);
	}

}
