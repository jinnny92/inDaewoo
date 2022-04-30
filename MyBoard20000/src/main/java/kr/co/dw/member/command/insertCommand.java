package kr.co.dw.member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.board.command.BoardCommand;
import kr.co.board.domain.BoardCommandAction;
import kr.co.board.dao.MemberDAO;
import kr.co.board.command.BoardCommand;
import kr.co.board.domain.MemberDTO;

public class insertCommand implements BoardCommand {

	@Override
	public BoardCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String admin = "admin";
		String sId = request.getParameter("id");
		
		int id = Integer.parseInt(sId);
		
		
		String name = request.getParameter("name");
		
		String sAge = request.getParameter("age");
		int age = Integer.parseInt(sAge);
		
		MemberDTO dto = new MemberDTO(id, name, age);
		
		MemberDAO dao = new MemberDAO();
		dao.insert(dto);
		
		return new BoardCommandAction("list.do",true);
	}

}
