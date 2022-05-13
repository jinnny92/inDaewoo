package kr.co.member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.domain.CommandAction;
import kr.co.domain.MemberDTO;
import kr.co.member.dao.MemberDAO;
import kr.co.menu.MenuCommand;

public class UpdateMemberCommand implements MenuCommand {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
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

		
		
		return new CommandAction("/main.do", true);
	}

}
