package kr.co.m.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import kr.co.domain.CommandAction;
import kr.co.menu.MenuCommand;

public class LogoutMemberCommand implements MenuCommand {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		if(session != null) {
			session.invalidate();
			
		}
		
		return new CommandAction("/main/main.jsp", true);
	
	}

}
