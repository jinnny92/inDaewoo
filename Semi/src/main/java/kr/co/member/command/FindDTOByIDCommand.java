package kr.co.member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.domain.CommandAction;
import kr.co.domain.MemberDTO;
import kr.co.member.dao.MemberDAO;
import kr.co.menu.MenuCommand;

public class FindDTOByIDCommand implements MenuCommand {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.finddtobyid(new MemberDTO(id, null, null, null, null, null));
		
		request.setAttribute("dto", dto);
		
		
		return new CommandAction("/jsp/member/finddtobyid.jsp", false);
	}

}
