package kr.co.member.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import kr.co.domain.CommandAction;
import kr.co.domain.MemberDTO;
import kr.co.member.dao.MemberDAO;
import kr.co.menu.MenuCommand;

public class ListCommand implements MenuCommand {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> list = dao.list();
		
		request.setAttribute("list", list);
		
		
		return new CommandAction("/jsp/member/list.jsp", false);
	}

}
