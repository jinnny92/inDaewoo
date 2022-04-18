package kr.co.dw.member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dw.member.command.Command;
import kr.co.dw.member.command.DeleteCommand;
import kr.co.dw.member.command.DeleteUICommand;
import kr.co.dw.member.command.FindDTOByidCommand;
import kr.co.dw.member.command.InsertCommand;
import kr.co.dw.member.command.InsertUICommand;
import kr.co.dw.member.command.ListCommand;
import kr.co.dw.member.command.UpdateCommand;
import kr.co.dw.member.command.UpdateUICommand;
import kr.co.dw.member.dto.CommanAction;

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
		menus.put("/finddtobyid.do", new FindDTOByidCommand());
		menus.put("/update.do", new UpdateCommand());
		menus.put("/updateui.do", new UpdateUICommand());
		menus.put("/delete.do", new DeleteCommand());
		menus.put("/deleteui.do", new DeleteUICommand());
		
		
		
		
		String what = request.getServletPath();
		System.out.println(what);
		
		Command com = menus.get(what);
		
		if (com!= null) {
			CommanAction action = com.execute(request, response);
			if (action.isRedirect()) {
				response.sendRedirect(action.getWhere());
			}else {
				RequestDispatcher dis = request.getRequestDispatcher(action.getWhere());
				dis.forward(request, response);
			}
			
		} else {
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
