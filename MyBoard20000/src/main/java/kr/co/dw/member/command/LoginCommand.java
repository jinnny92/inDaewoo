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

public class LoginCommand implements BoardCommand {

	@Override
	public BoardCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String sId = request.getParameter("id");
			int id = Integer.parseInt(sId);
			
			
			String pw = request.getParameter("pw");
			int age = Integer.parseInt(pw);
			
			MemberDAO dao = new MemberDAO();
			
			MemberDTO login = dao.login(new MemberDTO(id, null, age));
			
			HttpSession session = request.getSession();
			
			session.setMaxInactiveInterval(20);
			
			session.setAttribute("login", login);
			if(login.getId() == 500) {
				return new BoardCommandAction("/admin.do", true);
			}else {
				return new BoardCommandAction("/main/main.jsp", true);
			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			return new BoardCommandAction("/main/main.jsp", true);
		}
		
			
		
			
		
		
	}

}
