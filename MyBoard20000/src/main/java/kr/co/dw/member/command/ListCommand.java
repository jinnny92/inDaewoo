package kr.co.dw.member.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.board.command.BoardCommand;
import kr.co.board.domain.BoardCommandAction;
import kr.co.board.dao.MemberDAO;
import kr.co.board.command.BoardCommand;
import kr.co.board.domain.MemberDTO;

public class ListCommand implements BoardCommand {
	@Override
	public BoardCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Command 클래스에서 하는 일은 4 가지
		// 1. 클라이언트가 보내 준 데이터를 획득 및 가공
		// 2. DAO클래스의 객체를 생성 및 해당 메서드 호출
		MemberDAO dao = new MemberDAO();
		 List<MemberDTO> list = dao.list();
		
		 
		// 3. dao에서 반환한 데이터 바인딩(저장)
		 request.setAttribute("list", list);
		// 4. 포워딩 작업
		
		return new BoardCommandAction("member/jsp/list.jsp", false);
	}
}
