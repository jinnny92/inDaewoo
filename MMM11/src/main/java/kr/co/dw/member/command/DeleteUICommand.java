package kr.co.dw.member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dw.member.dao.MemberDAO;
import kr.co.dw.member.dto.CommandAction;
import kr.co.dw.member.dto.MemberDTO;

public class DeleteUICommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String sId = request.getParameter("id");
		int id = Integer.parseInt(sId);
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.deleteUICommand(new MemberDTO(id, null, 0));
		
		request.setAttribute("dto", dto);
		
		return new CommandAction("member/jsp/delete.jsp", false);
	}

}
