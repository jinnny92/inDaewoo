package kr.co.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.b.command.InsertBoardCommand;
import kr.co.b.command.InsertUIBoardCommand;
import kr.co.domain.CommandAction;
import kr.co.m.command.DeleteMemberCommand;
import kr.co.m.command.DeleteUIMemberCommand;
import kr.co.m.command.FindDTOByIDUIMemberCommand;
import kr.co.m.command.InsertMemberCommand;
import kr.co.m.command.InsertUIMemberCommand;
import kr.co.m.command.ListMemberCommand;
import kr.co.m.command.LoginMemberCommand;
import kr.co.m.command.LoginUIMemberCommand;
import kr.co.m.command.LogoutMemberCommand;
import kr.co.m.command.UpdateMemberCommand;
import kr.co.m.command.UpdateUIMemberCommand;
import kr.co.menu.MenuCommand;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, MenuCommand> menu = new HashMap<String, MenuCommand>();
		
		menu.put("/member/insert.do", new InsertMemberCommand());
		menu.put("/member/insertui.do", new InsertUIMemberCommand());
		menu.put("/member/list.do", new ListMemberCommand());
		menu.put("/member/update.do", new UpdateMemberCommand());
		menu.put("/member/updateui.do", new UpdateUIMemberCommand());
		menu.put("/member/finddtobyid.do", new FindDTOByIDUIMemberCommand());
		menu.put("/member/delete.do", new DeleteMemberCommand());
		menu.put("/member/deleteui.do", new DeleteUIMemberCommand());
		menu.put("/member/login.do", new LoginMemberCommand());
		menu.put("/member/loginui.do", new LoginUIMemberCommand());
		menu.put("/member/logout.do", new LogoutMemberCommand());
		
		menu.put("/board/insertui.do", new InsertUIBoardCommand());
		menu.put("/board/insert.do", new InsertBoardCommand());
//		menu.put("/board/list.do", new ListBoardCommand());
//		menu.put("/board/read.do", new ReadBoardCommand());
//		menu.put("/board/updateui.do", new UpdateUIBoardCommand());
//		menu.put("/board/update.do", new UpdateBoardCommand());
//		menu.put("/board/loginui.do", new LoginBoardUICommand());
//		menu.put("/board/login.do", new LoginBoardCommand());
//		menu.put("/board/delete.do", new DeleteBoardCommand());
//		menu.put("/board/replyui.do", new ReplyUIBoardCommand());
//		menu.put("/board/reply.do", new ReplyBoardCommand());
//		menu.put("/board/search.do", new SearchBoardCommand());
//		
		
		String what	= request.getServletPath();
		
		MenuCommand com = menu.get(what.toLowerCase());
		
		if(com != null) {
			CommandAction action = com.execute(request, response);
			
			if(action.isRedirect()) {
				
				response.sendRedirect(action.getWhere());
				
			}else {
				request.getRequestDispatcher(action.getWhere())
				.forward(request, response);
			}
			
		} else {
			request.getRequestDispatcher("/jsp/noserviceinfo.jsp").forward(request, response);
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
