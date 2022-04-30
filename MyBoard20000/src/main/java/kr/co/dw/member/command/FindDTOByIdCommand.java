package kr.co.dw.member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.board.command.BoardCommand;
import kr.co.board.domain.BoardCommandAction;
import kr.co.board.dao.MemberDAO;
import kr.co.board.command.BoardCommand;
import kr.co.board.domain.MemberDTO;

public class FindDTOByIdCommand implements BoardCommand {

	@Override
	public BoardCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.클라이언트가 보내준 데이터 획득 및 가공
		
		HttpSession session = request.getSession(false);
		if(session == null) {
			return new BoardCommandAction("/loginui.do", true);
		}
		MemberDTO login = (MemberDTO)session.getAttribute("login");
		if(login == null) {
			return new BoardCommandAction("/loginui.do", true);
		}
		
		String sId = request.getParameter("id");
		int id = Integer.parseInt(sId);
		
		if(login.getId() != id) {
			return new BoardCommandAction("/loginui.do", true);
		}
		
		//2.dao 객체 생성 및 해당 메서드 호출
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.findDTOById(new MemberDTO(id, null, 0));
		//3.반환된 데이터 바인딩
		request.setAttribute("dto", dto);
		//4.포워딩 관련 코드
		
		return new BoardCommandAction("member/jsp/finddtobyid.jsp", false);
	}

}
