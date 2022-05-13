package kr.co.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.board.command.DeleteBoardCommand;
import kr.co.board.command.InsertBoardCommand;
import kr.co.board.command.InsertUIBoardCommand;
import kr.co.board.command.ListBoardCommand;
import kr.co.board.command.ReadBoardCommand;
import kr.co.board.command.ReplyBoardCommand;
import kr.co.board.command.ReplyUIBoardCommand;
import kr.co.board.command.SearchBoardCommand;
import kr.co.board.command.UpdateBoardCommand;
import kr.co.board.command.UpdateUIBoardCommand;
import kr.co.domain.CommandAction;
import kr.co.member.command.DeleteMemberommand;
import kr.co.member.command.FindDTOByidCommand;
import kr.co.member.command.InsertMemberCommand;
import kr.co.member.command.InsertUIMemberCommand;
import kr.co.member.command.ListMemberCommand;
import kr.co.member.command.LoginMemberCommand;
import kr.co.member.command.LoginUIMemberCommand;
import kr.co.member.command.LogoutMemberCommand;
import kr.co.member.command.UpdateMemberCommand;
import kr.co.member.command.UpdateUIMemberommand;
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
			menu.put("/member/find.do", new FindDTOByidCommand());
			menu.put("/member/update.do", new UpdateMemberCommand());
			menu.put("/member/updateui.do", new UpdateUIMemberommand());
			menu.put("/member/delete.do", new DeleteMemberommand());
			menu.put("/member/loginui.do", new LoginUIMemberCommand());
			menu.put("/member/login.do", new LoginMemberCommand());
			menu.put("/member/logout.do", new LogoutMemberCommand());
			
			
			
			
			
			
			
			menu.put("/board/insert.do", new InsertBoardCommand());
			menu.put("/board/insertui.do", new InsertUIBoardCommand());
			menu.put("/board/list.do", new ListBoardCommand());
			menu.put("/board/read.do", new ReadBoardCommand());
			menu.put("/board/update.do", new UpdateBoardCommand());
			menu.put("/board/updateui.do", new UpdateUIBoardCommand());
			menu.put("/board/delete.do", new DeleteBoardCommand());
			menu.put("/board/reply.do", new ReplyBoardCommand());
			menu.put("/board/replyui.do", new ReplyUIBoardCommand());
			menu.put("/board/search.do", new SearchBoardCommand());
			
			
			
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
