package kr.co.m.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.domain.CommandAction;
import kr.co.domain.mDTO;
import kr.co.m.dao.mDAO;
import kr.co.menu.MenuCommand;

public class DeleteMemberCommand implements MenuCommand {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		
		mDAO mdao = new mDAO();
		
		mdao.delete(new mDTO(id, null, 0));
		
		
		
		return new CommandAction("/member/list.do", true);
	}

}
