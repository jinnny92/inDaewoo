package kr.co.m.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.domain.CommandAction;
import kr.co.domain.mDTO;
import kr.co.m.dao.mDAO;
import kr.co.menu.MenuCommand;

public class ListMemberCommand implements MenuCommand {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		mDAO mdao = new mDAO();
		List<mDTO> list = mdao.list();
		
		request.setAttribute("list", list);
		
		return new CommandAction("/jsp/member/list.jsp", false);
	}

}
