package kr.co.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.command.Command;
import kr.co.command.MemberGradeCommadn;
import kr.co.command.MemberListCommand;
import kr.co.command.VoteInsertCommand;
import kr.co.command.VoteInsertUICommand;
import kr.co.command.VoteListCommand;
import kr.co.domain.CommandAction;

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
		Map<String, Command> menuMap = new HashMap<String, Command>();
		
		menuMap.put("/member/list.do", new MemberListCommand());
		menuMap.put("/vote/insertui.do", new VoteInsertUICommand());
		menuMap.put("/vote/insert.do", new VoteInsertCommand());
		menuMap.put("/vote/list.do", new VoteListCommand());
		menuMap.put("/member/grade.do", new MemberGradeCommadn());
		
		String what = request.getServletPath();
		
		Command menu = menuMap.get(what);
		
		if (menu != null) {
				
			CommandAction action = menu.execute(request, response);
			if (action.isRedirect()) {
				
				response.sendRedirect(action.getWhere());
				
			} else {
				request.getRequestDispatcher(action.getWhere()).forward(request, response);
			}
			
		} else {
			
			request.getRequestDispatcher("/error/error.jsp").forward(request, response);
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
