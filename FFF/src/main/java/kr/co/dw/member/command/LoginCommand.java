package kr.co.dw.member.command;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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

		String id = request.getParameter("id");
		System.out.println(id);
		String pw = request.getParameter("pw");
		String url = request.getParameter("url");
		MemberDAO dao = new MemberDAO();

		MemberDTO login = dao.login(new MemberDTO(id, pw, null, null, null, null));
		if (login == null) {
			PrintWriter out = response.getWriter();
			out.println("<script>alert('잘못된 정보를 입력하셨습니다.');history.back();</script>");

		}
		HttpSession session = request.getSession(false);

		url = url.substring(21);
		session.setMaxInactiveInterval(200);
		session.setAttribute("login", login);
		System.out.println(url);
		if (login.getId().equals("admin")) {
			return new BoardCommandAction("/admin.do", true);
		} else if (url.equals("/member/jsp/admin.jsp")) {
			return new BoardCommandAction("/board/main.do", true);
		} else if (url.equals("/board/updateui.do")) {
			return new BoardCommandAction("/board/main.do", true);
		} else {
			return new BoardCommandAction(url, true);
		}

	}

}
