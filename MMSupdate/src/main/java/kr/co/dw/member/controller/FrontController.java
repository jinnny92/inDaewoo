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
import kr.co.dw.member.command.InsertCommand;
import kr.co.dw.member.command.InsertUICommand;
import kr.co.dw.member.command.ListCommand;
import kr.co.dw.member.command.UpdateCommand;
import kr.co.dw.member.command.UpdateUICommand;
import kr.co.dw.member.dto.CommandAction;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do") //모든 요청이 아닌 ~.do에관한것만 
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
		// TODO Auto-generated method stub 클라이언트가 요청하는 게 문자열로 들어오니까 MAP으로 그전엔 숫자를 넣어서 배열로
		Map<String, Command> menus = new HashMap<String, Command>();
		menus.put("/list.do", new ListCommand());
		menus.put("/insertui.do", new InsertUICommand());
		menus.put("/insert.do", new InsertCommand());
		menus.put("/updateui.do", new UpdateUICommand());
		menus.put("/update.do", new UpdateCommand());
		menus.put("/deleteui.do", new DeleteUICommand());
		menus.put("/delete.do", new DeleteCommand());
		
		
		
		String what = request.getServletPath();
		System.out.println(what);
		
		Command com = menus.get(what);
		
		if (com != null) {
			CommandAction action = com.execute(request, response);
			
			if (action.isRedirect()) {
				response.sendRedirect(action.getWhere());
				
			} else {
				RequestDispatcher dis = request.getRequestDispatcher(action.getWhere());
				dis.forward(request, response);
			}
			
			
		} else {
			response.getWriter().print("지원하지 않는 서비스입니다");
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
