package kr.co.member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.domain.CommandAction;
import kr.co.domain.MemberDTO;
import kr.co.member.dao.MemberDAO;
import kr.co.menu.MenuCommand;

public class UpdateCommand implements MenuCommand {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String sId = request.getParameter("id");
		int id = Integer.parseInt(sId);
		
		String name = request.getParameter("name");
		
		String sAge = request.getParameter("age");
		int age = Integer.parseInt(sAge);
		
		MemberDAO dao = new MemberDAO();
		dao.update(new MemberDTO(id, name, age));
		
		
		
		return new CommandAction("/member/list.do", true);
	}

}
