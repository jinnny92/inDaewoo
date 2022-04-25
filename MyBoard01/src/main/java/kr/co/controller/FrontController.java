package kr.co.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.board.command.BoardCommand;
import kr.co.board.command.DeleteBoardCommand;
import kr.co.board.command.InsertBoardCommand;
import kr.co.board.command.InsertUIBoardCommand;
import kr.co.board.command.ListBoardCommand;
import kr.co.board.command.ReadBoardCommand;
import kr.co.board.command.ReplyBoardCommand;
import kr.co.board.command.ReplyUIBoardCommand;
import kr.co.board.command.UpdateBoardCommand;
import kr.co.board.command.UpdateuiBoardCommand;
import kr.co.board.domain.BoardCommandAction;

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
		Map<String, BoardCommand> menus = new HashMap<String, BoardCommand>();
	
		menus.put("/board/insertui.do", new InsertUIBoardCommand());
		menus.put("/board/insert.do", new InsertBoardCommand());
		menus.put("/board/list.do", new ListBoardCommand());
		menus.put("/board/read.do", new ReadBoardCommand());
		menus.put("/board/updateui.do", new UpdateuiBoardCommand());
		menus.put("/board/update.do", new UpdateBoardCommand());
		menus.put("/board/delete.do", new DeleteBoardCommand());
		menus.put("/board/replyui.do", new ReplyUIBoardCommand());
		menus.put("/board/reply.do", new ReplyBoardCommand());
		
		
		
		String what = request.getServletPath();
		
		
		BoardCommand bCommand = menus.get(what.toLowerCase());
		
		if(bCommand != null) {
			BoardCommandAction bAction = bCommand.execute(request, response);
			if(bAction.isRedirect()) {
				response.sendRedirect(bAction.getWhere());
			}else {
				request.getRequestDispatcher(bAction.getWhere())
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
