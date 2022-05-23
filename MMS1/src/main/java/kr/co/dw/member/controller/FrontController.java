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
@WebServlet("*.do") //슬래쉭 들어갔다는 이야기는 디렉토리 라는뜻
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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Map<String, Command> menus = new HashMap<String, Command>();
		menus.put("/list.do", new ListCommand());
		menus.put("/insertui.do", new InsertUICommand());
		menus.put("/insert.do", new InsertCommand());
		menus.put("/updateui.do",new UpdateUICommand());
		menus.put("/update.do",new UpdateCommand());
		menus.put("/deleteui.do",new DeleteUICommand());
		menus.put("/delete.do",new DeleteCommand());
		
		
		 //사용자가 요청한 서비스 추출
		String what = request.getServletPath();
		System.out.println(what);
		
	
		 //서비스 메뉴에 사용자가 요청하는 서비스가 있는지 확인
		Command com = menus.get(what);
		
		if (com != null) { //사용자가 요청한 서비스가 있을 때
				CommandAction action =  com.execute(request, response);
			if (action.isRedirect()) {
				response.sendRedirect(action.getWhere());
			}else {
			RequestDispatcher dis = request.getRequestDispatcher(action.getWhere());
			dis.forward(request, response); //어디로 갈지 실제로 포워딩되는코드
			}
			
		} else { //사용자가 요청한 서비스가 없을 때
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
