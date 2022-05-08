package kr.co.dw.member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.board.command.BoardCommand;
import kr.co.board.domain.BoardCommandAction;
import kr.co.board.dao.MemberDAO;
import kr.co.board.command.BoardCommand;
import kr.co.board.domain.MemberDTO;

public class insertCommand implements BoardCommand {

	@Override
	public BoardCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");

		String pw = request.getParameter("pw");

		String name = request.getParameter("name");

		String Birthday = request.getParameter("birthday");

		String Birthday2 = request.getParameter("birthday2");
		Birthday = Birthday + Birthday2;
		String Phonenumber1 = request.getParameter("phonenumber1");
		String Phonenumber2 = request.getParameter("phonenumber2");
		String Phonenumber3 = request.getParameter("phonenumber3");
		String Phonenumber = Phonenumber1 + Phonenumber2 + Phonenumber3;
		
		
		String Email = request.getParameter("email");

		MemberDTO dto = new MemberDTO(id, pw, name, Birthday, Phonenumber, Email);

		MemberDAO dao = new MemberDAO();
		dao.insert(dto);

		return new BoardCommandAction("/board/main.do", true);
	}

}
