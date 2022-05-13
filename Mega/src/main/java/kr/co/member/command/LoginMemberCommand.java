package kr.co.member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.domain.CommandAction;
import kr.co.domain.MemberDTO;
import kr.co.member.dao.MemberDAO;
import kr.co.menu.MenuCommand;

public class LoginMemberCommand implements MenuCommand {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		
		
		MemberDAO dao = new MemberDAO();
		MemberDTO login = dao.login(new MemberDTO(id, pw, null));
		
		HttpSession session = request.getSession();
		
		session.setAttribute("login", login);
		
		return new CommandAction("/member/list.do", true);
	}

}
