package kr.co.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import kr.co.domain.CommandAction;
import kr.co.member.command.DeleteCommand;
import kr.co.member.command.DeleteUICommand;
import kr.co.member.command.FindDTOByIdCommand;
import kr.co.member.command.InsertUICommand;
import kr.co.member.command.ListCommand;
import kr.co.member.command.UpdateCommand;
import kr.co.member.command.UpdateUICommand;
import kr.co.member.command.insertCommand;
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
		Map<String, MenuCommand> menus = new HashMap<String, MenuCommand>();
		
//		menus.put("/board/insertui.do", new InsertUIBoardCommand());
//		menus.put("/board/insert.do", new InsertBoardCommand());
//		menus.put("/board/list.do", new ListBoardCommand());
//		menus.put("/board/read.do", new ReadBoardCommand());
//		menus.put("/board/updateui.do", new UpdateUIBoardCommand());
//		menus.put("/board/update.do", new UpdateBoardCommand());
//		menus.put("/board/loginui.do", new LoginBoardUICommand());
//		menus.put("/board/login.do", new LoginBoardCommand());
//		menus.put("/board/delete.do", new DeleteBoardCommand());
//		menus.put("/board/replyui.do", new ReplyUIBoardCommand());
//		menus.put("/board/reply.do", new ReplyBoardCommand());
//		menus.put("/board/search.do", new SearchBoardCommand());
		
		menus.put("/member/list.do",  new ListCommand());
		menus.put("/member/insertui.do", new InsertUICommand());
		menus.put("/member/insert.do",new insertCommand());
		menus.put("/member/updateui.do", new UpdateUICommand());
		menus.put("/member/update.do", new UpdateCommand());		
		menus.put("/member/deleteui.do",new DeleteUICommand());
		menus.put("/member/delete.do", new DeleteCommand());
		menus.put("/member/finddtobyid.do", new FindDTOByIdCommand());
		
		String what = request.getServletPath();
		
		MenuCommand com = menus.get(what.toLowerCase());
		
		if(com != null) {
			CommandAction action = com.execute(request, response);
			
			if(action.isRedirect()) {
				
				response.sendRedirect(action.getWhere());
				
			}else {
				request.getRequestDispatcher(action.getWhere())
				.forward(request, response);
			}
		}else {
			request.getRequestDispatcher("/jsp/noserviceinfo.jsp")
			.forward(request, response);
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
