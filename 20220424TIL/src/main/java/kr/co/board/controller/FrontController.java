package kr.co.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
		
		String what = request.getServletPath(); //request.getServletPath(); 클라이언트의 요청사항 추출하기
		
		BoardCommand bCommand = menus.get(what.toLowerCase()); 
		//메뉴에 클라이언트가 요구한 게 있는지 확인하기 menus.get(what);이걸로 넘겨받는데 toLowerCase()을 넣으면 클라이언트가 대소문자 넘겨줘도 소문자로 처리됨
		//BoardCommand를 넘겨받음
		
		if (bCommand != null) {
				BoardCommandAction bAction= bCommand.execute(request, response);
				if (bAction.isRedirect()) {
						response.sendRedirect(bAction.getWhrer());
				} else {
					request.getRequestDispatcher(bAction.getWhrer());
				}
		}else {
			
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
