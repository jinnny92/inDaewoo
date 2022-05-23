package kr.co.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.board.command.BoardInsertCommand;
import kr.co.board.command.BoardListCommand;
import kr.co.board.command.BoardReadCommand;
import kr.co.board.command.BoardInsertUICommand;
import kr.co.domain.CommandAction;
import kr.co.main.MainUICommand;
import kr.co.member.command.DeleteMemberCommand;
import kr.co.member.command.DeleteUIMemberCommand;
import kr.co.member.command.FindDTOByIDCommand;
import kr.co.member.command.InsertMemberCommand;
import kr.co.member.command.InsertUIMemberCommand;
import kr.co.member.command.ListMemberCommand;
import kr.co.member.command.UpdateMemberCommand;
import kr.co.member.command.UpdateUIMemberCommand;
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
			menu.put("/main.do", new MainUICommand());
			menu.put("/member/insert.do", new InsertMemberCommand());
			menu.put("/member/insertui.do", new InsertUIMemberCommand());
			menu.put("/member/list.do", new ListMemberCommand());
			menu.put("/member/finddtobyid.do", new FindDTOByIDCommand());
			menu.put("/member/update.do", new UpdateMemberCommand());
			menu.put("/member/updateui.do", new UpdateUIMemberCommand());
			menu.put("/member/delete.do", new DeleteMemberCommand());
			menu.put("/member/deleteui.do", new DeleteUIMemberCommand());
			
			menu.put("/board/insert.do", new BoardInsertCommand());
			menu.put("/board/insertui.do", new BoardInsertUICommand());
			menu.put("/board/list.do", new BoardListCommand());
			menu.put("/board/read.do", new BoardReadCommand());
			
			
			
			
			
			
			
			String what = request.getServletPath();
			MenuCommand com = menu.get(what);
			
			if (com != null) {
				CommandAction action = com.execute(request, response);
				if (action.isRedirect()) {
					response.sendRedirect(action.getWhere());
				} else {
					request.getRequestDispatcher(action.getWhere()).forward(request, response);
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
