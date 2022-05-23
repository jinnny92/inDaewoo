package kr.co.m.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.domain.CommandAction;
import kr.co.domain.mDTO;
import kr.co.m.dao.mDAO;
import kr.co.menu.MenuCommand;

public class InsertMemberCommand implements MenuCommand {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		
		String name = request.getParameter("name");
		
	
		String sAge = request.getParameter("age");
	
	
		int age = Integer.parseInt(sAge);
		
		
		
		
		
		mDAO mdao = new mDAO();
		
		mdao.insert(new mDTO(id, name, age));
		
		
		
		return new CommandAction("/member/loginui.do", false);
	}

}
