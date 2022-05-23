package kr.co.dw.member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dw.member.dao.MemberDAO;
import kr.co.dw.member.dto.CommandAction;
import kr.co.dw.member.dto.MemberDTO;

public class InsertCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//1. 사용자가 보내준 데이터 획득및 가공
		String sId = request.getParameter("id");
		int id = Integer.parseInt(sId);
		
		String name = request.getParameter("namd");
		
		String sAge = request.getParameter("age");
		int age = Integer.parseInt(sAge);
		
		//2. DAO객체 생성및 해당 메서드 호출
		MemberDAO dao = new MemberDAO();
		dao.insert(new MemberDTO(id, name, age));
		
		//3. 해당 메서드가 반환한 데이터를 바인딩(저장)
		//위가void였으므로 바인딩 할 필요없음 select문일때만 사용
		
		//4.포워딩 객체 생성 및 반환
		return new CommandAction("list.do", true);
		//목록보기로 가려면 list.do(db로 가는거, 데이터 가져오려면 ~.do) list.jsp는 그냥 빈 파일일 뿐
		// 어차피 데이터 바인딩된것도 없으니 주소와 내용을 맞춰주려고 false를 true로 바꿔줬음 redirect방식
	}

}
