package kr.co.m.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.domain.CommandAction;
import kr.co.domain.mDTO;
import kr.co.m.dao.mDAO;
import kr.co.menu.MenuCommand;

public class LoginMemberCommand implements MenuCommand {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		
		String pw = request.getParameter("pw");
		int age = Integer.parseInt(pw);
		
		mDAO mdao = new mDAO();
		
	mDTO login = mdao.login(new mDTO(id, null, age));
		
	HttpSession session = request.getSession();
	
	session.setAttribute("login", login);
		
		
		return new CommandAction("/main/main2.jsp", true);
	}

}
