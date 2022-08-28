package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.VoteDAO;
import kr.co.domain.CommandAction;
import kr.co.domain.VoteDTO;

public class VoteInsertCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String v_jumin = request.getParameter("v_jumin");
		String v_name = request.getParameter("v_name");
		String m_no = request.getParameter("m_no");
		String v_time = request.getParameter("v_time");
		String v_area = request.getParameter("v_area");
		String c_confirm = request.getParameter("c_confirm");
		
		VoteDTO dto = new VoteDTO(v_jumin, v_name, m_no, v_time, v_area, c_confirm);
		
		VoteDAO dao = new VoteDAO();
		
		dao.insert(dto);
		
		return new CommandAction(true, "/index.jsp");
	}

}
