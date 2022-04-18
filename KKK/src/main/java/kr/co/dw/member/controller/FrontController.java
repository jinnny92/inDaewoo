package kr.co.dw.member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dw.member.command.Command;
import kr.co.dw.member.command.DeleteCommand;
import kr.co.dw.member.command.DeleteUICommand;
import kr.co.dw.member.command.FindDTOByIDCommand;
import kr.co.dw.member.command.InsertCommand;
import kr.co.dw.member.command.InsertUICommand;
import kr.co.dw.member.command.ListCommand;
import kr.co.dw.member.command.UpdateCommand;
import kr.co.dw.member.command.UpdateUICommand;
import kr.co.dw.member.dto.CommandAction;

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
		Map<String, Command> menus = new HashMap<String, Command>();
		menus.put("/list.do", new ListCommand());
		menus.put("/insert.do", new InsertCommand());
		menus.put("/insertui.do", new InsertUICommand());	
		menus.put("/finddtobyid.do", new FindDTOByIDCommand());
		menus.put("/updateui.do", new UpdateUICommand());
		menus.put("/update.do", new UpdateCommand());
		menus.put("/deleteui.do", new DeleteUICommand());
		menus.put("/delete.do", new DeleteCommand());
		
		
		String what = request.getServletPath();
		
		Command com = menus.get(what);
		
		if(com != null) {
			CommandAction action = com.execute(request, response);
			
			if(action.isRedirect()) {
				response.sendRedirect(action.getWhere());
			}else {
				request.getRequestDispatcher(action.getWhere()).forward(request, response);
			}
		}else {
			request.getRequestDispatcher("noservice.jsp").forward(request, response);
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
