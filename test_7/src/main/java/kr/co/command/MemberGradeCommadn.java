package kr.co.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.MemberDAO;
import kr.co.dao.VoteDAO;
import kr.co.domain.CommandAction;
import kr.co.domain.MemberDTO;
import kr.co.domain.MemberGradeDTO;

public class MemberGradeCommadn implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		MemberDAO dao = new MemberDAO();
		
		List<MemberGradeDTO> list = dao.grade();
		request.setAttribute("list", list);
		return new CommandAction(false, "/jsp/vote/grade.jsp");
	}

}
