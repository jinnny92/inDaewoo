package kr.co.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.board.command.BoardCommand;
import kr.co.board.command.InsertBoardCommand;
import kr.co.board.command.InsertUIBoardCommand;
import kr.co.board.command.ListBoardCommand;
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
		
		
		
		String what = request.getServletPath();
		
	
		BoardCommand bCommand = menus.get(what.toLowerCase()); //클라이언트가 요구하는 서비스가 있는지 확인 toLowerCase()클라이언트가 막 입력해도 소문자로 받음
		
		if (bCommand != null) {
			BoardCommandAction bAction = bCommand.execute(request, response);
			if (bAction.isRedirect()) {
				response.sendRedirect(bAction.getWhere());
			} else {
				RequestDispatcher dis = request.getRequestDispatcher(bAction.getWhere());
						dis.forward(request, response);
				
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
