package kr.co.dw.member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dw.member.dao.MemberDAO;
import kr.co.dw.member.dto.CommandAction;
import kr.co.dw.member.dto.MemberDTO;

public class FindDTOByIdCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String sId = request.getParameter("id");
		int id = Integer.parseInt(sId);
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.findDTOById(new MemberDTO(id, null, 0));
		
		request.setAttribute("dto", dto);
		//로그인과 관련된건 세션에 바인딩함 무조건
		//방문자 수와 관련되있는건 어플리케이션에 바인딩함 jsp는 어플리케이션 서블릿은 서블릿컨테스트라고 한다  프로젝트와 같은말
		//그 외에는 무조건 request
		
		
		return new CommandAction("member/jsp/finddtobyid.jsp", false);
	}

}
