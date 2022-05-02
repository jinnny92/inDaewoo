package kr.co.b.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import kr.co.b.dao.bDAO;
import kr.co.domain.CommandAction;
import kr.co.domain.bDTO;
import kr.co.domain.mDTO;
import kr.co.menu.MenuCommand;

public class InsertBoardCommand implements MenuCommand {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		String title = request.getParameter("title");
		
		String content = request.getParameter("content");
		
		
		
		HttpSession session = request.getSession();
		
		mDTO login = (mDTO)session.getAttribute("login");
		)
		String a = login.getId();
		
		bDAO bdao = new bDAO();
		
		bdao.insert(new bDTO(0, null , title, content));
		 
		
		return new CommandAction("/Board/list.do", true);
	}

}
