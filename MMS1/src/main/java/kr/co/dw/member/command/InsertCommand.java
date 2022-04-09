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
		//1. 사용자가 보내준 데이터 획득 및 가공
		String sId = request.getParameter("id");
		int id = Integer.parseInt(sId);
		String name = request.getParameter("name");
		
		String sAge = request.getParameter("age");
		int age = Integer.parseInt(sAge);
		
		//2. DAO객체 생성 및 해당 메서드 호출
		
		MemberDAO dao = new MemberDAO();
		dao.insert(new MemberDTO(id, name, age));
		
		
		//3. 해당 메서드가 반환한 데이터를 바인딩(저장)
		
		//4. 포워딩 객체 생성 및 반환
		
		return new CommandAction("list.do", true);
		
		
	}

}
