package kr.co.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.VoteDAO;
import kr.co.domain.CommandAction;
import kr.co.domain.VoteConfirmDTO;

public class VoteListCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		VoteDAO dao = new VoteDAO();
		
		List<VoteConfirmDTO> list = dao.list();
		
		request.setAttribute("list", list);
		
		return new CommandAction(false, "/jsp/vote/list.jsp");
	}

}
