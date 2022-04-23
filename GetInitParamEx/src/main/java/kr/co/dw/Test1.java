package kr.co.dw;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Test1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	String id = getInitParameter("id");
	String pw = getInitParameter("pw");
		
	
		ServletContext application = getServletContext(); //자바코드에선 Servletcontext는 프로젝트임(jsp에선 application)
		String url = application.getInitParameter("url");
		String user = application.getInitParameter("user");
		
		application.setAttribute("count", 1);
		
		
		response.getWriter()
		.append("Served at: ")
		.append("초기화 파라미터 학습")
		.append(id)
		.append(pw)
		.append(url)
		.append(user);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
