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
import kr.co.dw.member.command.FindDTOById;
import kr.co.dw.member.command.InsertCommand;
import kr.co.dw.member.command.InsertUICommand;
import kr.co.dw.member.command.ListCommand;
import kr.co.dw.member.command.UpdateCommand;
import kr.co.dw.member.command.UpdateUICommand;
import kr.co.dw.member.dto.CommandAction;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do") //FrontController패턴은 주로 확장자형 패턴일 때 사용/  /하고 어떤 이름이 나오면 보통 디렉터리 패턴임
//*.do 등등이라고쓰면 확장자형 패턴 : 어떤 요청이든간에 ~~.do로 끝나면 FrontController로 들어와라 라는 뜻 
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//서비스하는 메뉴 등록
		
		Map<String, Command> menus = new HashMap<String, Command>();
		//Map : 인덱션을 우리 마음대로 지정할 수 있는 자바 컬렉션 프레임 워크중 하나
		//key는 string 값으로는 command를 갖다가 저장하겠다는 의미
		menus.put("/list.do", new ListCommand());
		//put은 what을 넣어야하는데 우선 메뉴를 등록해야해서. 
		//클라이언트가 넘겨준 데이터를 비교해서 갖다가 어떤 command객체를 갖다가 넣을건지 정함
		menus.put("/insertui.do", new InsertUICommand());
		menus.put("/insert.do", new InsertCommand());
		menus.put("/updateui.do", new UpdateUICommand());
		menus.put("/update.do", new UpdateCommand());
		menus.put("/deleteui.do", new DeleteUICommand());
		menus.put("/delete.do", new DeleteCommand());
		menus.put("/finddtobyid.do", new FindDTOById());
		
		//사용자가 요청한 서비스 추출
		String what = request.getServletPath(); //클라이언트가 입력한 값 가져오기
		System.out.println(what);
		
		//서비스 메뉴에 사용자가 요청하는 서비스가 있는지 확인
		Command com  = menus.get(what);
		
		
		if (com != null) {// 사용자가 요청한 서비스가 있을 때 
			CommandAction action =	com.execute(request, response);
			
			if (action.isRedirect()) {
				response.sendRedirect(action.getWhere());
			} else {
			RequestDispatcher dis	= request.getRequestDispatcher(action.getWhere());
			dis.forward(request, response);
			}
		}else {// 사용자가 요청한 서비스가 없을 때 
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
