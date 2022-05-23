package kr.co.dw.member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.board.command.BoardCommand;
import kr.co.board.domain.BoardCommandAction;
import kr.co.board.dao.MemberDAO;
import kr.co.board.domain.MemberDTO;

public class UpdateCommand implements BoardCommand {

	@Override
	public BoardCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sId = request.getParameter("id");
		int id = Integer.parseInt(sId);
		
		String name = request.getParameter("name");
		
		String sAge = request.getParameter("age");
		int age = Integer.parseInt(sAge);
		
		MemberDAO dao = new MemberDAO();
		
		dao.update(new MemberDTO(id, name, age));
		
		return new BoardCommandAction("/list.do", true);
	}

}
