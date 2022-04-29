package kr.co.dw.member.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dw.member.dao.MemberDAO;
import kr.co.dw.member.dto.CommandAction;
import kr.co.dw.member.dto.MemberDTO;

public class ListCommand implements Command{

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Command 클래스에서 하는 일은 총 4가지
		// 1.클라이언트가 보내 준 데이터를 획득 및 가공 RapperClaa.path
		// 2. DAO클래스의 객체를 생성 및 해당 메서드 호출
			MemberDAO dao = new MemberDAO();
			List<MemberDTO> list = dao.list();
		// 3. dao에서 반환한 데이터 바인딩(저장)
			request.setAttribute("list", list);
			
		// 4. 포워딩 작업 (포워딩작업이란:cpu제어권을 넘겨주는 것. 이게 클래스지만 서블릿과 연결된 서블릿, 서블릿에서 jsp쪽으로 제어권을 넘겨줄때 사용)
		
		
		
		return new CommandAction("member/jsp/list.jsp", false); 
		//화면을 보여주고 싶으면 jsp DB작업을 하고 싶으면 do
	}

}
