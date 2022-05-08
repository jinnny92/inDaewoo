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
		String id = request.getParameter("id");

		String name = request.getParameter("name");
		String pw = request.getParameter("pw");
		String phonenumber = request.getParameter("phonenumber");
		String birthday = request.getParameter("birthday");
		String email = request.getParameter("email");

		MemberDAO dao = new MemberDAO();

		dao.update(new MemberDTO(id, pw, name, birthday, phonenumber, email));

		return new BoardCommandAction("/list.do", true);
	}

}
