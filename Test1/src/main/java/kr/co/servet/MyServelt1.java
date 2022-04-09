package kr.co.servet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServelt1
 */
@WebServlet("/hello") //얘는 디렉토리 방식 어제는 확장자형 방식
public class MyServelt1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServelt1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Get 방식 : hello");
		
		String name = request.getParameter("name");
				System.out.println(name);
		
			String[] arr = request.getParameterValues("hobby");
		
		
		PrintWriter out = response.getWriter();
		
		
		out.print("<html>");
		out.print("<body>");
		out.print("hello");
		out.print("<br>");
		
		for (int i = 0; i < arr.length; i++) {
		String hobby	= arr[i];
		out.print(hobby);
		out.print("<br>");
		}
		
		out.print("</body>");
		out.print("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Post 방식 : hello");
	String name	= request.getParameter("name");
	System.out.println(name);
	}

}
