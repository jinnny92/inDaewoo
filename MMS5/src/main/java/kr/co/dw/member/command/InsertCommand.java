package kr.co.dw.member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dw.member.dao.MemberDAO;
import kr.co.dw.member.dto.CommanAction;
import kr.co.dw.member.dto.MemberDTO;

public class InsertCommand implements Command {

	@Override
	public CommanAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sId = request.getParameter("id");
		int id = Integer.parseInt(sId);
		
		String name = request.getParameter("name");
		
		String sAge = request.getParameter("age");
		int age = Integer.parseInt(sAge);
		
		MemberDAO dao = new MemberDAO();
		dao.insert(new MemberDTO(id, name, age));
		
		return new CommanAction("list.do", true);
	}

}
