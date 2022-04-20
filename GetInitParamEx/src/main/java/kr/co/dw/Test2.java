package kr.co.dw;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test2
 */
@WebServlet("/Test2")
public class Test2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	String id =	getInitParameter("id");
	String pw = getInitParameter("pw");
	
	ServletContext application = getServletContext();
	String url = application.getInitParameter("url");
	String user = application.getInitParameter("user");
	

	Integer count = (Integer)application.getAttribute("count");
	
	if (count == null) {
		count = 0;
	}
	
		response.getWriter().append("Served at: ")
		.append("test")
		.append(id)
		.append(pw)
		.append(url)
		.append(user)
		.append("<br>")
		.append(count+"");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
