package kr.co.member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.domain.CommandAction;
import kr.co.domain.MemberDTO;
import kr.co.member.dao.MemberDAO;
import kr.co.menu.MenuCommand;

public class InsertMemberCommand implements MenuCommand {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		
		String birthday = request.getParameter("birthday");
		
		
		String phonenumber  = request.getParameter("phonenumber");
		
		
		String eail = request.getParameter("email");
		
		MemberDAO mdao = new MemberDAO();
		
		mdao.insert(new MemberDTO(id, pw, name, birthday, phonenumber, eail));
		
		
		
		return new CommandAction("/member/login.do", true);
	}

}
